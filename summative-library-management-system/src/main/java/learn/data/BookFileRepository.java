package learn.data;

import learn.models.Book;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BookFileRepository implements BookRepository {
    private final String filePath;
    private final String delimiter = "~";

    public BookFileRepository(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public List<Book> findAll() throws DataAccessException {
        ArrayList<Book> result = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            for (String line = reader.readLine(); line != null; line = reader.readLine()) {
                Book book = lineToBook(line);
                if (book != null) {
                    result.add(book);
                }
            }
        } catch (FileNotFoundException e) {
            // If file doesn't exist, we create it
        } catch (IOException e) {
            throw new DataAccessException("Could not open the file path: " + filePath, e);
        }
        return result;
    }

    @Override
    public List<Book> findByCategory(String category) throws DataAccessException {
        ArrayList<Book> result = new ArrayList<>();
        for (Book book : findAll()) {
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
        return null;
    }

    @Override
    public Book findByLocation(String category, int shelfNumber, int positionNumber) throws DataAccessException{
        List<Book> all = findAll();
        for (Book book : all) {
            if (book.getCategory().equalsIgnoreCase(category) && book.getShelfNumber() == shelfNumber && book.getPositionNumber() == positionNumber) {
                return book;
            }
        }
        return null;
    }

    @Override
    public Book add(Book book) throws DataAccessException {
        List<Book> all = findAll();
        all.add(book);
        writeToFile(all);
        return book;
    }

    @Override
    public boolean update(Book book) throws DataAccessException {
        List<Book> all = findAll();
        for (int i = 0; i < all.size(); i++) {
            if (all.get(i).getIsbn().equalsIgnoreCase(book.getIsbn())){
                all.set(i, book);
                writeToFile(all);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean deleteByIsbn(String isbn) throws DataAccessException {
        List<Book> all = findAll();
        for (int i = 0; i < all.size(); i++){
            if (all.get(i).getIsbn().equalsIgnoreCase(isbn)){
                all.remove(i);
                writeToFile(all);
                return true;
            }
        }
        return false;
    }

    private void writeToFile(List<Book> books) throws DataAccessException {
        try (PrintWriter writer = new PrintWriter(filePath)) {
            for (Book book : books) {
                writer.println(bookToLine(book));
            }
        } catch (IOException e) {
            throw new DataAccessException("Could not write to file path: " + filePath, e);
        }
    }

    private Book lineToBook(String line) {
        String[] fields = line.split(delimiter);

        if (fields.length != 7) {
            return null;
        }
        return new Book(
                fields[0],
                Integer.parseInt(fields[1]),
                Integer.parseInt(fields[2]),
                Integer.parseInt(fields[3]),
                fields[4],
                fields[5],
                fields[6]
        );
    }

    private String bookToLine(Book book) {
        return book.getCategory() + delimiter +
                book.getShelfNumber() + delimiter +
                book.getPositionNumber() + delimiter +
                book.getYearPublished() + delimiter +
                cleanField(book.getTitle()) + delimiter +
                cleanField(book.getAuthor()) + delimiter +
                cleanField(book.getIsbn()) + delimiter;
    }

    private String cleanField(String field) {
        return field.replace(delimiter, "")
                .replace("\r", "")
                .replace("\n", "");
    }
}
