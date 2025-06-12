import java.util.ArrayList;

public class MediaService {
    private static ArrayList<Media> mediaList = new ArrayList<>();

    public void addMedia(Media media) {
        // add media to the list
        mediaList.add(media);
    }

    public boolean removeMedia(String name) {
        // removes media from list by name and return boolean success
        Media removeMedia = findMediaByName(name);
        if (removeMedia != null) {
            mediaList.remove(removeMedia);
            return true;
        }
        return false;
    }

    public static Media findMediaByName(String name){
        if (mediaList.isEmpty()){
            return null;
        }
        // finds media by name
        for (Media media: mediaList){
            if (media.getName().equalsIgnoreCase(name)){
                return media;
            }
        }
        return null;
    }

    public ArrayList<Media> getAllMedia() {
        return new ArrayList<>(mediaList);
    }

    public boolean isEmpty() {
        return mediaList.isEmpty();
    }

}
