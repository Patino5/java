public class AddMediaCommand {
    public static void execute(MediaService service) {
        TerminalUtils.displayMediaList();
        String choice = TerminalUtils.getMenuChoice();

        if (choice.equals("1")){
            //get video info to create media
            Video newVideo = TerminalUtils.createVideo();
            service.addMedia(newVideo);
            TerminalUtils.print(String.format("Video: %s, added to the media list.", newVideo.getName()));
        } else if (choice.equals("2")) {
            // get Audio info to create media
            Audio newAudio = TerminalUtils.createAudio();
            service.addMedia(newAudio);
            TerminalUtils.print(String.format("Audio: %s, added to the media list.", newAudio.getName()));

        } else if (choice.equals("3")) {
            // get Image info

            TerminalUtils.print("New Image added to the list");

        } else if (choice.equals("4")){
            // get Book info
            Book newBook = TerminalUtils.createBook();
            service.addMedia(newBook);
            TerminalUtils.print(String.format("Book: %s, added to the media list.", newBook.getName()));

        } else{
            // go back to main menu
        }
    }
}
