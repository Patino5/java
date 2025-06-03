import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to the Text Adventure Game!\n");
        Scanner io = new Scanner(System.in);

        boolean keepRunning = true;
        String[] rooms = new String[5];
        String[] unlockedRooms = new String[5];
        boolean[] keys = new boolean[4];
        String mainMenu = "\nYou find yourself in a room with 5 doors. Which do you enter? " +
                "\n1. The unfinished wooden door" +
                "\n2. The black metal door" +
                "\n3. The blue painted door" +
                "\n4. The yellow wooden door" +
                "\n5. The steel door" +
                "\nDoor Selection: ";

        // Room messages - for initial visit and after visited now stored in an array
        rooms[0] = "You've entered a room lit with candles. You see a desk and find part of a key!";
        rooms[1] = "You've entered a damp and muggy room. Upon further inspection, you see a hole in the far wall. A glint of gold catches your attention. It is part of a key!";
        rooms[2] = "You've entered a room with a set of armor. Upon further inspection there is part of a key behind the visor. As you take the part out the set of armor crumbles to the floor.";
        rooms[3] = "You've entered a room whose air is dry and warm with a rug on the floor. You pull it back to check underneath... Part of a key!";
        rooms[4] = "You've found a room with a red door... it's locked... do you have a key?";

        unlockedRooms[0] = "You've enter a room lit with candles. You've been here before. The desk is empty.";
        unlockedRooms[1] = "You've entered a damp and muggy room. You've been here before.";
        unlockedRooms[2] = "You've entered a room with the set of armor now laying in shambles... You've been in here before.";
        unlockedRooms[3] = "You've entered a whose air is dry and warm. The rug is pulled back from when you were in here before.";
        unlockedRooms[4] = "You've found a room with a red door... you've used the key you have found and opened the door!";

        // get users name
        String name = promptString("Hello, Please enter your name: ");
        print("Your name is " + name);

//        Start in a central hub with options for your three locations. Main Room
        while (keepRunning) {
            String direction = promptString(mainMenu);
            int door = Integer.parseInt(io.nextLine());
            switch (door){
                case 1 :
                case 2:
                case 3:
                case 4:
                    if (keys[door - 1]){
                        print(unlockedRooms[door - 1]);
                    } else {
                        keys[door - 1] = true;
                        print(rooms[door - 1]);
                    }
                    break;
                case 5 :
                    boolean unlock = true;
                    for (boolean key : keys){
                        if (!key){
                            print(rooms[4]);
                            unlock = false;
                            break;
                        }
                    }
                    if (unlock) {
                        print(unlockedRooms[4]);
                        keepRunning = false;
                    }
                    break;
                default:
                    print("Unable to find the door you are looking for");
            }
        }
        print("\nBye, " + name + "!");
    }
    public static void print(String message) {
        System.out.println(message);
    }

    public static String promptString(String message) {
        Scanner io = new Scanner(System.in);
        print(message);
        return io.nextLine();
    }
}