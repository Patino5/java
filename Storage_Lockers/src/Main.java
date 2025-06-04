import java.util.Random;
import java.util.Scanner;

public class Main {
    private static Scanner io = new Scanner(System.in);

    public static void main(String[] args) {
        boolean keepRunning = true;
        int[] lockers = new int[5];
        String[] lockerPINs = new String[5];
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
                    rentLocker(lockers,lockerPINs);
                    break;
                }
                case "2" : {
                    //more

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

    public static String generatePin(){
        Random random = new Random();
        int pin = random.nextInt(10000);
        return String.format("%04d", pin);
    }

    // rentLocker method refactored out
    public static void rentLocker(int[] lockers, String[] lockerPINs){
        boolean isFull = true;
        // check for first available locker
        for (int i = 0; i < lockers.length; i++){
            if (lockers[i] == 0){ // first empty locker
                lockers[i] = i + 1;
                lockerPINs[i] = generatePin();
                print("Your locker number: " +
                        lockers[i] +
                        "\nYour pin to unlock locker is: " +
                        lockerPINs[i]);
                isFull = false;
                break;
            }
        }
        if (isFull){
            // Remove option instead later...
            print("Lockers full. Try again later.");
        }
    }

}