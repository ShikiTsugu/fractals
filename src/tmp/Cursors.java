import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

public class Cursors implements ChangeListener{
    
    JFrame frame;
    JPanel panel;
    JLabel label;
    JSlider red;
    JSlider blue;
    JSlider green;

    public Cursors(){

        frame = new JFrame("Cursors");
        panel = new JPanel();
        label = new JLabel();
        red = new JSlider(0, 255);
        blue = new JSlider(0, 255);
        green = new JSlider(0, 255);

        red.setPreferredSize(new Dimension(180, 25));
        red.setPaintTrack(true);
        red.setMajorTickSpacing(51);
        red.setPaintLabels(true);
        red.setOpaque(true);        
        
        blue.setPreferredSize(new Dimension(180, 25));
        blue.setPaintTrack(true);
        blue.setMajorTickSpacing(51);
        blue.setPaintLabels(true);        
        blue.setOpaque(true);        
        
        green.setPreferredSize(new Dimension(180, 25));
        green.setPaintTrack(true);
        green.setMajorTickSpacing(51);
        green.setPaintLabels(true);        
        green.setOpaque(true);        
        
        label.setText("red = " + red.getValue() + "; blue = " + blue.getValue() + "; green = " + green.getValue());

        red.addChangeListener(this);
        blue.addChangeListener(this);
        green.addChangeListener(this);

        frame.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 50));
        frame.setSize(250, 350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel.setPreferredSize(new Dimension(250, 350));
        panel.setLayout(new FlowLayout());

        panel.add(red);
        panel.add(blue);
        panel.add(green);
        panel.add(label);
        frame.add(panel);
        
        frame.setVisible(true);
    }

    @Override
    public void stateChanged(ChangeEvent e) {

        label.setText("red = " + red.getValue() + " blue = " + blue.getValue() + " green = " + green.getValue());

    }

    public static void main(String[] args) {
        Cursors curs  = new Cursors();
    }
}

    /*MyLabel ctrl = new MyLabel();
        ctrl.setText("Cursors");
        ctrl.setForeground(Color.BLACK);
    */

        //Cursors curs = new Cursors();
    /*MyLabel curs_lbl = new MyLabel();
        curs_lbl.setText("Cursors");
        curs_lbl.add(curs);
    */

    
    /*JPanel curs_title = new JPanel();
        curs_title.setBackground(Color.white);
        curs_title.setPreferredSize(new Dimension(50,50));

        curs.add(curs_title, BorderLayout.CENTER);
    */

    /*
    JPanel curseur = new JPanel();
        curseur.setBounds(600, 0, 250, 350);
        curseur.add(curs_lbl);
    */