import mediatypes.Media;

public class RemoveMediaCommand {
    public static void execute(MediaService service){
        if (service.isEmpty()){
            TerminalUtils.print(service.getAllMedia());
        }
        else{
            TerminalUtils.print(service.getAllMedia());

            Media mediaToRemove = TerminalUtils.getValidMedia(service);
            boolean isSuccessful = service.removeMedia(mediaToRemove.getName());
            TerminalUtils.print(String.format("%s was successfully removed from list: %b", mediaToRemove.getName(), isSuccessful));
        }
        TerminalUtils.pressEnterToContinue();
    }
}
