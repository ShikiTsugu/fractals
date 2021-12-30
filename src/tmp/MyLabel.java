import java.awt.Color;

import javax.swing.JLabel;
public class MyLabel extends JLabel{
    
    public MyLabel(){
        this.setHorizontalTextPosition(JLabel.CENTER);
        this.setVerticalTextPosition(JLabel.TOP);
        this.setHorizontalAlignment(JLabel.CENTER);
        this.setVerticalAlignment(JLabel.CENTER);
        this.setForeground(Color.white);
    }
}
