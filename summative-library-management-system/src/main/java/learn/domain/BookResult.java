package learn.domain;

import learn.models.Book;

import java.util.ArrayList;
import java.util.List;

public class BookResult {
    private ArrayList<String> messages = new ArrayList<>();
    private Book book;

    public List<String> getErrorMessages() {
        return new ArrayList<>(messages);
    }

    public void addErrorMessage(String message) {
        messages.add(message);
    }

    public boolean isSuccess() {
        return messages.isEmpty();
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
