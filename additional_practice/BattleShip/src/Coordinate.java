import java.util.Objects;

public class Coordinate {
    private final int xAxis;
    private final int yAxis;

    public Coordinate(int xAxis, int yAxis) {
        this.xAxis = xAxis;
        this.yAxis = yAxis;
    }

    public int getxAxis() {
        return xAxis;
    }

    public int getyAxis() {
        return yAxis;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;

        if(!(obj instanceof Coordinate)) return false;

        Coordinate other = (Coordinate) obj;

        return this.xAxis == other.xAxis && this.yAxis == other.yAxis;
    }

    @Override
    public int hashCode() {
        return Objects.hash(xAxis, yAxis);
    }
}
