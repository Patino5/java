import java.util.ArrayList;

public class PlayMediaCommand {
    public static void execute(MediaService service) {
        if (service.isEmpty()) {
            TerminalUtils.print(service.getAllMedia());
        } else {
            TerminalUtils.print(service.getAllMedia());
            // need to select what media from the list
            Media playMedia = TerminalUtils.getValidMedia(service);
            //play selected media
            playMedia.play();
        }
        TerminalUtils.pressEnterToContinue();
    }
}