import org.checkerframework.checker.units.qual.C;

import javax.swing.*;
import java.awt.*;
import java.util.Set;

public class MainWindow extends JFrame {

    public static final int WINDOW_WIDTH = 1000;
    public static final int WINDOW_HEIGHT = 500;

    public MainWindow() {
        this.setVisible(true);
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(true);
        this.setLayout(null);

        PanelWindow panelWindow = new PanelWindow(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.add(panelWindow);


    }

    public static void main(String[] args) {
        MainWindow mainWindow = new MainWindow();
     }
}