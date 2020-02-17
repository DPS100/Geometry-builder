public class Point {

    private int[] coords;
    private boolean onScreen;

    public Point(int x, int y) {
        coords = new int[2];
        setPoint(x,y);
    }

    public Point() {
        coords = new int[2];
        setPoint(-1,-1);
    }

    public void setOnScreen() {
        if(getXCoord() <= -1 || getYCoord() <= -1) {onScreen = false;}
        else{onScreen = true;}
    }
    
    public void setPoint(int x, int y) {
        setXCoord(x);
        setYCoord(y);
    }

    public void setXCoord(int x) {
        coords[0] = x;
        setOnScreen();
    }

    public void setYCoord(int y) {
        coords[1] = y;
        setOnScreen();
    }

    public Boolean getOnScreen() {
        return onScreen;
    }

    public int[] getPoint() {
        return coords;
    }

    public int getXCoord() {
        return coords[0];
    }

    public int getYCoord() {
        return coords[1];
    }

    public String toString(){
        return ("Point (" + getXCoord() + ", " + getYCoord() + ") exists = " + getOnScreen());
    }
}