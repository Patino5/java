import java.util.ArrayList;
import java.util.Scanner;

public class TerminalUtils {
    private static Scanner io = new Scanner(System.in);

    // Methods
    public static void displayMenu(){
        // show main menu options
        print("==========================" +
                "\n* Media List Application *\n" +
                "==========================\n" +
                "1. Add Media\n" +
                "2. Remove Media\n" +
                "3. Play Media\n" +
                "4. List All Media\n" +
                "5. Quit");
    }

    public static String getMenuChoice() {
        // gets and validates selection
        String choice;
        while (true){
            choice = getString("Choose an option: ");

            if (choice.equals("1") || choice.equals("2") ||
                    choice.equals("3") || choice.equals("4") ||
                    choice.equals("5")) {
                return choice;
            } else {
                print("Invalid choice. Please enter 1, 2, 3, 4, 5.");
            }
        }
    }

    public static void pressEnterToContinue() {
        getString("\nPress Enter to continue...");
    }

    public static String getString(String prompt) {
        print(prompt);
        String input;
        do {
            input = io.nextLine().trim();
            if (input.isEmpty()){
                print("Input cant be empty. Try again.");
            }
        } while (input.isEmpty());
        return input;
    }

    public static int getInt(String prompt) {
        print(prompt);
        int time;
        while (true){
            try {
                time = Integer.parseInt(io.nextLine());
                if (time <= 0) {
                    print("Must be at least 1 or greater");
                } else {
                    return time;
                }
            } catch (NumberFormatException e) {
                print("Must be a number");
            }
        }
    }

    public static void print(String message){
        System.out.println(message);
    }

    public static void print(ArrayList<Media> list) {
        if (list.isEmpty()) {
            print("No media in the list.");
            return;
        }

        print("All Media in Library:");
        for (int i = 0; i < list.size(); i++) {
            Media media = list.get(i);
            print((i + 1) + ". " + media.getDescription());
        }
    }

    public static void displayMediaList() {
        print("""
                Select media type:
                1. Video
                2. Audio
                3. Image
                4. Book
                5 Back to main menu""");
    }

    public static Video createVideo(){
        String name = getString("Enter Video name: ");
        int duration = getInt("Enter duration (minutes): ");
        String resolution = getString("Enter resolution: ");
        return new Video(name, resolution, duration);
    }

    public static Audio createAudio() {
        String name = getString("Enter Audio name: ");
        int duration = getInt("Enter duration (minutes): ");
        String artist = getString("Enter the artist: ");
        return new Audio(name, duration, artist);
    }

    public static Book createBook() {
        String name = getString("Enter Book name: ");
        int pageCount = getInt("Enter page count: ");
        String author = getString("Enter the author: ");
        return new Book(name, pageCount, author);
    }

    public static Image createImage() {
        String name = getString("Enter Image name: ");
        String dimensions = getString("Enter the dimensions: ");
        String fileFormat = getString("Enter the File Format: ");
        return new Image(name, dimensions, fileFormat);
    }
}
