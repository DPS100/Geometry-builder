public class Shape{

    private int sides;
    private Point[] points;
    private Line[] lines;
    private Point[] blankPoints;

    public Shape(int sides){
        this.sides = sides;
        points = new Point[sides];
        lines = new Line[sides];
        blankPoints = points;
        for(int x = 0; x < sides; x++) {
            blankPoints[x] = new Point(0,0);
        }
        fillLines(blankPoints);
    }

    public Shape(Point[] points) {
        sides = points.length;
        this.points = points;
        lines = new Line[sides];
        fillLines(points);
    }

    public int getSides() {
        return sides;
    }

    public Point getPoint(int address) {
        return points[address];
    } 

    public Line getLine(int address) {
        return lines[address];
    }

    public void setPoint(int address, Point point) {
        points[address] = point;
    }

    public void fillLines(Point[] points) {
        for(int x = 0; x < sides - 1; x++) {
            lines[x] = (new Line(points[x], points[x + 1]));
        }
        lines[sides - 1] = new Line(points[0], points[sides - 1]);
    }

    public String toString() {
        return lines.toString();
    }
}