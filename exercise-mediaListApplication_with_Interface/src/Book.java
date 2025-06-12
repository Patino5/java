public class Book extends Media {
    private String author;
    private int pageCount;

    public Book(String name, int pageCount, String author) {
        super(name);
        this.pageCount = pageCount;
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    @Override
    public void play() {
        System.out.println("Opening book '" + getName() + "' using e-reader software");
    }

    @Override
    public String getDescription() {
        return "Book: " + getName() +
                "\n\tDescription: Book '" + getName() + "' - " +
                "Page Count: " + getPageCount() + " pages, Author: " + getAuthor();
    }
}
