import java.util.Scanner;

public class Main {
    private static Scanner io = new Scanner(System.in);
    static LockerService service = new LockerService(5);

    public static void main(String[] args) {
        boolean keepRunning = true;

        while (keepRunning) {
            print(service.getMenu(true));
            String menuChoice = io.nextLine();
            switch (menuChoice) {
                case "1" : {
                    print(service.rentLocker(service.getLockers()).getMessage());
                    break;
                }
                case "2" : {
                    //more
                    print(validLockerAndPin(service.getLockers()));
//                    String lockerInput = promptString("What locker: ");
//                    int lockerNum = Integer.parseInt(lockerInput) - 1;
//                    if (service.getLockers()[lockerNum].getPin() == null){
//                        print("That locker is not rented. Try again.");
//                        break;
//                    }
//                    String pinInput = promptString("What is the pin: ");
//                    if (!pinInput.equals(service.getLockers()[lockerNum].getPin())){
//                        print("Incorrect PIN: try again.");
//                        break;
//                    }
                     // put validLockerAndPin into LockerService and return new Results to get boolean value for print messages
                     //
                     //print(service.validLockerAndPin(service.getLockers()).getSuccess ? good message : false message);
                     //
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

    public static String validLockerAndPin(Locker[] lockers) {
        String lockerInput = promptString("What locker: ");
        int lockerNum = Integer.parseInt(lockerInput) - 1;
        if (service.getLockers()[lockerNum].getPin() == null){
            return "That locker is not rented. Try again.";

        }
        String pinInput = promptString("What is the pin: ");
        if (pinInput.equals(service.getLockers()[lockerNum].getPin())){
            return "Success";

        }
        return "Incorrect PIN: try again.";
    }

}