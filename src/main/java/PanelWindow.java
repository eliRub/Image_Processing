
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class PanelWindow extends JPanel {
    public TextField fieldForUserName;
    public JButton search;

    public static final int WINDOW_WIDTH = 400;
    public static final int WINDOW_HEIGHT = 400;

    public PanelWindow() {
        JFrame frame = new JFrame();
        frame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        try {
            PanelWindow panelWindow = new PanelWindow(frame);
            frame.setVisible(true);
            frame.add(panelWindow);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static void main(String[] args) {
        PanelWindow panelWindow = new PanelWindow();
    }

    public PanelWindow(JFrame frame) throws IOException  {
        this.setBounds(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setLayout(null);

        JButton text = new JButton("What to enter?");
        text.setBounds(WINDOW_WIDTH/2-80, 15, 150, 30);
        text.addActionListener((event) ->{
            ExplanationWindow explanationWindow = new ExplanationWindow();
        });
        this.add(text);

        fieldForUserName = new TextField();
        fieldForUserName.setBounds((WINDOW_WIDTH/2)-100, text.getY()+text.getHeight()+20, 100, 30);
        this.add(fieldForUserName);

        search = new JButton("search");
        search.setBounds(fieldForUserName.getX()+fieldForUserName.getWidth(), fieldForUserName.getY(), fieldForUserName.getWidth(), fieldForUserName.getHeight());
        this.add(search);
        search.addActionListener((event) ->{

            try {
                frame.dispose();
                MainFrame mainFrame = new MainFrame("https://www.facebook.com"+fieldForUserName.getText());

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }
}

// eli1  ->  "C:\Users\Eliyahu toronto\Dropbox\PC\Downloads\driver\chromedriver.exe";
// yoni  -> "C:\\Users\\User\\Downloads\\chromedriver_win32\\chromedriver.exe"
// eli -> "C:\\Users\\ELI\\Downloads\\chromedriver_win32\\chromedriver.exe"
