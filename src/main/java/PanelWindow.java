import org.openqa.selenium.chrome.ChromeDriver;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class PanelWindow extends JPanel {

    public PaintRectangle board;
    public String userNameToEnter;

    public PanelWindow(int width, int height)  throws IOException {

        this.setBounds(0, 0, width, height);
        this.setLayout(null);

        this.board = new PaintRectangle(0, 0, width, height);

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
                    "C:\\Users\\User\\Downloads\\chromedriver\\chromedriver.exe");
            ChromeDriver driver = new ChromeDriver();


        });



        String path = "https://scontent.fsdv1-2.fna.fbcdn.net/v/t1.6435-1/116319167_162575712015302_3747560749600239230_n.jpg?stp=dst-jpg_s320x320&_nc_cat=108&ccb=1-7&_nc_sid=7206a8&_nc_ohc=KVicVDuXHKsAX9s7brZ&_nc_ht=scontent.fsdv1-2.fna&oh=00_AT8GAENPo9YbF0jMKZhmi2erp-QJJu9fcu3PL4VzA4Ihcg&oe=630A96AA";
        URL url = new URL(path);
        BufferedImage img = ImageIO.read(url);
        BufferedImage picture = resize(img, new Dimension(250, 250));


        File file = new File("C:\\Users\\User\\OneDrive\\שולחן העבודה\\image\\src\\main\\java\\gal2.jpg");

        ImageIO.write(picture , "png" , file);
        File output = new File("C:\\Users\\User\\OneDrive\\שולחן העבודה\\image\\src\\main\\java\\picture2.jpg");


        JLabel label = new JLabel(new ImageIcon(picture));
        label.setBounds(75 , 100 ,picture.getWidth(),picture.getHeight() );
        this.add(label);

        JButton button1 = new JButton();
        button1.setText("process1");
        button1.setBounds(fieldForUserName.getX(), search.getY()+search.getHeight()+20, search.getWidth()*2, search.getHeight()+1);
        this.add(button1);

        button1.addActionListener((event)->{
            try {
                Filters filter = new Filters(picture ,1 , output);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });


        JButton button2 = new JButton();
        button2.setText("process2");
        button2.setBounds(fieldForUserName.getX(),button1.getY() + button1.getHeight()+20 , search.getWidth()*2, search.getHeight());
        this.add(button2);

        button2.addActionListener((event)->{
            try {
                Filters filter = new Filters(picture ,2 , output);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });




        JButton button3 = new JButton();
        button3.setText("process3");
        button3.setBounds(fieldForUserName.getX(), button2.getY() + button2.getHeight()+20 , search.getWidth()*2, search.getHeight());
        this.add(button3);

        button3.addActionListener((event)->{
            try {
                Filters filter = new Filters(picture ,3 , output);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });


        JButton button4 = new JButton( );
        button4.setText("process4");
        button4.setBounds(fieldForUserName.getX(), button3.getY()+button3.getHeight()+20, search.getWidth()*2, search.getHeight());
        this.add(button4);

        button4.addActionListener((event)->{
            try {
                Filters filter = new Filters(picture ,4 , output);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });


        JButton button5 = new JButton();
        button5.setText("process5");
        button5.setBounds(fieldForUserName.getX(), button4.getY()+button4.getHeight()+20, search.getWidth()*2, search.getHeight());
        this.add(button5);

        button5.addActionListener((event)->{
            try {
                Filters filter = new Filters(picture ,5 , output);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        JButton button6 = new JButton();
        button6.setText("process6");
        button6.setBounds(fieldForUserName.getX(), button5.getY()+button4.getHeight()+20, search.getWidth()*2, search.getHeight());
        this.add(button6);

        button6.addActionListener((event)->{
            try {
                Filters filter = new Filters(picture ,6 , output);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });


//        while (true) {
            BufferedImage image = ImageIO.read(output);
//            int oldPicture = picture.getRGB(100,100);
//            int pixel = image.getRGB( 100 , 100);
//            Color color = new Color(pixel);
//            Color color1 = new Color(oldPicture);
//            if ((color.getBlue() + color.getRed() + color.)) {
//
                JLabel outputImage = new JLabel(new ImageIcon(image));
                outputImage.setBounds(650 , 100 ,250 , 250 );
                this.add(outputImage);
//            }
//        }


    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.board.paint(g);
    }

    public BufferedImage resize( BufferedImage image,  Dimension size) {
        BufferedImage resized = new BufferedImage(size.width, size.height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = resized.createGraphics();
        g.drawImage(image, 0, 0, size.width, size.height, null);
        g.dispose();
        return resized;

    }
}
