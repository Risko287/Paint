import lombok.Getter;
import lombok.Setter;

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
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

        render.drawLine(e);

    }
}
