import javax.swing.*;

public class Button extends JButton {
    public Button(String text ,String name , int x,int y,int width , int height){
        JButton button = new JButton(text);
        button.setBounds(x,y,width,height);


    }
}
