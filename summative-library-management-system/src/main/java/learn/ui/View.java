package learn.ui;

import learn.models.Book;
import java.util.List;

public class View {
    private final TextIO io;

    public View(TextIO io) {
        this.io = io;
    }

    public int chooseMenuOption() {
        displayHeader("Main Menu");
        io.println("1. View Books");
        io.println("2. Add a Book");
        io.println("3. Update a Book");
        io.println("4. Delete a Book");
        io.println("5. Exit");
        return io.readInt("Choose [1-5]:", 1, 5);
    }

    public Book chooseBook(List<Book> books) {
        displayBooks(books);
        Book result = null;
        if (!books.isEmpty()) {
            String bookIsbn = io.readString("Choose a Book ISBN:");
            for (Book b : books) {
                if (b.getIsbn().equalsIgnoreCase(bookIsbn)) {
                    result = b;
                    break;
                }
            }
        }
        return result;
    }

    public void displayHeader(String message) {
        int length = message.length();
        io.println("");
        io.println(message);
        io.println("=".repeat(length));
    }

    public void displayErrors(List<String> errors) {
        displayHeader("Errors: ");
        for (String error : errors) {
            io.println(error);
        }
    }

    public void displayBooks(List<Book> books) {
        if (books.isEmpty()) {
            displayHeader("No Books Found.");
        } else {
            displayHeader("Books:");
            for (Book book : books) {
                displayHeader(book.getTitle());
                io.printf("Category: %-8s | Shelf: %d | Position: %d%nYear Published: %d%nAuthor: %s%nISBN: %s%n"
                        , book.getCategory(), book.getShelfNumber(), book.getPositionNumber(), book.getYearPublished(),
                        book.getAuthor(), book.getIsbn());
            }
        }
    }

    public void displayMessage(String message) {
        io.println("");
        io.println(message);
    }

    public Book createBook() {
        displayHeader("Add a Book");
        return new Book(
                io.readString("Category: "),
                io.readInt("Shelf Number: "),
                io.readInt("Position Number: "),
                io.readInt("Year Published: "),
                io.readString("Title: "),
                io.readString("Author: "),
                io.readString("ISBN: ")
        );
    }

    public Book editBook(Book b) {
        displayHeader("Update");

        String category = io.readString("Category (" + b.getCategory() + "): ");
        // only update if it changed
        if (!category.trim().isEmpty()) {
            b.setCategory(category);
        }

        int shelfNumber = io.readInt("Shelf Number (" + b.getShelfNumber() + "): ");
        if (shelfNumber > 0 && shelfNumber <= 250) {
            b.setShelfNumber(shelfNumber);
        }

        int positionNumber = io.readInt("Position Number (" + b.getPositionNumber() + "): ");
        if (positionNumber > 0 && positionNumber <= 250) {
            b.setPositionNumber(positionNumber);
        }

        int publishYear = io.readInt("Year Published (" + b.getYearPublished() + "): ");
        if (publishYear > 0 && publishYear < 2025) {
            b.setPositionNumber(positionNumber);
        }

        String title = io.readString("Title (" + b.getTitle() + "): ");
        // only update if it changed
        if (!title.trim().isEmpty()) {
            b.setTitle(title);
        }
        String author = io.readString("Author (" + b.getAuthor() + "): ");
        // only update if it changed
        if (!author.trim().isEmpty()) {
            b.setAuthor(author);
        }

        String isbn = io.readString("ISBN (" + b.getIsbn() + "): ");
        // only update if it changed
        if (!isbn.trim().isEmpty()) {
            b.setIsbn(isbn);
        }

        return b;
    }
}
