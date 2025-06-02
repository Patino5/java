import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner io = new Scanner(System.in);
        System.out.println("==== Welcome to the Theater ====");
        System.out.println("Please Enter the ticket info below.\n");

        // Prompt user for movie title
        System.out.print("What movie would you like to see? ");
        String movie = io.nextLine();

        // Prompt user for movie time (1pm, 2pm,  etc..)
        // Notes: Keeping it simple to avoid time validation challenges (later mod)
        // Current version does not validate for expected time values
        System.out.print("There are 3 matinees available: 1pm, 2:30pm, 4pm\nWhat time? ");
        String movieTime = io.nextLine();

        // Prompt user for # of adult tickets
        System.out.print("Number of adults Tickets: ");
        String adultTixString = io.nextLine();
        int adultTix = Integer.parseInt(adultTixString);

        // Prompt user for # of child tickets
        System.out.print("Number of child tickets: ");
        String childTixString = io.nextLine();
        int childTix = Integer.parseInt(childTixString);

        // Calculate cost: Matinee Adult: $11.75, Child: $8.25
        double totalCost = adultTix * 11.75 + childTix * 8.25;

        System.out.println("\nPurchase Complete! Summary: ");
        System.out.println("Movie: \t\t" + movie);
        System.out.println("Time: \t\t" + movieTime);
        System.out.println("Adult Tix: \t" + adultTix);
        System.out.println("Child Tix: \t" + childTix);
        System.out.println("Total Cost: " + totalCost);

        System.out.println("\nThanks! Enjoy the show!");

    }
}