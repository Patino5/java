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
        for (Locker locker : lockers) {
            if (!locker.isRented()) { // first empty locker
                locker.setPinNumber();
                return new Result(true, ("\nThank You!\nLocker Rented: #" + locker.getNumber() + "\nPIN for entry: " + locker.getPin()));
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
        if (lockers[lockerNum].isRented()){
            return new Result(true ,"Current active locker.");
        }
        return new Result(false, "That locker is not rented. Try Again.");
    }

    public Result verifyPin(int lockerNum, String pin) {
        if (lockers[lockerNum].getPin().equals(pin)){
            return new Result(true, "Successful PIN Entry");
        }
        return new Result(false, "Incorrect PIN. Access denied Try Again.");
    }


    public String getMenu(boolean areLockersFull){
        return (areLockersFull) ?
                """
                \nWhat would you like to do next?
                1. Lockers Currently Full
                2. Access a Locker
                3. Release a Locker
                ---"""
                :
                """
                \nWhat would you like to do next?
                1. Rent a Locker
                2. Access a Locker
                3. Release a Locker
                ---""";

    }

    public boolean areLockersFull() {
        for (Locker locker : lockers){
            if (!locker.isRented()) return false;
        }
        return true;
    }
}
