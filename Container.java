import java.util.ArrayList;

public class Container {

    private ArrayList<Line> lines;
    private ArrayList<Point> points;
    private ArrayList<Line> tempLines;
    private ArrayList<Point> tempPoints;
    private ArrayList<Shape> shapes;
    private char lineKey = 'l';
    private char pointKey = 'p';
    private char addGenKey = '=';
    private char subGenKey = '-';
    private char addSerpKey = 't';
    private char clearWorkspaceKey = 'c';
    private Point mouseCoords;
    private boolean mouseOn = false;
    private boolean newPointEnabled = false;
    private boolean newLineEnabled = false;
    private int serpinskiGenerations = 0;
    private Point[] trianglePoints;
    private SerpTriangle triangle;

    public Container() {
        lines = new ArrayList<Line>();
        points = new ArrayList<Point>();
        tempLines = new ArrayList<Line>();
        tempPoints = new ArrayList<Point>();
        shapes = new ArrayList<Shape>();
        mouseCoords = new Point();

        trianglePoints = new Point[3];
        trianglePoints[0] = new Point(20 * 2, 180 * 2);
        trianglePoints[1] = new Point(100 * 2, 20 * 2);
        trianglePoints[2] = new Point(180 * 2, 100 * 2);

        triangle = new SerpTriangle(trianglePoints, 0);
    }

    public void logic() {
        createNewPoint();
        createNewLine();
        serpinskiLoop();
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

    public void deleteAllObjects() {
        deleteAllShapes();
        deleteAllPoints();
        
        deleteAllLines();
        deleteAllTempPoints();
        deleteAllTempLines();
    }

    public void deleteAllShapes() {
        for(int x = 0; x < getShapesLength(); x++) {
            deleteShape(x);
        }
    }

    public void deleteAllPoints() {
        for(int x = 0; x < getPointsLength(); x++) {
            deletePoint(x);
        }
    }

    public void deleteAllTempPoints() {
        for(int x = 0; x < getTempPointsLength(); x++) {
            deleteTempPoint(x);
        }
    }

    public void deleteAllLines() {
        for(int x = 0; x < getLinesLength(); x++) {
            deleteLine(x);
        }
    }

    public void deleteAllTempLines() {
        for(int x = 0; x < getTempLinesLength(); x++) {
            deleteTempLine(x);
        }
    }

    public void serpinskiLoop() {
        deleteAllShapes();
        serpinskiMini(serpinskiGenerations, triangle);
    }

    public void addGeneration() {
        serpinskiGenerations++;
    }

    public void serpinskiMini(int gensLeft, SerpTriangle target) {
        addShape(target);
        if(gensLeft != 0) {
            gensLeft--;
            serpinskiMini(gensLeft, target.newTopTriangle());
            serpinskiMini(gensLeft, target.newLeftTriangle());
            serpinskiMini(gensLeft, target.newRightTriangle());
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
        } else if (input == addGenKey) {
            serpinskiGenerations++;
        } else if (input == subGenKey) {
            serpinskiGenerations--;
        } else if (input == clearWorkspaceKey) {
            deleteAllObjects();
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