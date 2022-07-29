import io.netty.handler.codec.http.QueryStringDecoder;
import org.checkerframework.checker.fenum.qual.SwingElementOrientation;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.w3c.dom.Text;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class PanelWindow extends JPanel {

    public PaintRectangle board;
    public String userNameToEnter;
    public PanelWindow(int width, int height) {

        this.setBounds(0, 0, width, height);
        this.setLayout(null);

        this.board = new PaintRectangle(0, 0, width, height);

        JButton text = new JButton("What to enter?");
        text.setBounds(width/2-80, 30, 150, 30);
        text.addActionListener((event) ->{
            ExplanationWindow explanationWindow = new ExplanationWindow();
        });
        this.add(text);

        TextField fieldForUserName = new TextField();
        fieldForUserName.setBounds((width/2)-100, text.getY()+text.getHeight()+20, 100, 30);
        this.add(fieldForUserName);


//        this.userNameToEnter = fieldForUserName.getText();


        JButton search = new JButton("search");
        search.setBounds(fieldForUserName.getX()+fieldForUserName.getWidth(), fieldForUserName.getY(), fieldForUserName.getWidth(), fieldForUserName.getHeight());
        this.add(search);


        search.addActionListener((event) ->{
            System.setProperty(
                    "webdriver.chrome.driver",
                    "C:\\Users\\ELI\\Downloads\\chromedriver_win32\\chromedriver.exe");
//            System.out.println(userNameToEnter);
            ChromeDriver driver = new ChromeDriver();
            driver.get("https://www.facebook.com"+userNameToEnter);
//            driver.get("https://www.facebook.com/eli.rubenstein.39/");

            driver.manage().window().maximize();


        });


        JButton process1 = new JButton("process1");
        process1.setBounds(fieldForUserName.getX(), search.getY()+search.getHeight()+25, search.getWidth()*2, search.getHeight());
        this.add(process1);

        JButton process2 = new JButton("process2");
        process2.setBounds(fieldForUserName.getX(), process1.getY()+process1.getHeight()+25, search.getWidth()*2, search.getHeight());
        this.add(process2);

        JButton process3 = new JButton("process3");
        process3.setBounds(fieldForUserName.getX(), process2.getY()+process2.getHeight()+25, search.getWidth()*2, search.getHeight());
        this.add(process3);

        JButton process4 = new JButton("process4");
        process4.setBounds(fieldForUserName.getX(), process3.getY()+process3.getHeight()+25, search.getWidth()*2, search.getHeight());
        this.add(process4);

        JButton process5 = new JButton("process5");
        process5.setBounds(fieldForUserName.getX(), process4.getY()+process4.getHeight()+25, search.getWidth()*2, search.getHeight());
        this.add(process5);

        JButton process6 = new JButton("process6");
        process6.setBounds(fieldForUserName.getX(), process5.getY()+process5.getHeight()+25, search.getWidth()*2, search.getHeight());
        this.add(process6);

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.board.paint(g);
    }
}
