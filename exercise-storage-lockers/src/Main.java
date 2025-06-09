import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LockerManager manager = new LockerManager();
        boolean isRunning = true;
        Scanner io = new Scanner(System.in);

        while (isRunning){
            System.out.println("\nLocker Manager Options:");
            System.out.println("1. Add a locker");
            System.out.println("2. Remove a locker");
            System.out.println("3. Store Item");
            System.out.println("4. Retrieve Item");
            System.out.println("5. Display ALL lockers");
            System.out.println("6. Exit program\n");
            System.out.print("Enter a number choice: ");
            String menuChoice = io.nextLine();
            switch (menuChoice) {
                case "1" :
                    System.out.println("Adding a locker");
                    System.out.print("Enter locker Id: ");
                    String lockerId = io.nextLine();
                    manager.addLocker(new Locker(lockerId));
                    break;

                case "2" :
                    System.out.println("Remove a locker");
                    System.out.print("What locker do you want to Remove by locker Id: ");
                    String removeId = io.nextLine();
                    manager.removeLocker(removeId);
                    break;

                case "3" :
                    System.out.println("Store contents in locker.");
                    System.out.print("What Locker Id to put contents in: ");
                    String lockerIdPlaceItem = io.nextLine();
                    if (!manager.getLocker(lockerIdPlaceItem).isOccupied()) {
                        System.out.print("What do you want to store: ");
                        String item = io.nextLine();
                        manager.getLocker(lockerIdPlaceItem).storeItem(item);
                    } else {
                        System.out.println("Locker is already occupied.");
                    }
                    break;
                case "4" :
                    System.out.print("Retrieve item from which locker Id: ");
                    String lockerToRetrieveItem = io.nextLine();
                    if (manager.getLocker(lockerToRetrieveItem).isOccupied()){
                        String removedItem = manager.getLocker(lockerToRetrieveItem).getContents();
                        manager.getLocker(lockerToRetrieveItem).removeItem();
                        System.out.printf("%s Removed from locker.", removedItem);
                    }

                    break;
                case "5" :
                    if (manager.getLockers().size() > 0){
                        manager.displayAllLockers();
                    } else {
                        System.out.println("\nNo lockers to display.\n");
                    }

                    break;

                default:
                    System.out.println("Thanks for using the Locker Storage System");
                    isRunning = false;
                    break;
            }
        }

    }
}