import java.awt.*;

import javax.swing.*;

public class Main {

    public static void main(String[] args){

        //JTextField        
        JTextField fnct = new JTextField();
        fnct.setBounds(615, 410, 215, 25);

        JTextField z_equal = new JTextField();
        z_equal.setBounds(615, 450, 215, 25);

        JTextField c_equal = new JTextField();
        c_equal.setBounds(615, 490, 215, 25);

        fnct.setText("degre of z (format : x) :");
        z_equal.setText("real part of c (format : x.x or x) :");
        c_equal.setText("imaginary part of c (format : x.x or x) :");

        //JLabel
        MyLabel vue = new MyLabel();
        vue.setText("Fractales");
        vue.setIcon(new ImageIcon(new ImageIcon("unknown.png").getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT)));
        vue.setIconTextGap(250);

        MyLabel rsm_lbl = new MyLabel();
        rsm_lbl.setText("Resume");

        //JPanel
        JPanel frct_pnl = new JPanel();
        frct_pnl.setBackground(Color.BLACK);
        frct_pnl.setBounds(0, 0, 600, 600);

        JPanel rsme = new JPanel();
        rsme.setBackground(new Color(0x123456));
        rsme.setBounds(600, 350, 250, 250);

        //JButton
        JButton dwnl = new JButton();
        dwnl.setBounds(615, 540, 100, 50);
        dwnl.addActionListener(e -> System.out.println("TODO"));
        dwnl.setText("Download !");
        dwnl.setFocusable(false);

        JButton new_frct = new JButton();
        new_frct.setBounds(735, 540, 100, 50);
        new_frct.addActionListener(e -> System.out.println("degre of z" + fnct.getText() + " and c = "+ c_equal.getText() + "i +"+ z_equal.getText()));
        new_frct.setText("Generate");
        new_frct.setFocusable(false);

        //MyFrame
        MyFrame frame = new MyFrame();
        frame.setTitle("Les Fractales");


        frct_pnl.add(vue);
        rsme.add(rsm_lbl);

        frame.add(dwnl);
        frame.add(new_frct);

        frame.add(fnct);
        frame.add(z_equal);
        frame.add(c_equal);

        frame.add(frct_pnl);
        frame.add(rsme);
        
        
    }
}