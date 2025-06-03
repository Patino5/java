import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to the Text Adventure Game!\n");
        Scanner io = new Scanner(System.in);

        boolean keepRunning = true;
        boolean key1 = false;
        boolean key2 = false;
        boolean key3 = false;
        boolean key4 = false;
        String mainMenu = "\nYou find yourself in a room with 3 doors. Which do you enter? " +
                "\n1. The unfinished wooden door" +
                "\n2. The black metal door" +
                "\n3. The blue painted door" +
                "\n4. The yellow wooden door" +
                "\n5. The steel door" +
                "\nDoor Selection: ";
        // Room messages - for initial visit and after visited
        String room1 = "You've entered a room lit with candles. You see a desk and find part of a key!";
        String room1_visited = "You've enter a room lit with candles. You've been here before. The desk is empty.";
        String room2 = "You've entered a damp and muggy room. Upon further inspection, you see a hole in the far wall. A glint of gold catches your attention. It is part of a key!";
        String room2_visited = "You've entered a damp and muggy room. You've been here before.";
        String room3 = "You've entered a room with a set of armor. Upon further inspection there is part of a key behind the visor. As you take the part out the set of armor crumbles to the floor.";
        String room3_visited = "You've entered a room with the set of armor now laying in shambles... You've been in here before.";
        String room4 = "You've entered a room whose air is dry and warm with a rug on the floor. You pull it back to check underneath... Part of a key!";
        String room4_visited = "You've entered a whose air is dry and warm. The rug is pulled back from when you were in here before.";
        String room5_locked = "You've found a room with a red door... it's locked... do you have a key?";
        String room5_unlocked = "You've found a room with a red door... you've used the key you have found and opened the door!";

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
                    if (key3) {
                        System.out.println(room3_visited);
                    } else {
                        key3 = true;
                        System.out.println(room3);
                    }
                    break;
                case "4" :
                    System.out.println("Room 4");
                    if (key4) {
                        System.out.println(room4_visited);
                    } else {
                        key4 = true;
                        System.out.println(room4);
                    }
                    break;
                case "5" :
                    System.out.println("Room 5");
                    if (key1 && key2 && key3 && key4) {
                        System.out.println(room5_unlocked);
                        keepRunning = false;
                    } else {
                        System.out.println(room5_locked);
                    }

                    break;
                default:
                    System.out.println("Unable to find the door you are looking for");
            }
        }
        System.out.println("\nBye, " + name + "!");

    }
}