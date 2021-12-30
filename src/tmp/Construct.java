import java.awt.*;

import javax.swing.*;

public class Construct {
    
    public static void main(String[] args) {
        
        JTextField deg = new JTextField();
        deg.setBounds(615, 410, 215, 25);
        deg.setText("degre of z (format : x) :");
        deg.add(panel);

        JTextField real = new JTextField();
        real.setBounds(615, 450, 215, 25);
        real.setText("real part of c (format : x.x or x) :");
        real.add(panel);

        JTextField imag = new JTextField();
        imag.setBounds(615, 490, 215, 25);
        imag.setText("imaginary part of c (format : x.x or x) :");
        imag.add(panel);

        MyFrame frame = new MyFrame();
        MyLabel label = new MyLabel();
        label.setText("Create a new fractal");

        JPanel panel = new JPanel();
        panel.setBackground(new Color(0x123456));
        panel.setBounds(600, 350, 250, 250);

        JButton dwnl = new JButton();
        dwnl.setBounds(615, 540, 100, 50);
        dwnl.addActionListener(e -> System.out.println("TODO"));
        dwnl.setText("Download !");
        dwnl.setFocusable(false);
        dwnl.add(panel);

        JButton new_frct = new JButton();
        new_frct.setBounds(735, 540, 100, 50);
        new_frct.addActionListener(e -> System.out.println("Function = " + fnct.getText() + " with z = "+ z_equal.getText() + " and c = "+ c_equal.getText()));
        new_frct.setText("Generate");
        new_frct.setFocusable(false);
        new_frct.add(panel);


        panel.add(label);
        frame.add(panel);
    }

        
}
