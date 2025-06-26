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
}