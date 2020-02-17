import javax.swing.event.MouseInputListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;

public class Window extends JPanel implements MouseInputListener, KeyListener {

    private static final long serialVersionUID = 1L;
    private JFrame frame;
    private int width = 500;
    private int height = 500;
    private Dimension size;
    private int mouseDraggedX;
    private int mouseDraggedY;
    private boolean mouseIsDragged = false;
    public Line testLine; //TODO these are tests ->
    public int aX;
    public int aY;
    public int bX;
    public int bY;
    public Point pointA;
    public Point pointB; 
    public Container container;//<-

    public static void main(String[] args){
        new Window();
    }

    public Window() { //TODO add side menu
        frame = new JFrame("Geometry Builder");
        size = new Dimension(width, height);
        aX = 10;
        aY = 10;
        bX = 100;
        bY = 100;
        pointA = new Point(aX, aY);
        pointB = new Point(bX, bY);
        testLine = new Line(pointA, pointB);
        container = new Container();
        container.addLine(testLine);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        frame.setVisible(true);
        frame.setContentPane(this);
        frame.setPreferredSize(size);
        frame.setSize(size);
        frame.pack();
        frame.setFocusTraversalKeysEnabled(false);
        frame.setLocationRelativeTo(null);

        addMouseListener(this);
        addMouseMotionListener(this);

        System.out.println(container.getLine(0).toString());
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        runWindow(g2d);
    }

    private void runWindow(Graphics2D g2d) {
        doLogic();
        clearPast(g2d);
        drawContainer(g2d);
        repaint();
    }

    private void doLogic() {
        //TODO add, remove, edit lines
    }

    private void clearPast(Graphics2D g2d) {
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, width, height);
    }

    private void drawLine(Graphics2D g2d, Line line) {
        g2d.setColor(Color.BLACK);
        g2d.drawLine(
            line.getPointA().getXCoord(),
            line.getPointA().getYCoord(),
            line.getPointB().getXCoord(),
            line.getPointB().getYCoord()
        );
    }

    private void drawContainer(Graphics2D g2d) {
        for(int x = 0; x < container.getLinesLength(); x++) {
            if(container.getLine(x).getComplete()) {drawLine(g2d, container.getLine(x));}
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {mouseIsDragged = true;}

    @Override
    public void mouseReleased(MouseEvent e) {mouseIsDragged = false;}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

    @Override
    public void mouseDragged(MouseEvent e) {
        mouseDraggedX = e.getX();
        mouseDraggedY = e.getY();
    }

    @Override
    public void mouseMoved(MouseEvent e) {}

    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println(e.getKeyCode());
    }

    @Override
    public void keyPressed(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {}
}