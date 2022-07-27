import io.netty.handler.codec.http.QueryStringDecoder;
import org.checkerframework.checker.fenum.qual.SwingElementOrientation;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.IMarkerFactory;
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

    public PaintImage image;
    public PanelWindow(int width, int height) {

        this.setBounds(0, 0, width, height);
        this.setLayout(null);

        this.board = new PaintRectangle(0, 0, width, height);

        JButton text = new JButton("What to enter?");
        text.setBounds(width/2-75, 30, 150, 30);
        text.addActionListener((event) -> {
            ExplanationWindow explanationWindow = new ExplanationWindow();
        });
        this.add(text);

        TextField fieldForUserName = new TextField();
        fieldForUserName.setBounds((width/2)-100, text.getY()+text.getHeight()+25, 100, 30);
        this.add(fieldForUserName);


//        fieldForUserName.setText("lie");

        this.userNameToEnter = fieldForUserName.getText();


        JButton search = new JButton("search");
        search.setBounds(fieldForUserName.getX()+fieldForUserName.getWidth(), fieldForUserName.getY(), fieldForUserName.getWidth(), fieldForUserName.getHeight());
        this.add(search);

        search.addActionListener((event) ->{
            System.setProperty(
                    "webdriver.chrome.driver",
                    "C:\\Users\\ELI\\Downloads\\chromedriver_win32\\chromedriver.exe");
//            System.out.println(userNameToEnter);
            ChromeDriver driver = new ChromeDriver();
            driver.get("https://www.facebook.com/bin.rozenblum.7");
//            driver.get("https://www.facebook.com/eli.rubenstein.39/");
            driver.manage().window().maximize();
            java.util.List <WebElement> findPhoto = driver.findElements(By.cssSelector("#mount_0_0_ra > div > div:nth-child(1) > div > div.rq0escxv.l9j0dhe7.du4w35lb > div > div > div.j83agx80.cbu4d94t.d6urw2fd.dp1hu0rb.l9j0dhe7.du4w35lb > div.j83agx80.cbu4d94t.dp1hu0rb > div > div > div:nth-child(1) > div.rq0escxv.l9j0dhe7.du4w35lb.j83agx80.pfnyh3mw.taijpn5t.gs1a9yip.owycx6da.btwxx1t3.ihqw7lf3.cddn0xzi > div > div > div > div.mpmpiqla.aovbcota.fln0ibad.anxc55fr.aw8vmcxp.l54s1dlg.a0ua4ts5.rmzkg9qa > div > a > div > svg > g > image"));
            java.util.List<WebElement> submit = driver.findElements(By.id("wp-submit"));

//
//
//            String src = findPhoto.getAttribute("i09qtzwb n7fi1qx3 b5wmifdl hzruof5a pmk7jnqg j9ispegn kr520xx4 c5ndavph art1omkt ot9fgl3s rnr61an3 s45kfl79 emlxlaya bkmhp75w spb7xbtv");
//            BufferedImage bufferedImage = null;
//            try {
//                bufferedImage = ImageIO.read(new URL(src));
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//            File outfile = new File("saved.png");
//            try {
//                ImageIO.write(bufferedImage, "png", outfile);
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }


//            WebElement logo = driver.findElement(By.cssSelector("#mount_0_0_d3 > div > div:nth-child(1) > div > div.rq0escxv.l9j0dhe7.du4w35lb > div > div > div.j83agx80.cbu4d94t.d6urw2fd.dp1hu0rb.l9j0dhe7.du4w35lb > div.j83agx80.cbu4d94t.dp1hu0rb > div > div > div:nth-child(1) > div.rq0escxv.l9j0dhe7.du4w35lb.j83agx80.pfnyh3mw.taijpn5t.gs1a9yip.owycx6da.btwxx1t3.ihqw7lf3.cddn0xzi > div > div > div > div.mpmpiqla.aovbcota.fln0ibad.anxc55fr.aw8vmcxp.l54s1dlg.a0ua4ts5.rmzkg9qa > div > a > div > div"));
//            String logoSRC = logo.getAttribute("src");
//
//            URL imageURL = null;
//            try {
//                imageURL = new URL(logoSRC);
//            } catch (MalformedURLException e) {
//                throw new RuntimeException(e);
//            }
//            BufferedImage saveImage = null;
//            try {
//                saveImage = ImageIO.read(imageURL);
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//
//            try {
//                ImageIO.write(saveImage, "png", new File("logo-image.png"));
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }

          ImageIcon imageI = new ImageIcon("C:\\Users\\ELI\\Desktop\\coding and cyber\\java\\Image_Processing\\src\\cars.png");
          this.image = new PaintImage(imageI, 10, 30);

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
        this.image.paint(g);
    }

}
