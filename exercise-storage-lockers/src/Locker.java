public class Locker {
    private String lockerId ;
    private boolean isOccupied;
    private String contents;

    public Locker(String lockerId) {
        this.lockerId = lockerId;
        this.isOccupied = false;
        this.contents = "";
    }

    public String getLockerId() {
        return lockerId;
    }

    public String getContents() {
        return contents;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void storeItem(String item){
        this.contents = item;
    }

    public void removeItem(){
        this.contents = "";
        this.isOccupied = false;
    }

    public String toString(){
        return String.format("LockerId: " + this.lockerId +
                "\nOccupied: " + this.isOccupied +
                "\nContents: " + this.contents);
    }

}
