public class Cell {
    private boolean isOccupied;
    private boolean isGuessed;
    private final Coordinate coordinate;
    private Ship ship;

    public Cell(Coordinate coordinate, Ship ship) {
        this.isOccupied = false;
        this.isGuessed = false;
        this.coordinate = coordinate;
        this.ship = ship;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }

    public boolean isGuessed() {
        return isGuessed;
    }

    public void setGuessed(boolean guessed) {
        isGuessed = guessed;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

}
