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
    void add() {
    }
}