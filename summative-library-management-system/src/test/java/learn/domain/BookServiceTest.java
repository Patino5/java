package learn.domain;

import learn.data.BookRepository;
import learn.data.BookRepositoryDouble;
import learn.data.DataAccessException;
import learn.models.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BookServiceTest {

    BookService service;

    @BeforeEach
    void setup() {
        BookRepositoryDouble repository = new BookRepositoryDouble();
        service = new BookService(repository);
    }

    // Test for BookService findByCategory method

    @Test
    void shouldFindTwoNonFictionBooks() throws DataAccessException {
        List<Book> books = service.findByCategory("Non-Fiction");
        assertEquals(2, books.size());
    }

    @Test
    void shouldFindThreeFantasyBooks() throws DataAccessException {
        List<Book> books = service.findByCategory("Fantasy");
        assertEquals(3, books.size());
    }

    // Test for BookService add method
    @Test
    void shouldNotAddNull() throws DataAccessException {
        Book book = new Book();

        BookResult result = service.add(book);

        assertFalse(result.isSuccess());
        assertEquals(7, result.getErrorMessages().size());
        assertTrue(result.getErrorMessages().getFirst().contains("`category`"));
    }

    @Test
    void shouldNotAddBookWithNonUniqueIsbn() throws DataAccessException {
        Book book = new Book();
        book.setIsbn("123456789");
        book.setCategory("Fantasy");
        book.setShelfNumber(3);
        book.setPositionNumber(55);
        book.setTitle("Harry Potter...");
        book.setAuthor("J.K. Rowling");
        book.setYearPublished(1998);

        BookResult result = service.add(book);

        assertFalse(result.isSuccess());
        assertEquals(1, result.getErrorMessages().size());
        System.out.println(result.getErrorMessages());
        assertTrue(result.getErrorMessages().getFirst().contains("`ISBN`"));
    }



    @Test
    void shouldNotAddBookWithAnyEmptyContent() throws DataAccessException {
        Book book = new Book();
        book.setIsbn("1234");
        book.setCategory("Fantasy");
        book.setShelfNumber(3);
        book.setPositionNumber(55);
        book.setTitle("Harry Potter...");
        book.setYearPublished(1998);

        BookResult result = service.add(book);

        assertFalse(result.isSuccess());
        assertEquals(1, result.getErrorMessages().size());
        assertTrue(result.getErrorMessages().getFirst().contains("`Author`"));
    }

    @Test
    void shouldNotAddBookWithShelfNumberGreaterThan250() throws DataAccessException {
        Book book = new Book();
        book.setIsbn("1234");
        book.setCategory("Fantasy");
        book.setShelfNumber(251);
        book.setPositionNumber(55);
        book.setTitle("Harry Potter...");
        book.setYearPublished(1998);
        book.setAuthor("J.K. Rowling");

        BookResult result = service.add(book);

        assertFalse(result.isSuccess());
        assertEquals(1, result.getErrorMessages().size());
        assertTrue(result.getErrorMessages().getFirst().contains("`shelf`"));
    }

    @Test
    void shouldNotAddBookWithPositionNumberGreaterThan250() throws DataAccessException {
        Book book = new Book();
        book.setIsbn("1234");
        book.setCategory("Fantasy");
        book.setShelfNumber(21);
        book.setPositionNumber(255);
        book.setTitle("Harry Potter...");
        book.setYearPublished(1998);
        book.setAuthor("J.K. Rowling");

        BookResult result = service.add(book);

        assertFalse(result.isSuccess());
        assertEquals(1, result.getErrorMessages().size());
        assertTrue(result.getErrorMessages().getFirst().contains("`position`"));
    }

    @Test
    void shouldNotAddBookPublishedLaterThan2024() throws DataAccessException {
        Book book = new Book();
        book.setIsbn("1234");
        book.setCategory("Fantasy");
        book.setShelfNumber(21);
        book.setPositionNumber(55);
        book.setTitle("Harry Potter...");
        book.setYearPublished(2026);
        book.setAuthor("J.K. Rowling");

        BookResult result = service.add(book);

        assertFalse(result.isSuccess());
        assertEquals(1, result.getErrorMessages().size());
        assertTrue(result.getErrorMessages().getFirst().contains("`published year`"));
    }

    @Test
    void shouldAdd() throws DataAccessException {
        Book book = new Book();
        book.setIsbn("0451524935");
        book.setCategory("Fantasy");
        book.setShelfNumber(21);
        book.setPositionNumber(55);
        book.setTitle("Harry Potter...");
        book.setYearPublished(1998);
        book.setAuthor("J.K. Rowling");

        BookResult result = service.add(book);

        assertTrue(result.isSuccess());
        assertEquals(0, result.getErrorMessages().size());
    }

    @Test
    void shouldNotUpdateEmptyContent() throws DataAccessException {
        Book book = service.findByCategory("Fantasy").getFirst();
        book.setAuthor("\n");
        BookResult result = service.update(book);

        assertFalse(result.isSuccess());
        assertEquals(1, result.getErrorMessages().size());
        assertTrue(result.getErrorMessages().getFirst().contains("`Author`"));
    }

    @Test
    void shouldUpdate() throws DataAccessException {
        Book book = service.findByCategory("Fantasy").getFirst();
        book.setAuthor("updated Author");

        BookResult result = service.update(book);
        assertTrue(result.isSuccess());
    }
}