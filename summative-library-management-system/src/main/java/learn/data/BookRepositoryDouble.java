package learn.data;

import learn.models.Book;

import java.util.ArrayList;
import java.util.List;

public class BookRepositoryDouble implements BookRepository {
    private ArrayList<Book> books = new ArrayList<>();

    public BookRepositoryDouble() {
        books.add(new Book("Fantasy", 1, 1, 2007, "Book1", "Author1", "123456"));
        books.add(new Book("Fantasy", 1, 2, 2007, "Book2", "Author2", "78910"));
        books.add(new Book("Fantasy", 1, 3, 2007, "Book3", "Author3", "123456789"));

        books.add(new Book("Non-Fiction", 1, 1, 1998, "Book4", "Author4", "654321"));
        books.add(new Book("Non-Fiction", 1, 2, 2007, "Book5", "Author5", "109876"));
    }

    @Override
    public List<Book> findAll() throws DataAccessException {
        return new ArrayList<>(books);
    }

    @Override
    public List<Book> findByCategory(String category) throws DataAccessException {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getCategory().equalsIgnoreCase(category)) {
                result.add(book);
            }
        }
        return result;
    }

    @Override
    public Book findByIsbn(String isbn) throws DataAccessException {
        List<Book> all = findAll();
        for (Book book : all) {
            if (book.getIsbn().equalsIgnoreCase(isbn)) {
                return book;
            }
        }
        return null;    }

    @Override
    public Book findByLocation(String category, int shelfNumber, int positionNumber) throws DataAccessException {
        return null;
    }

    @Override
    public Book add(Book book) throws DataAccessException {
        return null;
    }

    @Override
    public boolean update(Book book) throws DataAccessException {
        return false;
    }

    @Override
    public boolean deleteByIsbn(String isbn) throws DataAccessException {
        return false;
    }
}
