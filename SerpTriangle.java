public class SerpTriangle extends Shape{

    private int generations;
    private Point[] midpoints;

    public SerpTriangle(Point[] points, int generations) {
        super(points);
        midpoints = new Point[3];
        calculateMidpoints();
        this.generations = generations - 1;
    }

    public void calculateMidpoints() {
        int halfX;
        int halfY;
        for(int x = 0; x < super.getSides() - 1; x++) {
            halfX = (super.getPoint(x).getXCoord() + super.getPoint(x + 1).getXCoord()) / 2;
            halfY = (super.getPoint(x).getYCoord() + super.getPoint(x + 1).getYCoord()) / 2;
            midpoints[x] = new Point(halfX, halfY);
        }
        halfX = (super.getPoint(0).getXCoord() + super.getPoint(super.getSides() - 1).getXCoord()) / 2;
        halfY = (super.getPoint(0).getYCoord() + super.getPoint(super.getSides() - 1).getYCoord()) / 2;
        midpoints[super.getSides() - 1] = new Point(halfX, halfY);
    }

    public SerpTriangle newTopTriangle() {
        Point[] tempPoints = new Point[3];
        tempPoints[0] = super.getPoint(0);
        tempPoints[1] = midpoints[0];
        tempPoints[2] = midpoints[2];
        return new SerpTriangle(tempPoints, generations);
    }

    public SerpTriangle newLeftTriangle() {
        Point[] tempPoints = new Point[3];
        tempPoints[0] = midpoints[2];
        tempPoints[1] = midpoints[1];
        tempPoints[2] = super.getPoint(2);
        return new SerpTriangle(tempPoints, generations);
    }

    public SerpTriangle newRightTriangle() {
        Point[] tempPoints = new Point[3];
        tempPoints[0] = midpoints[0];
        tempPoints[1] = super.getPoint(1);
        tempPoints[2] = midpoints[1];
        return new SerpTriangle(tempPoints, generations);
    }
}