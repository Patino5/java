import java.util.Scanner;

public class Main {
    private static Scanner io = new Scanner(System.in);
    static LockerService service = new LockerService(5);

    public static void main(String[] args) {
        boolean keepRunning = true;

        while (keepRunning) {
            print(service.getMenu(service.areLockersFull())); //
            String menuChoice = io.nextLine();
            switch (menuChoice) {
                case "1" : {
                    print(service.rentLocker().getMessage());
                    break;
                }
                case "2" : {
                    //more
                    String lockerInput = promptString("What locker: ");
                    int lockerNum = Integer.parseInt(lockerInput) - 1;
                    String pin = promptString("What is the pin: ");
                    print(service.accessLocker(lockerNum, pin).getMessage());

                    break;
                }
                case "3" : {
                    // more
                    System.out.println("Release Locker");
                    break;
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

    public static String promptString(String message) {
        print(message);
        return io.nextLine();
    }

}