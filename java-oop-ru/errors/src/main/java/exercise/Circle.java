package exercise;

import java.util.Map;

// BEGIN
public class Circle {

    private Point point;

    private int r;

    public Circle (Point point, int r) {
        this.point = point;
        this.r = r;
    }

    public int getRadius() {
        return r;
    }

    public double getSquare() throws NegativeRadiusException {
        if (this.r < 0) {
            throw new NegativeRadiusException("negative radius");
        }
        return Math.pow(r, 2) * Math.PI;
    }

}
// END
