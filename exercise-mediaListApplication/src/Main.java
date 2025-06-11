public class Main {
    public static void main(String[] args) {
        MediaService service = new MediaService();

        while (true) {
            TerminalUtils.displayMenu();
            String choice = TerminalUtils.getMenuChoice();

            if (choice.equals("1")) {
                //add media
                AddMediaCommand.execute(service);
            } else if (choice.equals("2")) {
                // remove media

            } else if (choice.equals("3")) {
                // play media

            } else if (choice.equals("4")) {
               // list all media

            } else {
                // option 5 quit
                break;
            }

        }
    }
}
