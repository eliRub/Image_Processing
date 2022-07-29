import java.awt.*;

public class PaintRectangle {

    public int x;
    public int y;
    public int width;
    public int height;

    public PaintRectangle(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void paint(Graphics g) {
        g.setColor(Color.lightGray);
        g.fillRect(this.x, this.y, this.width, this.height);
    }




}
