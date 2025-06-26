package learn.data;

import learn.models.Book;

import java.util.List;

public interface BookRepository {

    List<Book> findAll() throws DataAccessException;

    List<Book> findByCategory(String category) throws DataAccessException;

    Book findByIsbn(String isbn) throws DataAccessException;

    Book findByLocation(String category, int shelfNumber, int positionNumber) throws DataAccessException;

    Book add(Book book) throws DataAccessException;

    boolean update(Book book) throws DataAccessException;

    boolean deleteByIsbn(String isbn) throws DataAccessException;

}
