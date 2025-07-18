public class AddMediaCommand {
    public static void execute(MediaService service) {
        TerminalUtils.displayMediaList();
        String choice = TerminalUtils.getMenuChoice();

        switch (choice) {
            case "1" -> {
                //get video info to create media
                Video newVideo = TerminalUtils.createVideo();
                service.addMedia(newVideo);
                TerminalUtils.print(String.format("Video: %s, added to the media list.", newVideo.getName()));
            }
            case "2" -> {
                // get Audio info to create media
                Audio newAudio = TerminalUtils.createAudio();
                service.addMedia(newAudio);
                TerminalUtils.print(String.format("Audio: %s, added to the media list.", newAudio.getName()));
            }
            case "3" -> {
                // get Image info
                Image newImage = TerminalUtils.createImage();
                service.addMedia(newImage);
                TerminalUtils.print(String.format("Image: %s, added to the media list", newImage.getName()));
            }
            case "4" -> {
                // get Book info
                Book newBook = TerminalUtils.createBook();
                service.addMedia(newBook);
                TerminalUtils.print(String.format("Book: %s, added to the media list.", newBook.getName()));
            }
            default ->
                // go back to main menu
                    TerminalUtils.print("Back to Main Menu");
        }
        TerminalUtils.pressEnterToContinue();
    }
}
