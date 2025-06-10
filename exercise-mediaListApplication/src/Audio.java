public class Audio extends Media{
    private int duration;
    private String artist; // name of artist or performer

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

    @Override
    String getDescription() {
        return "Name: " + getName() +
                "\nDuration: " + getDuration() +
                "\nArtist: " + getArtist();
    }

    @Override
    void play() {
        System.out.println("Playing audio " + getName() + " using audio player software");
    }
}
