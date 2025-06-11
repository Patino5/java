public class Video extends Media {
    private int duration; // in minutes
    private String resolution; // video resolution (e.g. "1080p", "4K")

    public Video(String name, String resolution, int duration) {
        super(name);
        this.resolution = resolution;
        this.duration = duration;
    }

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
        System.out.println("Playing video '" + getName() + "' using video player software");
    }

    @Override
    String getDescription() {
        return "Video: " + getName() +
                "\n\tDescription: Video '" + getName() + "' - " +
                "Duration: " + getDuration() + " minutes, Resolution: " + getResolution();
    }
}
