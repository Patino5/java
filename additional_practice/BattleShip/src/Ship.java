public class Ship {
    private int hitsTaken;
    private int length;
    private int orientation;
    private Coordinate coordinate;

    public Ship(int length, Coordinate coordinate, int orientation){
        this.length = length;
        this.coordinate = coordinate;
        this.orientation = orientation;
        this.hitsTaken = 0;
    }

    public int getHitsTaken() {
        return hitsTaken;
    }

    public void recordHit(int hitsTaken) {
        this.hitsTaken++;
    }

    public int getLength() {
        return length;
    }


    public int getOrientation() {
        return orientation;
    }

    public void setOrientation(int orientation) {
        this.orientation = orientation;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }
}
