package src.graphic;

import javax.swing.*;

public class View extends JFrame {
    private Model model;

    public View(){
        model = new Model();
        setTitle("Fractal Displayer");
        setSize(400,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
