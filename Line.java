public class Line {

    private Point[] points;
    private Point emptyPoint = new Point();
    private Boolean complete;

    public Line(Point a, Point b) {
        points = new Point[2];
        setPoints(a,b);
    }

    public Line() {
        points = new Point[2];
        setPoints(emptyPoint, emptyPoint);
    }

    public Line(Point a) {
        points = new Point[2];
        setPoints(a, emptyPoint);
    }

    public void setPoints(Point a, Point b) {
        setPointA(a);
        setPointB(b);
    }

    public void setPointA(Point a) {
        points[0] = a;
        setComplete();
    }

    public void setPointB(Point b) {
        points[1] = b;
        setComplete();
    }

    public Boolean getComplete() {
        return complete;
    }

    public void setComplete() {
        if(getPointA() == null || getPointB() == null){complete = false;}
        else {
            if(getPointA().getOnScreen() == false || getPointB().getOnScreen() == false) {complete = false;} 
            else {complete = true;}
        }
    }

    public Point[] getPoints() {
        return points;
    }

    public Point getPointA() {
        return points[0];
    }

    public Point getPointB() {
        return points[1];
    }

    public String toString() {
        return ("Line (" + getPointA().toString() + ") to (" + getPointB().toString() + ") exists = " + getComplete());
    }
}