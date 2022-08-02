import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import javax.swing.*;
import java.io.IOException;
import java.util.List;


public class MainWindow extends JFrame {

    public static final int WINDOW_WIDTH = 1200;
    public static final int WINDOW_HEIGHT = 600;

    public MainWindow() {

        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setLayout(null);


        PanelWindow panelWindow = null;
        try {
            panelWindow = new PanelWindow(WINDOW_WIDTH, WINDOW_HEIGHT);
            this.setVisible(true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        this.add(panelWindow);


    }

    public static void main(String[] args) {
        MainWindow mainWindow = new MainWindow();
    }

}