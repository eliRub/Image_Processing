import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.util.Set;

public class MainWindow extends JFrame {

    public static final int WINDOW_WIDTH = 1200;
    public static final int WINDOW_HEIGHT = 600;

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
//        System.setProperty(
//                "webdriver.chrome.driver",
//                "C:\\Users\\ELI\\Downloads\\driver//chromedriver.exe");
//      //  C:\Users\ELI\Downloads\driver//chromedriver.exe
////            System.out.println(userNameToEnter);
//        ChromeDriver driver = new ChromeDriver();
//        driver.get("https://www.facebook.com/bin.rozenblum.7");
    }
}