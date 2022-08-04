import javax.swing.*;

public class ExplanationWindow extends JFrame {

    public static final int WINDOW_WIDTH = 450;
    public static final int WINDOW_HEIGHT = 250;
    public static final int TEXT_HEIGHT = 30;
    public static final int X = 30;
    public static final int Y = 70;

    public ExplanationWindow() {

        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setResizable(true);
        this.setLayout(null);

        JLabel explain1 = new JLabel("Go to the Facebook profile,in the url ");
        explain1.setBounds(X, Y - 50, WINDOW_WIDTH, TEXT_HEIGHT);

        this.add(explain1);

        JLabel explain2 = new JLabel( "after the https://he-il.facebook.com ");
        explain2.setBounds(X, Y, WINDOW_WIDTH, TEXT_HEIGHT);
        this.add(explain2);

        JLabel explain3 = new JLabel( "There is a unique Facebook ID, bring it , And copy this here !!!");
        explain3.setBounds(X, Y + 50, WINDOW_WIDTH, TEXT_HEIGHT);
        this.add(explain3);
        this.setVisible(true);

    }

}
