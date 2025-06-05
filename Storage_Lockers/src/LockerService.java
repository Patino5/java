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
    public Locker[] getLockers() {
        return lockers;
    }

    // Rent locker method
    public Result rentLocker() {
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

    // Access Locker
    public Result accessLocker(int lockerNum, String pin) {
        Result lockerCheck  = validLocker(lockerNum);
        if (!lockerCheck.getSuccess()) return lockerCheck;

        Result pinCheck = correctPin(lockerNum, pin);
        if (!pinCheck.getSuccess()) return pinCheck;

        return new Result(true, "Success! Lock it up when you're done.");

    }

    // Release or Return Locker


    // Validate active locker
    public Result validLocker(int lockerNum) {
        if (lockers[lockerNum].getPin() != null){
            return new Result(true ,"Current active locker.");
        }
        return new Result(false, "That locker is not rented. Try Again.");
    }

    //Validate correct pin
    public Result correctPin(int lockerNum, String pin) {
        if (pin.equals(lockers[lockerNum].getPin())){
            return new Result(true, "Successful PIN Entry");
        }
        return new Result(false, "Incorrect PIN: Try Again.");
    }

    // PIN generator
    public String generatePin() {
        Random random = new Random();
        // Generate a number between 0 and 9999
        int pin = random.nextInt(10000);
        // Format it as a 4-digit string with leading zeros if needed
        return String.format("%04d", pin);
    }

    public String getMenu(boolean lockersFull){
        return (!lockersFull) ? """
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

    public boolean areLockersFull() {
        for (Locker locker : lockers){
            if (locker.getPin() == null) return false;
        }
        return true;
    }

}
