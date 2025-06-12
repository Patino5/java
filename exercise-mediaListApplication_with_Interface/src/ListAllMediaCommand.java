public class ListAllMediaCommand {
    public static void execute(MediaService service) {
        TerminalUtils.print(service.getAllMedia());
        TerminalUtils.pressEnterToContinue();
    }
}
