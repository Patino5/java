import java.util.List;
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

    public static String getString(String prompt) {
        print(prompt);
        return io.nextLine();
    }

    public static int getInt(String prompt) {
        return -1;
    }

    public static void print(String message){
        System.out.println(message);
    }

    public static void displayMediaList() {
        print("Select media type:\n" +
                "1. Video\n" +
                "2. Audio\n" +
                "3. Image\n" +
                "4. Book\n" +
                "5 Back to main menu");
    }
}
