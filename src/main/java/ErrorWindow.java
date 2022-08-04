import javax.swing.*;
import java.awt.*;

public class ErrorWindow extends JFrame {

    public static final int WINDOW_WIDTH = 450;
    public static final int WINDOW_HEIGHT = 250;

    public ErrorWindow(String str) {
       Thread thread = new Thread(()->{
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setResizable(true);
        this.setLayout(null);

        JLabel label = new JLabel(str);
        label.setBounds(10, 75, 400, 30);
        label.setFont(new Font("Arial", Font.BOLD, 20));
        this.add(label);

        this.setVisible(true);
        nextFunc();
       });thread.start();

    }
    public void nextFunc(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        this.dispose();
        PanelWindow panelWindow = new PanelWindow();
    }
}
