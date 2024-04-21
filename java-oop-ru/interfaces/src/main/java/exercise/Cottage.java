package exercise;

// BEGIN
public class Cottage implements Home {
    private final double area;
    private final int floorCount;

    public Cottage(double area, int floorCount) {
        this.area = area;
        this.floorCount = floorCount;
    }

    @Override
    public double getArea() {
        return area;
    }

    @Override
    public int compareTo(Home another) {
        double thisArea = getArea();
        double anotherArea = another.getArea();

        if (thisArea > anotherArea) {
            return 1;
        } else if (thisArea < anotherArea) {
            return -1;
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return floorCount + " этажный коттедж площадью " + getArea() + " метров";
    }
}

// END
