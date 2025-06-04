import java.util.Scanner;

public class Main {
    private static Scanner io = new Scanner(System.in);

    public static void main(String[] args) {
        boolean keepRunning = true;
        String fullMenu = """
                
                What would you like to do next?
                 1. Rent a Locker
                 2. Access a Locker
                 3. Release a Locker
                 ---
                 Any other key to exit.""";


        while (keepRunning) {
            print(fullMenu);
            String menuChoice = io.nextLine();
            switch (menuChoice) {
                case "1" : {
                    // more
                    System.out.println("Rent Locker");
                }
                case "2" : {
                    //more
                    System.out.println("Access Locker");
                }
                case "3" : {
                    // more
                    System.out.println("Release Locker");
                }
                default : {
                    System.out.println("Exit");
                    keepRunning = false;
                }
            }
        }



    }
    public static void print(String message){
        System.out.println(message);
    }

}