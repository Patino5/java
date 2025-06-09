import java.util.ArrayList;

public class LockerManager {
    private ArrayList<Locker> lockers = new ArrayList<>();

    public LockerManager() {
    }

    public ArrayList<Locker> getLockers() {
        return lockers;
    }

    public void addLocker(Locker locker){
        lockers.add(locker);
    }

    public Locker getLocker(String lockerId) {
        for(Locker locker : lockers){
            if (locker.getLockerId().equals(lockerId)) {
                return locker;
            }
        }
        return null;
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
