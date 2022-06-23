import lombok.Getter;
import lombok.Setter;

import java.awt.event.MouseEvent;

public class Logic extends Adapter{

    @Getter
    private final Render render;

    @Setter
    private int mode;

    public Logic() {
        render = new Render();
        render.addMouseListener(this);
        render.addMouseMotionListener(this);
        mode = 0;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        render.startDrawLine(e);
        render.startDrawRect(e);
        render.startDrawCircle(e);
    }

    @Override
    public void mouseReleased(MouseEvent e) {

        //render.drawLine(startX, startY, endX, endY);
    }

    @Override
    public void mouseDragged(MouseEvent e) {

        switch (mode){
            case 1: render.drawLine(e);
                break;
            case 2: render.drawRect(e);
                break;
            case 3: render.drawCircle(e);
                break;
            default: render.addPoint(e);
        }
    }
}
