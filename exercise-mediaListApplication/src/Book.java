public class Book extends Media {
    private String author;
    private int pageCount;

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
    void play() {
        System.out.println("Opening book " + " using e-reader software");
    }

    @Override
    String getDescription() {
        return "";
    }
}
