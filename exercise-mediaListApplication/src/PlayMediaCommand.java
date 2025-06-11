import java.util.ArrayList;

public class PlayMediaCommand {
    public static void execute(MediaService service) {
       if (service.isEmpty()) {
           TerminalUtils.print(service.getAllMedia());
       } else{
            TerminalUtils.print(service.getAllMedia());
            // need to select what media from the list
            // ask user for media name
            Media playMedia = service.findMediaByName(TerminalUtils.getString("Enter media name to play: "));
            //play selected media
            playMedia.play();
        }
       TerminalUtils.pressEnterToContinue();
    }
}
