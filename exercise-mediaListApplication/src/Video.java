public class Video extends Media {
    private int duration; // in minutes
    private String resolution; // video resolution (e.g. "1080p", "4K")

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    @Override
    void play() {

    }

    @Override
    String getDescription() {
        return "";
    }
}
