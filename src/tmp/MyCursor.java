import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

public class MyCursor implements ChangeListener{
    
    JFrame frame;
    JPanel panel;
    JLabel label;

    JSlider slider;

    public MyCursors(){

        frame = new JFrame("Cursors");
        panel = new JPanel();
        label = new JLabel();
        
        slider = new JSlider(0, 255);

        slider.setPreferredSize(new Dimension(180, 25));
        slider.setPaintTrack(true);
        slider.setMajorTickSpacing(51);
        slider.setPaintLabels(true);
        slider.setOpaque(true);        
        
        label.setText("value = " + slider.getValue());

        slider.addChangeListener(this);

        frame.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 50));
        frame.setSize(250, 350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel.setPreferredSize(new Dimension(250, 350));
        panel.setLayout(new FlowLayout());

        panel.add(slider);
        panel.add(label);
        frame.add(panel);
        
        frame.setVisible(true);
    }

    @Override
    public void stateChanged(ChangeEvent e) {

        label.setText("value = " + slider.getValue());

    }
}