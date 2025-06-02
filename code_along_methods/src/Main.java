import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner io = new Scanner(System.in);

        printWelcomeMessage(); // uses static method outline in Main class
        // Prompt user for movie title
        String movie = getString("What movie would you like to see? ", io);

        // Prompt user for movie time (1pm, 2pm,  etc...)
        // Current version does not validate for expected time values
        String movieTime = getString("There are 3 matinees available: 1pm, 2:30pm, 4pm\nWhat time? ", io, "1pm", "2:30pm", "4pm");

        // Prompt user for # of adult tickets
        int adultTix = getInt("Number of adult tickets: ", io);

        // Prompt user for # of child tickets
        int childTix = getInt("Number of child tickets: ", io);

        // Calculate cost: Matinee Adult: $11.75, Child: $8.25
        double totalCost = adultTix * 11.75 + childTix * 8.25;

        // Display summary
        printPurchaseSummary(movie, movieTime, adultTix, childTix, totalCost);

        System.out.println("\nThanks! Enjoy the show!");

    }
    public static void printWelcomeMessage() {
        System.out.println("==== Welcome to the Theater ====");
        System.out.println("Please Enter the ticket info below.\n");
    }

    public static String getString(String prompt, Scanner io) {
        System.out.print(prompt);
        return io.nextLine();
    }

    // get console input from user - 3 valid values
    public static String getString(String prompt, Scanner io, String val1, String val2, String val3) {
        boolean isValid = false;
        String input = "";
        while (!isValid) {
            input = getString(prompt, io);
            if (input.equalsIgnoreCase(val1) || input.equalsIgnoreCase(val2) || input.equalsIgnoreCase(val3)) {
                isValid = true;
            } else {
                System.out.println("Invalid entry. Please try again.");
            }
        }
        return input;
    }


    public static int getInt(String prompt, Scanner io){
        System.out.print(prompt);
        String input = io.nextLine();
        return Integer.parseInt(input);
    }

    public static void printPurchaseSummary(String movie, String movieTime, int adultTix, int childTix, double totalCost) {
        System.out.println("\nPurchase Complete! Summary: ");
        System.out.println("Movie: \t\t" + movie);
        System.out.println("Time: \t\t" + movieTime);
        System.out.println("Adult Tix: \t" + adultTix);
        System.out.println("Child Tix: \t" + childTix);
        System.out.println("Total Cost: " + totalCost);
    }
}