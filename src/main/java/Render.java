import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.LinkedList;

public class Render extends JPanel {

    @Getter
    private final LinkedList<Point> points;
    private final ArrayList<Line> lines;
    private final ArrayList<Rectangle> rectangles;
    private final ArrayList<Circle> circles;

    private Line line;
    private Rectangle rectangle;
    private Circle circle;

    @Setter
    private Color color;

    private int startX;
    private int startY;

    public Render() {

        points = new LinkedList<>();
        lines = new ArrayList<>();
        rectangles = new ArrayList<>();
        circles = new ArrayList<>();
        color = Color.BLACK;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
        lines.forEach(line -> line.draw(g));
        rectangles.forEach(rectangle -> rectangle.draw(g));
        circles.forEach(circle -> circle.draw(g));
    }

    public void addPoint(MouseEvent e) {
        points.addFirst(e.getPoint());
        repaint();
    }

    public void draw (Graphics g){

        if(!points.isEmpty()) {
            for(int i = 0; i < points.size()-1; i++) {
                Point first = points.get(i);
                Point second = points.get(i+1);
                new Line((int) first.getX(), (int) first.getY(), (int) second.getX(), (int) second.getY(), color).draw(g);
            }
        }

        repaint();
    }

    public void startDrawLine (MouseEvent e){
        startX = e.getX();
        startY = e.getY();
        line = new Line(startX,startY,startX,startY,color);
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
        rectangle = new Rectangle(startX,startY,0,0,color);
        rectangles.add(rectangle);
        repaint();
    }

    public void startDrawCircle (MouseEvent e){
        startX = e.getX();
        startY = e.getY();
        circle = new Circle(startX,startY,0,0,color);
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
