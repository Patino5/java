public class AddMediaCommand {
    public static void execute(MediaService service) {
        TerminalUtils.displayMediaList();
        String choice = TerminalUtils.getMenuChoice();

        if (choice.equals("1")){
            //get video info to create media

            TerminalUtils.print("New Media added to the list");
        } else if (choice.equals("2")) {
            // get Audio info to create media
        } else if (choice.equals("3")) {
            // get Image info
        } else if (choice.equals("4")){
            // get Book info
        } else{
            // go back to main menu
        }
    }
}
