import lombok.Setter;

import java.awt.*;

public class Line {
    private final int x1;
    private final int y1;

    @Setter
    private int x2;
    @Setter
    private int y2;

    private final Color color;

    public Line(int x1, int y1, int x2, int y2, Color color) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.color = color;
    }

    public void draw (Graphics g){

        g.setColor(color);
        g.drawLine(x1, y1, x2, y2);

    }
}
