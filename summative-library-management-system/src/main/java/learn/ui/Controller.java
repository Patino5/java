package learn.ui;

import learn.data.DataAccessException;
import learn.domain.BookResult;
import learn.domain.BookService;
import learn.models.Book;

import java.util.List;

public class Controller {
    private final View view;
    private final BookService service;

    public Controller(View view, BookService service) {
        this.view = view;
        this.service = service;
    }

    public void run() {
        view.displayHeader("Welcome to Library Manager");
        try {
            runApp();
        } catch (DataAccessException e) {
            view.displayErrors(List.of(e.getMessage()));
        }
    }

    private void runApp() throws DataAccessException {
        for (int option = view.chooseMenuOption(); option > 0; option = view.chooseMenuOption()) {
            switch (option) {
                case 1 -> viewBooks();
                case 2 -> addBook();
                case 3 -> updateBook();
                case 4 -> deleteBook();
                case 5 -> System.exit(0);
            }
        }
    }

    private void viewBooks() throws DataAccessException {
        List<Book> books = getBooks("View Books");
        view.displayBooks(books);
    }

    private void addBook() throws DataAccessException {
        Book b = view.createBook();
        BookResult result = service.add(b);
        if (result.isSuccess()) {
            view.displayMessage("Book " + result.getBook().getTitle() + " created.");
        } else {
            view.displayErrors(result.getErrorMessages());
        }
    }

    private void updateBook() throws DataAccessException {
        List<Book> books = getBooks("Update a Book");
        Book b = view.chooseBook(books);
        if (b == null) {
            view.displayMessage("Book not found.");
            return;
        }
        b = view.editBook(b);
        BookResult result = service.update(b);
        if (result.isSuccess()) {
            view.displayMessage("Memory " + result.getBook().getTitle() + " updated.");
        } else {
            view.displayErrors(result.getErrorMessages());
        }
    }

    private void deleteBook() throws DataAccessException {
        List<Book> books = getBooks("Delete a Book");
        Book b = view.chooseBook(books);
        if (b != null && service.deleteByIsbn(b.getIsbn()).isSuccess()) {
            view.displayMessage("Book " + b.getTitle() + " deleted.");
        } else {
            view.displayMessage("Book not found.");
        }
    }

    private List<Book> getBooks(String title) throws DataAccessException {
        view.displayHeader(title);
        List<Book> books = service.findAll();
        view.displayBooks(books);
        return books;
    }
}