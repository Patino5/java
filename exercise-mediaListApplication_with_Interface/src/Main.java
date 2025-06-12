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
                RemoveMediaCommand.execute(service);
            } else if (choice.equals("3")) {
                // play media
                PlayMediaCommand.execute(service);
            } else if (choice.equals("4")) {
               // list all media
                ListAllMediaCommand.execute(service);

            } else {
                // option 5 quit
                TerminalUtils.print("Thank you for using Media Libray");
                break;
            }

        }
    }
}
