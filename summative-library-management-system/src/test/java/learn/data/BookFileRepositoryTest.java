package learn.data;

import learn.models.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.PreparedStatement;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BookFileRepositoryTest {

    static final String SEED_FILE_PATH = "./data/books-seed.txt";
    static final String TEST_FILE_PATH = "./data/book-test.txt";

    BookFileRepository repository = new BookFileRepository(TEST_FILE_PATH);

    @BeforeEach
    void setupTest() throws IOException {
        Path seedPath = Paths.get(SEED_FILE_PATH);
        Path testPath = Paths.get(TEST_FILE_PATH);
        Files.copy(seedPath, testPath, StandardCopyOption.REPLACE_EXISTING);
    }

    @Test
    void findAll() throws DataAccessException {
        List<Book> actual = repository.findAll();
        assertEquals(15, actual.size());
    }

    @Test
    void findByCategory() throws DataAccessException {
        List<Book> actual = repository.findByCategory("Fantasy");
        assertEquals(1, actual.size());

        actual = repository.findByCategory("Fiction");
        assertEquals(3, actual.size());
    }

    @Test
    void findByIsbn() throws DataAccessException {
        Book book = repository.findByIsbn("9780547928197");
        assertNotNull(book);
        assertEquals("The Return of the King", book.getTitle());
        assertEquals("J.R.R. Tolkien", book.getAuthor());

        book = repository.findByIsbn("23534");
        assertNull(book); // isbn does not exist
    }

    @Test
    void findByLocation() throws DataAccessException {
        Book book = repository.findByLocation("Fiction", 1, 3); //Fiction~1~3

        assertNotNull(book);
        assertEquals("The Return of the King", book.getTitle());
        assertEquals("J.R.R. Tolkien", book.getAuthor());

        book = repository.findByLocation("Fantasy", 234, 3);
        assertNull(book);
    }

    @Test
    void add() throws DataAccessException {
        Book book = new Book();
        book.setCategory("Fantasy");
        book.setShelfNumber(1);
        book.setPositionNumber(3);
        book.setYearPublished(2002);
        book.setTitle("A New Book");
        book.setAuthor("Me");
        book.setIsbn("123456789");

        Book actual = repository.add(book); // add a new book
        assertEquals("123456789", actual.getIsbn());

        List<Book> all = repository.findAll();
        assertEquals(16, all.size()); // should now be 16 books instead of 15 in the file

        actual = all.get(15); // the newly-added book
        assertEquals("123456789", actual.getIsbn()); // check isbn match
        assertEquals("Fantasy", actual.getCategory()); // confirm all fields
        assertEquals(1, actual.getShelfNumber());
        assertEquals(3, actual.getPositionNumber());
        assertEquals(2002, actual.getYearPublished());
        assertEquals("A New Book", actual.getTitle());
        assertEquals("Me", actual.getAuthor());
    }

    @Test
    void update() throws DataAccessException {
        Book book = repository.findByIsbn("9780547928197");
        book.setTitle("LOTR:The Return of the King");
        book.setPositionNumber(34);
        book.setShelfNumber(5);
        assertTrue(repository.update(book));

        book = repository.findByIsbn("9780547928197");
        assertNotNull(book);
        assertEquals("LOTR:The Return of the King", book.getTitle());
        assertEquals(34, book.getPositionNumber());
        assertEquals(5, book.getShelfNumber());

        Book doesNotExist = new Book();
        doesNotExist.setIsbn("1024");
        assertFalse(repository.update(doesNotExist));
    }

    @Test
    void deleteByIsbn() throws DataAccessException {
        int count = repository.findAll().size();
        assertTrue(repository.deleteByIsbn("9780547928197"));
        assertFalse(repository.deleteByIsbn("12345"));
        assertEquals(count - 1, repository.findAll().size());
    }
}