import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Render extends JPanel {

    private ArrayList<Line> lines;
    private ArrayList<Rectangle> rectangles;
    private ArrayList<Circle> circles;

    private Line line;
    private Rectangle rectangle;
    private Circle circle;

    private int startX;
    private int startY;
    private int endX;
    private int endY;

    public Render() {

        lines = new ArrayList<>();
        rectangles = new ArrayList<>();
        circles = new ArrayList<>();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        lines.forEach(line -> line.draw(g));
        rectangles.forEach(rectangle -> rectangle.draw(g));
        circles.forEach(circle -> circle.draw(g));
    }

    public void draw (MouseEvent e){
        startX = e.getX();
        startY = e.getY();
        endX = startX;
        endY = startY;

        Line line = new Line(startX,startY,endX,endY,Color.black);
        lines.add(line);
        repaint();
    }

    public void startDrawLine (MouseEvent e){
        startX = e.getX();
        startY = e.getY();
        line = new Line(startX,startY,startX,startY,Color.black);
        lines.add(line);
        repaint();
    }

    public void drawLine (MouseEvent e){
        line.setX2(e.getX());
        line.setY2(e.getY());
        repaint();
    }

    public void startDrawRect (MouseEvent e){
        startX = e.getX();
        startY = e.getY();
        rectangle = new Rectangle(startX,startY,0,0,Color.black);
        rectangles.add(rectangle);
        repaint();
    }

    public void startDrawCircle (MouseEvent e){
        startX = e.getX();
        startY = e.getY();
        circle = new Circle(startX,startY,0,0,Color.black);
        circles.add(circle);
        repaint();
    }

    public void drawRect (MouseEvent e){
        rectangle.setX(Math.min(startX, e.getX()));
        rectangle.setY(Math.min(startY, e.getY()));
        rectangle.setWidth(Math.abs(e.getX() - startX));
        rectangle.setHeight(Math.abs(e.getY() - startY));
        repaint();
    }

    public void drawCircle (MouseEvent e){
        circle.setX(Math.min(startX, e.getX()));
        circle.setY(Math.min(startY, e.getY()));
        circle.setWidth(Math.abs(e.getX() - startX));
        circle.setHeight(Math.abs(e.getY() - startY));
        repaint();
    }


}
