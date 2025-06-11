public class Image extends Media {
    private String dimensions;
    private String fileFormat; // "JPEG", "PNG"

    public Image(String name, String dimensions, String fileFormat) {
        super(name);
        this.dimensions = dimensions;
        this.fileFormat = fileFormat;
    }

    public String getFileFormat() {
        return fileFormat;
    }

    public void setFileFormat(String fileFormat) {
        this.fileFormat = fileFormat;
    }

    public String getDimensions() {
        return dimensions;
    }

    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }

    @Override
    String getDescription() {
        return "Name: " + getName() +
                "\nDimensions: " + getDimensions() +
                "\nFile Format: " + getFileFormat();
    }

    @Override
    void play() {
        System.out.println("Displaying image " + getName() + " using image viewer software");
    }
}
