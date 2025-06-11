public class RemoveMediaCommand {
    public static void execute(MediaService service){
        if (service.isEmpty()){
            TerminalUtils.print(service.getAllMedia());
        }
        else{
            TerminalUtils.print(service.getAllMedia());
            Media mediaToRemove = service.findMediaByName(TerminalUtils.getString("Enter media name to remove: "));
            String removeMediaName = mediaToRemove.getName();
            boolean isRemoved = service.removeMedia(removeMediaName);
            TerminalUtils.print(String.format("%s media was removed: %b", removeMediaName, isRemoved));
        }
        TerminalUtils.pressEnterToContinue();
    }
}
