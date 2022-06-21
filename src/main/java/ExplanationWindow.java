import javax.swing.*;

public class ExplanationWindow extends JFrame {

    public static final int WINDOW_WIDTH = 400;
    public static final int WINDOW_HEIGHT = 250;
    public static final int TEXT_HEIGHT = 30;
    public static final int X = 30;
    public static final int Y = 70;

    public ExplanationWindow() {
        this.setVisible(true);
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setResizable(true);
        this.setLayout(null);

        JLabel explain1 = new JLabel("Go to the Facebook profile, there is a button with 3 points");
        explain1.setBounds(X, Y - 50, WINDOW_WIDTH, TEXT_HEIGHT);

        this.add(explain1);

        JLabel explain2 = new JLabel( "Click on it, and then click on status account");
        explain2.setBounds(X, Y, WINDOW_WIDTH, TEXT_HEIGHT);
        this.add(explain2);

        JLabel explain3 = new JLabel( "And there under a username there is a string, bring it.");
        explain3.setBounds(X, Y + 50, WINDOW_WIDTH, TEXT_HEIGHT);
        this.add(explain3);
    }

}
