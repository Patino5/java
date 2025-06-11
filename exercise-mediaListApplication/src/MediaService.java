import java.util.ArrayList;

public class MediaService {
    private ArrayList<Media> mediaList;

    public MediaService() {
        mediaList = new ArrayList<>();
    }

    public void addMedia(Media media) {
        // add media to the list
        mediaList.add(media);
    }

    public boolean removeMedia(String name) {
        // removes media from list by name and return boolean success
        return false;
    }

//    public Media findMediaByName(String name){
//        // finds media by name
//    }

    public ArrayList<Media> getAllMedia() {
        return new ArrayList<>(mediaList);
    }

    public int getMediaCount() {
        return mediaList.size();
    }

    public boolean isEmpty() {
        return mediaList.isEmpty();
    }

}
