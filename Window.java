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
    public Container container;

    public static void main(String[] args){
        new Window();
    }

    public Window() {
        frame = new JFrame("Geometry Builder");
        size = new Dimension(width, height);
        container = new Container();

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
        frame.addKeyListener(this);
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        runWindow(g2d);
    }

    private void runWindow(Graphics2D g2d) {
        container.logic();
        clearPast(g2d);
        drawContainer(g2d);
        repaint();
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

    private void drawPoint(Graphics2D g2d, Point point) {
        g2d.setColor(Color.RED);
        g2d.fillOval(point.getXCoord() - 10, point.getYCoord() - 10, 20, 20);
    }

    private void drawContainer(Graphics2D g2d) {
        
        //Draw points
        for(int x = 0; x < container.getLinesLength(); x++) {
            if(container.getLinesLength() > 0){
                if(container.getLine(x) != null){
                    if(container.getLine(x).isComplete()) {drawLine(g2d, container.getLine(x));}
                }
            }
        }
        
        //Draw Lines
        for(int x = 0; x < container.getPointsLength(); x++) {
            if(container.getPointsLength() > 0){
                if(container.getPoint(x) != null){
                    if(container.getPoint(x).getOnScreen()) {drawPoint(g2d, container.getPoint(x));}
                }
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {/*
        container.setMouseClick(true);
        container.setMouseCoords(e.getX(), e.getY());
        */
    }

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

    @Override
    public void mouseDragged(MouseEvent e) {}

    @Override
    public void mouseMoved(MouseEvent e) {}

    @Override
    public void keyTyped(KeyEvent e) {
        //container.checkInput(e.getKeyChar());
    }

    @Override
    public void keyPressed(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {}
}