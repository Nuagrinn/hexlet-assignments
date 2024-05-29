package exercise;

// BEGIN
public class Segment {

    private Point beginPoint;
    private Point endPoint;

    public Segment(Point beginPoint, Point endPoint) {
        this.beginPoint = beginPoint;
        this.endPoint = endPoint;
    }

    public Point getBeginPoint() {
        return beginPoint;
    }


    public Point getEndPoint() {
        return endPoint;
    }


    public Point getMidPoint() {
        int x = (this.beginPoint.getX() + this.endPoint.getX())/2;
        int y = (this.beginPoint.getY() + this.endPoint.getY())/2;

        return new Point(x,y);
    }

}
// END
