import java.util.ArrayList;

public class Container {

    private ArrayList<Line> lines;
    private ArrayList<Point> points;

    public Container() {
        lines = new ArrayList<Line>();
        points = new ArrayList<Point>();
    }

    public void addLine(Line line) {
        lines.add(line);
    }

    public void addPoint(Point point) {
        points.add(point);
    }

    public void deleteLine(int address) {
        lines.remove(address);
    }

    public void deletePoint(int address) {
        points.remove(address);
    }

    public Line getLine(int address) {
        return lines.get(address);
    }

    public Point getPoint(int address) {
        return points.get(address);
    }

    public int getLinesLength() {
        return lines.size();
    }

    public int getPointsLength() {
        return points.size();
    }
}   