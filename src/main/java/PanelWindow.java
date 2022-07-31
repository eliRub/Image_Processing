
import org.openqa.selenium.chrome.ChromeDriver;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class PanelWindow extends JPanel {

    public String userNameToEnter;
    public BufferedImage image;
    public ImageIcon AfterFilter;
    public BufferedImage picture;
    public File output;

    public PanelWindow(int width, int height)  throws IOException {

        this.setBounds(0, 0, width, height);
        this.setLayout(null);

        JButton text = new JButton("What to enter?");
        text.setBounds(width/2-80, 15, 150, 30);
        text.addActionListener((event) ->{
            ExplanationWindow explanationWindow = new ExplanationWindow();
        });
        this.add(text);

        TextField fieldForUserName = new TextField();
        fieldForUserName.setBounds((width/2)-100, text.getY()+text.getHeight()+20, 100, 30);
        this.add(fieldForUserName);

        this.userNameToEnter = fieldForUserName.getText();

        JButton search = new JButton("search");
        search.setBounds(fieldForUserName.getX()+fieldForUserName.getWidth(), fieldForUserName.getY(), fieldForUserName.getWidth(), fieldForUserName.getHeight());
        this.add(search);

        search.addActionListener((event) ->{
            System.setProperty(
                    "webdriver.chrome.driver",
                    "C:\\\\Users\\\\Eliyahu toronto\\\\Dropbox\\\\PC\\\\Downloads\\\\Eli\\\\chromedriver.exe");
            ChromeDriver driver = new ChromeDriver();

        });

        String path = "https://scontent.fsdv1-2.fna.fbcdn.net/v/t1.6435-1/116319167_162575712015302_3747560749600239230_n.jpg?stp=dst-jpg_s320x320&_nc_cat=108&ccb=1-7&_nc_sid=7206a8&_nc_ohc=KVicVDuXHKsAX9s7brZ&_nc_ht=scontent.fsdv1-2.fna&oh=00_AT8GAENPo9YbF0jMKZhmi2erp-QJJu9fcu3PL4VzA4Ihcg&oe=630A96AA";
        URL url = new URL(path);
        BufferedImage img = ImageIO.read(url);
        picture = resize(img, new Dimension(350, 350));

        File file = new File("C:\\Users\\Eliyahu toronto\\Image_Processing3\\src\\main\\java\\gal2.jpg");
        ImageIO.write(picture , "png" , file);

        output = new File("C:\\Users\\Eliyahu toronto\\Image_Processing3\\src\\main\\java\\picture2.jpg");
        image = ImageIO.read(output);
        AfterFilter = new ImageIcon((picture));

        JLabel original = new JLabel(new ImageIcon(picture));
        original.setBounds(75 , 100 ,picture.getWidth(),picture.getHeight() );
        this.add(original);

        JButton button1 = createButton("שחור לבן",fieldForUserName.getX(), search.getY()+search.getHeight()+20, search.getWidth()*2, search.getHeight()+1 , 1);
        this.add(button1);

        JButton button2 = createButton("מראה" , fieldForUserName.getX(),button1.getY() + button1.getHeight()+20 , search.getWidth()*2, search.getHeight() , 2);
        this.add(button2);

        JButton button3 = createButton("process3",fieldForUserName.getX(), button2.getY() + button2.getHeight()+20 , search.getWidth()*2, search.getHeight() , 3);
        this.add(button3);

        JButton button4 = createButton("process4",fieldForUserName.getX(), button3.getY()+button3.getHeight()+20, search.getWidth()*2, search.getHeight() , 4);
        this.add(button4);

        JButton button5 = createButton("process5",fieldForUserName.getX(), button4.getY()+button4.getHeight()+20, search.getWidth()*2, search.getHeight() , 5);
        this.add(button5);

        JButton button6 = createButton("process6",fieldForUserName.getX(), button5.getY()+button4.getHeight()+20, search.getWidth()*2, search.getHeight() , 6);
        this.add(button6);

    }
    public JButton createButton(String name, int x, int y, int width, int height , int numOfFilter){
        JButton button = new JButton(name);
        button.setBounds(x , y ,width,height);
        button.addActionListener((event)->{
            try {
                Filters filter = new Filters(picture ,numOfFilter , output);
                AfterFilter =  new ImageIcon(ImageIO.read(output));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            paint(getGraphics());
        });
        return button;

    }


    public void paint(Graphics g){
        super.paint(g);
        g.drawImage(AfterFilter.getImage(),750,100,null);

    }

    public BufferedImage resize( BufferedImage image,  Dimension size) {
        BufferedImage resized = new BufferedImage(size.width, size.height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = resized.createGraphics();
        g.drawImage(image, 0, 0, size.width, size.height, null);
        g.dispose();
        return resized;

    }

}

// eliyahu  ->  "C:\\Users\\Eliyahu toronto\\Dropbox\\PC\\Downloads\\Eli\\chromedriver.exe";
// yoni  -> "C:\\Users\\User\\Downloads\\chromedriver_win32\\chromedriver.exe"
// eli -> "C:\\Users\\ELI\\Downloads\\chromedriver_win32\\chromedriver.exe"
