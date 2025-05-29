import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner io = new Scanner(System.in);
        System.out.println("Welcome to the text based adventure game");
        System.out.print("Enter the cave? (y/n): ");
        String decision = io.nextLine();

        // if they enter, present two paths (left or right)
        if (decision.equalsIgnoreCase("y")) {
            System.out.println("You have entered the cave...");
            System.out.println("You have come to a fork and have to decide which way to go.");
            System.out.print("Go left or right? (l/r)");
            String leftOrRight = io.nextLine().toLowerCase();

            if (leftOrRight.equalsIgnoreCase("l")){
                System.out.println("You chose to go left, and have encountered a creature");
                System.out.print("Do you want to fight or flee? ");
                String fightOrFlee = io.nextLine().toLowerCase();

                if (fightOrFlee.equalsIgnoreCase("fight")){
                    System.out.println("The creature is way stronger than you thought...");
                    System.out.println("You lose");
                } else if (fightOrFlee.equalsIgnoreCase("flee")){
                    System.out.println("Good decision... You run back!");
                } else {
                    System.out.println("Invalid input... must fight or flee.");
                }

            } else if (leftOrRight.equalsIgnoreCase("r")){
                System.out.println("You went right, and found a secret treasure room");
                System.out.println("You are presented three artifacts");
                System.out.println("G - Gem");
                System.out.println("K - Key");
                System.out.println("B - Book");
                System.out.println("--------");
                System.out.print("Which item will you pick: (G/K/B): ");
                String artifact = io.nextLine().toUpperCase();

                switch (artifact) {
                    case "G": {
                        System.out.println("You picked the gem");
                        break;
                    }
                    case "K": {
                        System.out.println("You picked the key");
                        break;
                    }
                    case "B": {
                        System.out.println("You picked the book");
                        break;
                    }
                    default:
                    {
                        System.out.println("Invalid input... Pick (G)em/(K)ey/(B)ook");
                        break;
                    }


                }
            }
        } else if (decision.equalsIgnoreCase("n")) {
            System.out.println("You decided to not Enter the cave.");
        } else {
            System.out.println("Invalid input");
        }


    }
}