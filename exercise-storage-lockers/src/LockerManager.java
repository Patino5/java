import java.util.ArrayList;

public class LockerManager {
    private ArrayList<Locker> lockers;

    public LockerManager(ArrayList<Locker> lockers) {
        this.lockers = lockers;
    }

    public void addLocker(String lockerId){
        lockers.add(new Locker(lockerId));
    }

    public String getLocker(String lockerId) {
        for(Locker locker : lockers){
            locker.getLockerId().equals(lockerId);
            return String.format(locker.toString());
        }
        return String.format("%s Locker not found", lockerId);
    }

    public void removeLocker(String lockerId) {
        for (Locker locker : lockers){
            if (locker.getLockerId().equals(lockerId)){
                lockers.remove(locker);
                break;
            }
        }
    }

    public void displayAllLockers() {
        for (int i = 0; i < lockers.size(); i++) {
            System.out.println(lockers.get(i).toString());
        }
    }

}
