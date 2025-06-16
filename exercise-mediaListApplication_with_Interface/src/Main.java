public class Main {
    public static void main(String[] args) {
        MediaService service = new MediaService();

        label:
        while (true) {
            TerminalUtils.displayMenu();
            String choice = TerminalUtils.getMenuChoice();

            switch (choice) {
                case "1":
                    //add media
                    AddMediaCommand.execute(service);
                    break;
                case "2":
                    // remove media
                    RemoveMediaCommand.execute(service);
                    break;
                case "3":
                    // play media
                    PlayMediaCommand.execute(service);
                    break;
                case "4":
                    // list all media
                    ListAllMediaCommand.execute(service);

                    break;
                default:
                    // option 5 quit
                    TerminalUtils.print("Thank you for using mediatypes.Media Libray");
                    break label;
            }

        }
    }
}
