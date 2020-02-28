public class Line {

    private Point[] points;
    private static int pointA = 0;
    private static int pointB = 1;
    private static int length = 2;
    private Boolean complete;

    public Line(Point a, Point b) {
        points = new Point[length];
        setPoints(a,b);
    }
    
    public Line(Point a) {
        points = new Point[length];
        setPointA(a);
    }

    public Line() {
        points = new Point[length];
    }

    public void setPoints(Point a, Point b) {
        setPointA(a);
        setPointB(b);
    }

    public void setPointA(Point a) {
        points[pointA] = a;
        setComplete();
    }

    public void setPointB(Point b) {
        points[pointB] = b;
        setComplete();
    }

    public boolean isComplete() {
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
        return points[pointA];
    }

    public Point getPointB() {
        return points[pointB];
    }

    public String toString() {
        if(getPointA() == null || getPointB() == null) {return "No line";} 
        else {return ("Line (" + getPointA().toString() + ") to (" + getPointB().toString() + ")");}
    }
}