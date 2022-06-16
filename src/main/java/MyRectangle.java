import java.awt.*;

public class MyRectangle {

    public int x;
    public int y;
    public int width;
    public int height;

    public MyRectangle(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void paint(Graphics g) {
        g.setColor(Color.black);
        g.fillRect(this.x, this.y, this.width, this.height);
    }




}
