package learn.models;

public class Book {
    private String category;
    private int shelfNumber;
    private int positionNumber;
    private int yearPublished;
    private String title;
    private String author;
    private String isbn;

    public Book() {

    }

    public Book(String category, int shelfNumber, int positionNumber, int yearPublished, String title, String author, String isbn) {
        this.category = category;
        this.shelfNumber = shelfNumber;
        this.positionNumber = positionNumber;
        this.yearPublished = yearPublished;
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getShelfNumber() {
        return shelfNumber;
    }

    public void setShelfNumber(int shelfNumber) {
        this.shelfNumber = shelfNumber;
    }

    public int getPositionNumber() {
        return positionNumber;
    }

    public void setPositionNumber(int positionNumber) {
        this.positionNumber = positionNumber;
    }

    public int getYearPublished() {
        return yearPublished;
    }

    public void setYearPublished(int yearPublished) {
        this.yearPublished = yearPublished;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}
