public class Image extends Media {
    private String dimensions;
    private String fileFormat; // "JPEG", "PNG"

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
        return "";
    }

    @Override
    void play() {

    }
}
