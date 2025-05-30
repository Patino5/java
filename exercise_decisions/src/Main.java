import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner io = new Scanner(System.in);
        System.out.println("Welcome to the text based adventure game");

        // validate Entering cave
        String decision;
        do {
            System.out.print("Enter the cave? (y/n): ");
            decision = io.nextLine();
            if (!decision.equalsIgnoreCase("y") && !decision.equalsIgnoreCase("n")) {
                System.out.println("Invalid input. Please enter 'y' or 'n'.");
            }
        } while (!decision.equalsIgnoreCase("y") && !decision.equalsIgnoreCase("n"));

        // Entered Cave
        if (decision.equalsIgnoreCase("y")) {
            System.out.println("You have entered the cave...");

            // can return here once fleeing from creature
            while (true) {
                System.out.println("You have come to a fork and have to decide which way to go.");
                // present two paths (left or right) after entering cave
                // validation for left or right
                String leftOrRight;
                do {
                    System.out.print("Go left or right? (l/r)");
                    leftOrRight = io.nextLine().toLowerCase();
                    if (!leftOrRight.equals("l") && !leftOrRight.equals("r")) {
                        System.out.println("Invalid input. Please enter 'l' or 'r'.");
                    }
                } while (!leftOrRight.equals("l") && !leftOrRight.equals("r"));

                // left path
                if (leftOrRight.equals("l")) {
                    System.out.println("You chose to go left, and have encountered a creature");
                    String fightOrFlee;

                    // validate fight or flee decision
                    do {
                        System.out.print("Do you want to fight or flee? ");
                        fightOrFlee = io.nextLine().toLowerCase();
                        if (!fightOrFlee.equals("fight") && !fightOrFlee.equals("flee")){
                            System.out.println("Invalid input. Please enter 'fight' or 'flee'.");
                        }
                    } while (!fightOrFlee.equals("fight") && !fightOrFlee.equals("flee"));

                    if (fightOrFlee.equals("fight")) { // fight
                        System.out.println("The creature is way stronger than you thought...");
                        System.out.println("You lose");
                        break; // Lose the game
                    } else { // flee
                        System.out.println("Good decision... You run back to the fork!");
                        System.out.println("You can now choose the other path.");
                        continue;
                    }

                } else{ // right path
                    System.out.println("You went right, and found a secret treasure room");
                    System.out.println("You are presented three artifacts");
                    System.out.println("G - Gem");
                    System.out.println("K - Key");
                    System.out.println("B - Book");
                    System.out.println("--------");


                    // Validate artifact selection
                    String artifact;
                    boolean validArtifact = false;
                    do {
                        System.out.print("Which item will you pick: (G/K/B): ");
                        artifact = io.nextLine().toUpperCase();
                        // switch statement for choosing Artifact
                        switch (artifact) {
                            case "G": {
                                System.out.println("You picked the gem");
                                validArtifact = true;
                                break;
                            }
                            case "K": {
                                System.out.println("You picked the key");
                                validArtifact = true;
                                break;
                            }
                            case "B": {
                                System.out.println("You picked the book");
                                validArtifact = true;
                                break;
                            }
                            default: {
                                System.out.println("Invalid input... Pick (G)em/(K)ey/(B)ook");
                                break;
                            }
                        }
                    } while (!validArtifact);

                    break; // exit from path choice while loop and end game

                }

            }
        } else { // decision was "n"
            System.out.println("You decided to not Enter the cave.");
            System.out.println("Adventure waits until next time");
        }
        // Summary of adventure
    }
}