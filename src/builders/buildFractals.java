package src.builders;

import src.sets.Mandelbrot;
import src.sets.fractalSet;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class buildFractals {
    private final fractalSet set;
    private int max_i = 1000;
    private int rad = 2;
    private int rgb;
    private int scale;
    private float hue;

    public buildFractals(fractalSet f){
        set = f;
    }

    //calcule le terme suivant de la suite complexe
    public Complexe nextTerm(Complexe z){
        Complexe base = z;
        int i = 0;
        int exponent = (int)set.getPolynom()[0];
        Complexe res = z;
        if(exponent==0){
            res = new Complexe(1,1);
            return res.somme(set.getC());
        }
        while (i != exponent-1) {
            res = res.multiplication(base);
            i++;
        }
        return res.somme(set.getC());
    }

    //cherche à partir de combien d'itération la suite diverge
    int divergenceIndex(Complexe z0){
        Complexe zn = z0;
        if(set instanceof Mandelbrot){
            ((Mandelbrot) set).setC(z0);
            zn = set.getC();
        }
        for(int i = 0; i<max_i; i++){
            if(zn.module()>rad){
                return i;
            }
            zn = nextTerm(zn);
        }
        return max_i;
    }

    //Coloriage des pixels selon l'indice de divergence
    public void color(BufferedImage img){
        for(int y = 0; y<img.getHeight(); y++){
            for(int x = 0; x<img.getWidth(); x++){
                float adjust = 2f;
                if(set instanceof Mandelbrot){
                    adjust = 1.5f;
                }
                int ind = divergenceIndex(new Complexe((x-img.getWidth()/adjust)/scale, (y-img.getHeight()/2f)/scale));
                rgb = Color.HSBtoRGB(Float.parseFloat(hue+"f"), 1f, ind*25f/max_i);
                if(ind == max_i){
                    rgb = 0;
                }
                img.setRGB(x, y, rgb);
            }
        }
    }

    //Ecriture de la fonction choisi pour la fractale dans le fichier
    public void displayFunction(BufferedImage img){
        int w = img.getWidth();
        int h = img.getHeight();
        Graphics2D g2d = img.createGraphics();
        g2d.drawImage(img, 0, 0, w, h, null);
        g2d.setPaint(Color.white);
        g2d.setFont(new Font("Serif", Font.BOLD, scale/10));
        String func = set.toString();
        FontMetrics fm = g2d.getFontMetrics();
        int x = 10;
        int y = fm.getHeight();
        g2d.drawString(func, x, y);
    }

    //Demande à l'utilisateur les valeurs pour la taille et la teinte
    public void requestSettings(){
        Scanner sc = new Scanner(System.in).useLocale(Locale.US);
        System.out.println("How big do you want the fractal to be ? Enter a value (200 minimum, for better render) :");
        scale = sc.nextInt();
        System.out.println("Choose a Hue value from 0.0 to 1.0 : ");
        hue = sc.nextFloat();
    }

    //création du fichier Fractal.png (ou Fractalx.png avec x un nombre si le fichier existe déjà)
    public void buildPicture() {
        var img = new BufferedImage(3*scale, 3*scale, BufferedImage.TYPE_INT_RGB);
        color(img);
        displayFunction(img);
        int id = 0;
        File f = new File("Fractal.png");
        while (f.exists()) {
            id++;
            f = new File("Fractal" + id + ".png");
        }
        try {
            ImageIO.write(img, "PNG", f);
        } catch (IOException e) {
            System.out.println("Couldn't write in file");
            e.printStackTrace();
        }
    }
}
