public class Point {

    private int[] coords;
    private static int xCoord = 0;
    private static int yCoord = 1;
    private static int length = 2;
    private static int minumum = 0;
    private boolean onScreen;

    public Point(Point point) {
        coords = new int[length];
        setPoint(point.getXCoord(), point.getYCoord());
    }

    public Point(int x, int y) {
        coords = new int[length];
        setPoint(x,y);
    }

    public Point() {
        coords = new int[length];
        setPoint(minumum - 1, minumum - 1);
    }

    public void setOnScreen() {
        if(getXCoord() < minumum || getYCoord() < minumum) {onScreen = false;}
        else{onScreen = true;}
    }
    
    public void setPoint(int x, int y) {
        setXCoord(x);
        setYCoord(y);
    }

    public void setXCoord(int x) {
        coords[xCoord] = x;
        setOnScreen();
    }

    public void setYCoord(int y) {
        coords[yCoord] = y;
        setOnScreen();
    }

    public Boolean getOnScreen() {
        return onScreen;
    }

    public int[] getPoint() {
        return coords;
    }

    public int getXCoord() {
        return coords[xCoord];
    }

    public int getYCoord() {
        return coords[yCoord];
    }

    public String toString(){
        if (getOnScreen()){return ("Point (" + getXCoord() + ", " + getYCoord() + ") exists = " + getOnScreen());}
        else {return "No point";}
    }
}