package mediatypes;

public class Audio extends Media{
    private int duration;
    private String artist; // name of artist or performer

    public Audio(String name, int duration, String artist) {
        super(name);
        this.duration = duration;
        this.artist = artist;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getDescription() {
        return "Audio: " + getName() +
                "\n\tDescription: Audio '" + getName() + "' - " +
                "Duration: " + getDuration() + " minutes, Artist: " + getArtist();
    }

    public void play() {
        System.out.println("Playing audio '" + getName() + "' using audio player software");
    }
}
