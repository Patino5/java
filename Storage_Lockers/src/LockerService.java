import java.util.Random;

public class LockerService {
    private final Locker[] lockers ;

    public LockerService(int numberOfLockers){
        lockers = new Locker[numberOfLockers];

        for (int i = 0; i < lockers.length; i++){
            lockers[i] = new Locker(i + 1);
        }
    }

    public Locker[] getLockers() {
        return lockers;
    }

    public Result rentLocker() {
        for (int i = 0; i < lockers.length; i++) {
            if (lockers[i].getPin() == null) { // first empty locker
                lockers[i].setPinNumber(generatePin());
                return new Result(true, ("Thank You!\nLocker Rented: Locker #" + lockers[i].getNumber() + "\nPIN for entry: " + lockers[i].getPin()));
            }
        }
        return new Result(false, "All lockers are full. Try again later");
    }

    public Result accessLocker(int lockerNum, String pin) {
        Result lockerCheck  = activeLocker(lockerNum);
        if (!lockerCheck.getSuccess()) return lockerCheck;

        Result pinCheck = verifyPin(lockerNum, pin);
        if (!pinCheck.getSuccess()) return pinCheck;

        return new Result(true, "Success! Lock it up when you're done.");
    }

    public Result releaseLocker(int lockerNum, String pin, String confirm){
        Result lockerCheck = activeLocker(lockerNum);
        if (!lockerCheck.getSuccess()) return lockerCheck;

        Result pinCheck = verifyPin(lockerNum, pin);
        if (!pinCheck.getSuccess()) return pinCheck;

        if(!confirm.equalsIgnoreCase("y")) return new Result(false, "Locker not released");

        lockers[lockerNum].resetPin();
        return new Result(true, "Locker #" + (lockerNum + 1) + " made available and PIN reset.");
    }

    public Result activeLocker(int lockerNum) {
        if (lockers[lockerNum].getPin() != null){
            return new Result(true ,"Current active locker.");
        }
        return new Result(false, "That locker is not rented. Try Again.");
    }

    public Result verifyPin(int lockerNum, String pin) {
        if (pin.equals(lockers[lockerNum].getPin())){
            return new Result(true, "Successful PIN Entry");
        }
        return new Result(false, "Incorrect PIN: Try Again.");
    }

    public String generatePin() {
        Random random = new Random();
        int pin = random.nextInt(10000);
        return String.format("%04d", pin);
    }

    public String getMenu(boolean areLockersFull){
        return (areLockersFull) ?
                """
                
                What would you like to do next?
                1. Lockers Currently Full
                2. Access a Locker
                3. Release a Locker
                ---"""
                :
                """
                
                What would you like to do next?
                1. Rent a Locker
                2. Access a Locker
                3. Release a Locker
                ---""";

    }

    public boolean areLockersFull() {
        for (Locker locker : lockers){
            if (locker.getPin() == null) return false;
        }
        return true;
    }
}
