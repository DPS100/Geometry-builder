import java.util.ArrayList;

public class Container {

    private ArrayList<Line> lines;
    private ArrayList<Point> points;
    private ArrayList<Line> tempLines;
    private ArrayList<Point> tempPoints;
    private ArrayList<Shape> shapes;
    private char lineKey = 'l';
    private char pointKey = 'p';
    private Point mouseCoords;
    private boolean mouseOn = false;
    private boolean newPointEnabled = false;
    private boolean newLineEnabled = false;

    public Container() {
        lines = new ArrayList<Line>();
        points = new ArrayList<Point>();
        tempLines = new ArrayList<Line>();
        tempPoints = new ArrayList<Point>();
        mouseCoords = new Point();
    }

    public void logic() {
        createNewPoint();
        createNewLine();
        mouseOn = false;
    }

    public void createNewPoint() {
        if(newPointEnabled && mouseOn) {
            addPoint(new Point(mouseCoords));
            newPointEnabled = false;
            System.out.println("new point disabled");
        }
    }

    public void createNewLine() {
        if(newLineEnabled && mouseOn) {
            addTempPoint(new Point(mouseCoords));
            System.out.println("new temp point");
            System.out.println(getTempPointsLength());
        }
        if(getTempPointsLength() == 2) {
            setTempPointsToLine(0);
            newLineEnabled = false;
        }
    }

    public void checkInput(char input) {
        System.out.println("Char " + input + " inputted");
        if(input == lineKey){
            newLineEnabled = true;
            System.out.println("new line enabled");
        } else if (input == pointKey) {
            newPointEnabled = true;
            System.out.println("new point enabled");
        }

    }

    public void setMouseCoords(int x, int y) {
        mouseCoords.setPoint(x, y);
    }

    public void setMouseClick(boolean mouse) {
        mouseOn = mouse;
    }

    public void addLine(Line line) {
        lines.add(line);
        System.out.println("new line added");
    }

    public void addPoint(Point point) {
        points.add(point);
        System.out.println("new point added");
    }

    public void addTempLine(Line line) {
        tempLines.add(line);
    }

    public void addTempPoint(Point point) {
        tempPoints.add(point);
    }

    public void addShape(Shape shape) {
        shapes.add(shape);
    }

    public void deleteLine(int address) {
        lines.remove(address);
    }

    public void deletePoint(int address) {
        points.remove(address);
    }

    public void deleteTempLine(int address) {
        tempLines.remove(address);
    }

    public void deleteTempPoint(int address) {
        tempPoints.remove(address);
    }

    public void deleteShape(int address) {
        shapes.remove(address);
    }

    public Line getRecentLine() {
        return lines.get(lines.size() - 1);
    }

    public Point getRecentPoint() {
        return points.get(points.size() - 1);
    }

    public Shape getRecentShape() {
        return shapes.get(shapes.size() - 1);
    }

    public Line getLine(int address) {
        return lines.get(address);
    }

    public Point getPoint(int address) {
        return points.get(address);
    }

    public Line getTempLine(int address) {
        return tempLines.get(address);
    }

    public Point getTempPoint(int address) {
        return tempPoints.get(address);
    }

    public Shape getShape(int address) {
        return shapes.get(address);
    }

    public int getLinesLength() {
        return lines.size();
    }

    public int getPointsLength() {
        return points.size();
    }

    public int getTempLinesLength() {
        return tempLines.size();
    }

    public int getTempPointsLength() {
        return tempPoints.size();
    }

    public int getShapesLength() {
        return shapes.size();
    }

    public void setTempPointsToLine(int start) {
        Point a = new Point(getTempPoint(start));
        Point b = new Point(getTempPoint(start + 1));
        System.out.println("took 2 points");
        deleteTempPoint(start);
        deleteTempPoint(start);
        System.out.println("deleted 2 points");
        addLine(new Line(a, b));
    }

    public String toString() {
        return lines.toString() + " " + points.toString();
    }
}   