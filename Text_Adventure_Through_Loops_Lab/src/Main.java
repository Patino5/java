import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        System.out.println("Welecome to the Text Adventure Game!\n");
        Scanner io = new Scanner(System.in);

        boolean keepRunning = true;
        boolean key1 = false;
        boolean key2 = false;
        //● Display a menu of the three locations.  3- Rooms with different doors
        String mainMenu = "\nYou find yourself in a room with 3 doors. Which do you enter? " +
                "\n1. The unfinished wooden door" +
                "\n2. The black metal door" +
                "\n3. The blue painted door" +
                "\nDoor Selection: ";
        // Room messages - for initial visit and after visited
        String room1 = "You've entered a room lit with candles. You see a desk and find half a key!";
        String room1_visited = "You've enter a room lit with candles. You've been here before. The desk is empty.";
        String room2 = "You've entered a damp and muggy room. Upon further inspection, you see a hole in the far wall. A glint of gold catches your attention. It is half of a key!";
        String room2_visited = "You've entered a damp and muggy room. You've been here before.";
        String room3_locked = "You've found a room with a red door... it's locked... do you have a key?";
        String room3_unlocked = "You've found a room with a red door... you've used the key you have found and opened the door!";
        // get users name
        System.out.print("Hello, Please enter your name: ");
        String name = io.nextLine();
        System.out.println("Your name is " + name);

//        Start in a central hub with options for your three locations. Main Room
        while (keepRunning) {
            System.out.println(mainMenu);
            String direction = io.nextLine();
            switch (direction){
                case "1" :
                    System.out.println("Room 1");
                    if (key1) {
                        System.out.println(room1_visited);
                    } else {
                        key1 = true;
                        System.out.println(room1);
                    }
                    break;
                case "2" :
                    System.out.println("Room 2");
                    if (key2) {
                        System.out.println(room2_visited);
                    } else {
                        key2 = true;
                        System.out.println(room2);
                    }
                    break;
                case "3" :
                    System.out.println("Room 3");
                    if (key1 && key2) {
                        System.out.println(room3_unlocked);
                        keepRunning = false;
                    } else {
                        System.out.println(room3_locked);
                    }

                    break;
                default:
                    System.out.println("Unable to find the door you are looking for");
            }
        }
        System.out.println("\nBye, " + name + "!");


//                Lab Text Adventure Through Loops - 1
//● Of the three locations, the third one should initially be 'locked' and require a key
//        for entry. Each of the first two locations will hold half of the key so each of the first
//        two must be visited before the third can be accessed.
//● Decide on variable names to hold each description and a boolean variable to
//        store if the location has been visited.
//● Plan your messages with a flow chart, storyboard, or user experience
//        description.
//● Create a control loop that presents the user with the description of the hub and a
//        menu to choose which of the three locations to visit.
//● When the user visits a location for the first time, give the initial description and
//        set the value of the visited boolean variable.
//● If the user revisits a location, display the repeat visit description.
//● Once the user has visited all three locations, display a conclusion text message
//        and exit the program.
//● Allow the user to exit early by entering a command at the menu prompt.

    }
}