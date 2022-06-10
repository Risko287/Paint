import lombok.Setter;

import java.awt.*;

public class Circle {
    @Setter
    private int x;
    @Setter
    private int y;
    @Setter
    private int width;
    @Setter
    private int height;

    private final Color color;

    public Circle(int x, int y, int width, int height, Color color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
    }

    public void draw (Graphics g){

        g.setColor(color);
        g.drawOval(x, y, width, height);

    }
}
