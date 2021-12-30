import javax.swing.event.*; 
import java.awt.*; 
import javax.swing.*; 

class MySlider implements ChangeListener { 
    
    JSlider slider = new JSlider(0, 255);

    public MySlider(){

        slider.setPaintTicks(true);
        slider.setMinorTickSpacing(10);

        slider.setPaintTrack(true);
        slider.setMajorTickSpacing(25);
    }
        
}