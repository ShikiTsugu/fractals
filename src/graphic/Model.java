package src.graphic;

import src.functions.Function;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Model extends JPanel {
    private JLabel title,f1,f2,f3;
    private JButton julia,mandelbrot,quit,polynom,trigonometry,back,next;
    private JTextField degre,type,cRe,cIm;
    private Function typeF;
    private int polyInfo;
    private String trigoInfo;
    private double[] constInfo = {0,0};
    private int id;

    public Model(){
        setBackground(Color.black);
        mainMenu();
    }

    public int getPolyInfo() {
        return polyInfo;
    }

    public String getTrigoInfo() {
        return trigoInfo;
    }

    public JButton getPolynom() {
        return polynom;
    }

    public JButton getTrigonometry() {
        return trigonometry;
    }

    public JButton getJulia() {
        return julia;
    }

    public JButton getMandelbrot() {
        return mandelbrot;
    }

    public JButton getQuit() {
        return quit;
    }

    public JButton getBack() {
        return back;
    }

    public int getId() {
        return id;
    }

    public JButton getNext() {
        return next;
    }

    public JTextField getDegre() {
        return degre;
    }

    public JTextField getcRe() {
        return cRe;
    }

    public JTextField getcIm() {
        return cIm;
    }

    public void setPolyInfo(int polyInfo) {
        this.polyInfo = polyInfo;
    }

    public void setTrigoInfo(String trigoInfo) {
        this.trigoInfo = trigoInfo;
    }

    public double[] getConstInfo() {
        return constInfo;
    }

    public void setConstRE(double re) {
        this.constInfo[0] = re;
    }

    public void setConstIM(double im){
        this.constInfo[1] = im;
    }

    public JTextField getType() {
        return type;
    }

    public void setTypeF(Function typeF) {
        this.typeF = typeF;
    }

    public void mainMenu(){
        id = 0;
        System.out.println("is "+id);
        setLayout(new FlowLayout(FlowLayout.CENTER,20,50));
        //Titre
        title = new JLabel("Fractal Displayer");
        title.setFont(new Font("SansSerif", Font.BOLD, 40));
        title.setForeground(Color.WHITE);
        title.setBorder(new EmptyBorder(60,0,0,0));
        add(title);
        //Bouton des Sets
        julia = new JButton("Julia");
        mandelbrot = new JButton("Mandelbrot");
        julia.setBorder(new EmptyBorder(10,40,10,40));
        mandelbrot.setBorder(new EmptyBorder(10,40,10,40));
        add(julia);
        add(mandelbrot);
        //Bouton quitter
        quit = new JButton("Quit");
        quit.setBorder(new EmptyBorder(10,40,10,40));
        add(quit);
    }

    public void typeSelect(Controller c){
        id = 1;
        System.out.println("is "+id);
        setLayout(new FlowLayout(FlowLayout.CENTER,20,50));
        //titre
        title.setText("Function Type");
        title.setBorder(new EmptyBorder(60,0,0,0));
        add(title);
        //Boutons des Types
        polynom = new JButton("Polynom");
        trigonometry = new JButton("Trigonometry");
        polynom.setBorder(new EmptyBorder(10,40,10,40));
        trigonometry.setBorder(new EmptyBorder(10,40,10,40));
        add(polynom);
        add(trigonometry);
        //Bouton retour
        back = new JButton("Back");
        back.setBorder(new EmptyBorder(10,40,10,40));
        add(back);
        c.activateTypeButtons();
    }

    public void polynomSettings(Controller c){
        degre = new JTextField("Press Enter when done");
        degre.setBorder(new EmptyBorder(5,120,5,120));
        f1 = new JLabel("Enter Degre of polynom as Integer");
        f1.setFont(new Font("SansSerif", Font.BOLD, 15));
        f1.setForeground(Color.WHITE);
        add(f1);
        add(degre);
        cRe = new JTextField("Press Enter when done");
        cRe.setBorder(new EmptyBorder(5,120,5,120));
        f2 = new JLabel("Enter Real part of Constant");
        f2.setFont(new Font("SansSerif", Font.BOLD, 15));
        f2.setForeground(Color.WHITE);
        add(f2);
        add(cRe);
        cIm = new JTextField("Press Enter when done");
        cIm.setBorder(new EmptyBorder(5,120,5,120));
        f3 = new JLabel("Enter Imaginary part of Constant");
        f3.setFont(new Font("SansSerif", Font.BOLD, 15));
        f3.setForeground(Color.WHITE);
        add(f3);
        add(cIm);
        add(back);
        next = new JButton("Next");
        next.setBorder(new EmptyBorder(10,40,10,40));
        add(next);
        c.activateJulia();
    }

    public void trigonometrySettings(Controller c){
        type = new JTextField("Press Enter when done");
        type.setBorder(new EmptyBorder(5,120,5,120));
        f1 = new JLabel("Enter Function as C(cos), S(sin) or T(tan)");
        f1.setFont(new Font("SansSerif", Font.BOLD, 15));
        f1.setForeground(Color.WHITE);
        add(f1);
        add(type);
        cRe = new JTextField("Press Enter when done");
        cRe.setBorder(new EmptyBorder(5,120,5,120));
        f2 = new JLabel("Enter Real part of Constant");
        f2.setFont(new Font("SansSerif", Font.BOLD, 15));
        f2.setForeground(Color.WHITE);
        add(f2);
        add(cRe);
        cIm = new JTextField("Press Enter when done");
        cIm.setBorder(new EmptyBorder(5,120,5,120));
        f3 = new JLabel("Enter Imaginary part of Constant");
        f3.setFont(new Font("SansSerif", Font.BOLD, 15));
        f3.setForeground(Color.WHITE);
        add(f3);
        add(cIm);
        add(back);
        next = new JButton("Next");
        next.setBorder(new EmptyBorder(10,40,10,40));
        add(next);
        c.activateJulia();
    }

    public void juliaSettings(Controller c){
        id = 2;
        System.out.println("is "+id);
        setLayout(new FlowLayout(FlowLayout.CENTER,50,10));
        //titre
        title.setText("Julia Set");
        title.setBorder(new EmptyBorder(40,0,0,0));
        add(title);
        //options selon le type de la fonction
        if(!trigonometry.isEnabled()){
            polynomSettings(c);
        }
        if(!polynom.isEnabled()){
            trigonometrySettings(c);
        }
    }
}
