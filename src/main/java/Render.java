import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Render extends JPanel {

    private ArrayList<Line> lines;

    public Render() {

        lines = new ArrayList<>();
        //line = new Line(50,50,300,300, Color.black);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        lines.forEach((line -> line.draw(g)));
    }

    public void drawLine (MouseEvent e){
        int startX = e.getX();
        int startY = e.getY();
        int endX = startX;
        int endY = startY;

        System.out.println(e.getPoint());
        Line line = new Line(startX,startY,endX,endY,Color.black);
        lines.add(line);
        repaint();
    }
}
