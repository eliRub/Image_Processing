import javax.swing.*;
import java.awt.*;

public class ErrorWindow extends JFrame {

    public static final int WINDOW_WIDTH = 500;
    public static final int WINDOW_HEIGHT = 250;

    public ErrorWindow(String str) {
        Thread thread = new Thread(()->{

            this.setVisible(true);
            this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
            this.setLocationRelativeTo(null);
            this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            this.setResizable(true);
            this.setLayout(null);

            JLabel label = new JLabel(str);
            label.setBounds(10,75,450,30);
            label.setFont(new Font("Arial", Font.BOLD, 20));
            this.add(label);

            try {
                Thread.sleep(3000);
                nextFunc();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        });thread.start();

    }
    public void nextFunc(){
        this.dispose();
        PanelWindow panelWindow = new PanelWindow();
    }
}
