import javax.swing.*;
import java.awt.*;

public class PaintImage extends Component {

    public ImageIcon image;
    public int x;
    public int y;

    public PaintImage(ImageIcon image, int x, int y) {
        this.image = image;
        this.x = x;
        this.y = y;
    }

    @Override
    public void paint(Graphics g) {
//        this.image.paintIcon(this, g, x, y);
    }
}
