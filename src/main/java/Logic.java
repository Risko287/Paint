import lombok.Getter;

import java.awt.event.MouseEvent;

public class Logic extends Adapter{

    private int startX;
    private int startY;
    private int endX;
    private int endY;

    @Getter
    private Render render;

    public Logic() {
        render = new Render();
        render.addMouseListener(this);
        render.addMouseMotionListener(this);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        startX = e.getX();
        startY = e.getY();
        render.startDrawLine(e);
        render.startDrawRect(e);
        render.startDrawCircle(e);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        endX = e.getX();
        endY = e.getY();
        //render.drawLine(startX, startY, endX, endY);
    }

    @Override
    public void mouseDragged(MouseEvent e) {

        render.drawLine(e);
        //render.draw(e);

        render.drawRect(e);
        render.drawCircle(e);

    }
}
