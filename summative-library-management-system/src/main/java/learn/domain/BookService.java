package learn.domain;

import learn.data.BookFileRepository;
import learn.data.BookRepository;
import learn.data.DataAccessException;
import learn.models.Book;

import java.util.ArrayList;
import java.util.List;

public class BookService {
    private final BookRepository repository;
    private int MAXSHELVES = 250;
    private int MAXPOSITIONS = 250;
    private int CURRENTYEAR = 2025;

    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    public List<Book> findByCategory(String category) throws DataAccessException {
        return repository.findByCategory(category);
    }

    public BookResult add(Book book) throws DataAccessException {
        BookResult result = validate(book);

        List<Book> all = repository.findAll();
        for (Book b : all) {
            if (b.getIsbn().equalsIgnoreCase(book.getIsbn())) {
                result.addErrorMessage("ISBN is not unique.");
            }
        }

        if (result.isSuccess()) {
            book = repository.add(book);
            result.setBook(book);
        }
        return result;
    }

    public BookResult update(Book book) throws DataAccessException {
        BookResult result = validate(book);

        if (result.isSuccess()) {
            if (repository.update(book)) {
                result.setBook(book);
            } else {
                String message = String.format("Book isbn %s was not found.", book.getIsbn());
                result.addErrorMessage(message);
            }
        }
        return result;
    }

    public BookResult deleteByIsbn(String isbn) throws DataAccessException {
        BookResult result = new BookResult();
        if (!repository.deleteByIsbn(isbn)) {
            String message = String.format("Book isbn %s was not found.", isbn);
            result.addErrorMessage(message);
        }
        return result;
    }

    private BookResult validate(Book book) throws DataAccessException {
        BookResult result = new BookResult();

        if (book == null) {
            result.addErrorMessage("Book cannot be null");
            return result;
        }

        if (book.getCategory() == null || book.getCategory().isBlank()) {
            result.addErrorMessage("Book `category` is required.");
        }

        if (book.getShelfNumber() <= 0 || book.getShelfNumber() > MAXSHELVES) {
            result.addErrorMessage("Book `shelf` must be between 1 and " + MAXSHELVES + ".");
        }

        if (book.getPositionNumber() <= 0 || book.getPositionNumber() > MAXPOSITIONS) {
            result.addErrorMessage("Book `position` must be between 1 and " + MAXPOSITIONS + ".");
        }

        if (book.getYearPublished() >= CURRENTYEAR) {
            result.addErrorMessage("Book `published year` must be from " + (CURRENTYEAR - 1) + " or older.");
        }

        if (book.getTitle() == null || book.getTitle().isBlank()) {
            result.addErrorMessage("Book `Title` is required.");
        }

        if (book.getAuthor() == null || book.getAuthor().isBlank()) {
            result.addErrorMessage("Book `Author` is required.");
        }

        if (book.getIsbn() == null || book.getIsbn().isBlank()) {
            result.addErrorMessage("Book `ISBN` is required.");
        }

        List<Book> all = repository.findAll();
        for (Book b : all) {
            if (b.getIsbn().equalsIgnoreCase(book.getIsbn())) {
                result.addErrorMessage("ISBN is not unique.");
            }
        }

        return result;
    }
}
