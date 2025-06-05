import java.util.Random;

public class LockerService {
    private static Locker[] lockers ;

    public LockerService(int numberOfLockers){
        lockers = new Locker[numberOfLockers];

        for (int i = 0; i < lockers.length; i++){
            lockers[i] = new Locker(i);
        }
    }
    // get locker array back
    public static Locker[] getLockers() {
        return lockers;
    }

    // Rent locker method
    public static Result rentLocker(Locker[] lockers) {
        // check for first available locker
        for (int i = 0; i < lockers.length; i++) {
            if (lockers[i].getPin() == null) { // first empty locker
                String randomPin = generatePin();
                lockers[i].setPinNumber(randomPin);
                return new Result(true, ("Locker Rented: Locker #" + lockers[i].getNumber() + "\nPIN for entry: " + lockers[i].getPin()));
            }
        }
            // Remove option instead later...

        return new Result(false, "All lockers are full. Try again later");
    }

    // PIN generator
    public static String generatePin() {
        Random random = new Random();
        // Generate a number between 0 and 9999
        int pin = random.nextInt(10000);
        // Format it as a 4-digit string with leading zeros if needed
        return String.format("%04d", pin);
    }

    public static String getMenu(boolean isFull){
        return (isFull) ? """
                What would you like to do next?
                1. Rent a Locker
                2. Access a Locker
                3. Release a Locker
                ---
                Any other key to exit.""" : """
                What would you like to do next?
                1. Lockers Full
                2. Access a Locker
                3. Release a Locker
                ---
                Any other key to exit.""";

    }

}
