public class SerpTriangle extends Shape{

    public int generations;
    private Point[] midpoints;

    public SerpTriangle(Point[] points) {
        super(points);
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
}