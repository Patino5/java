import java.util.Scanner;

public class Main {
    private static final Scanner io = new Scanner(System.in);
    private static final LockerService service = new LockerService(5);

    public static void main(String[] args) {
        boolean keepRunning = true;

        while (keepRunning) {
            try {
                print(service.getMenu(service.areLockersFull())); //
                String menuChoice = promptString("Any other key to exit: ");
                switch (menuChoice) {
                    case "1" : {
                        Result rentLocker = service.rentLocker();
                        print(rentLocker.getMessage());
                        break;
                    }
                    case "2" : {
                        int lockerNum = Integer.parseInt(promptString("What locker: ")) -1;
                        Result lockerCheck = service.activeLocker(lockerNum);

                        if (!lockerCheck.getSuccess()){
                            print(lockerCheck.getMessage());
                            break;
                        }

                        String pin = promptString("What is the pin: ");
                        Result accessResult = service.accessLocker(lockerNum, pin);
                        print(accessResult.getMessage());
                        break;
                    }
                    case "3" : {
                        int lockerNum = Integer.parseInt(promptString("What locker: ")) -1;
                        Result lockerCheck = service.activeLocker(lockerNum);

                        if (!lockerCheck.getSuccess()){
                            print(lockerCheck.getMessage());
                            break;
                        }
                        String pin = promptString("What is the pin: ");
                        Result pinCheck = service.verifyPin(lockerNum, pin);

                        if (!pinCheck.getSuccess()){
                            print(pinCheck.getMessage());
                            break;
                        }
                        String confirm = promptString("Are you sure. (y)/(n): ");
                        Result releaseLockerResult = service.releaseLocker(lockerNum,pin, confirm);
                        print(releaseLockerResult.getMessage());
                        break;
                    }
                    default : {
                        print("Exit");
                        keepRunning = false;
                    }
                }
            } catch (NumberFormatException e) {
                print("Please enter a number for your locker. Lockers are numeric values.");
            } catch (ArrayIndexOutOfBoundsException e){
                print("Please choose a locker between 1 and " + service.getLockers().length + ".");
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