package src;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class buildFractals {
    private final Julia julia;
    private int max_i = 1000;
    private int rad = 2;
    private Color color;

    public buildFractals(Julia j){
        julia = j;
    }

    //calcule le terme suivant de la suite complexe
    public Complexe nextTerm(Complexe z){
        Complexe base = z;
        int i = 0;
        int exponent = (int)julia.getPolynom()[0];
        Complexe res = z;

        while (i != exponent-1) {
            res = res.multiplication(base);
            i++;
        }
        return res.somme(julia.getC());
    }

    //cherche à partir de combien d'itération la suite diverge
    int divergenceIndex(Complexe z0){
        int i = 0;
        Complexe zn = z0;
        while(i < max_i-1 && zn.module() <= rad){
            zn = nextTerm(zn);
            i++;
        }
        return i;
    }

    public void color(BufferedImage img){
        for(int y = 0; y<img.getHeight(); y++){
            for(int x = 0; x<img.getWidth(); x++){
                int ind = divergenceIndex(new Complexe((x-img.getWidth()/2f)/200, (y-img.getHeight()/2f)/200));
                System.out.println(ind);
                color = new Color((111*ind)/max_i,0,(255*ind)/max_i);
                img.setRGB(x, y, color.getRGB());
            }
        }
    }

    //création du fichier Fractal.png (ou Fractalx.png avec x un nombre si le fichier existe déjà)
    public void buildPicture() {
        var img = new BufferedImage(600, 600, BufferedImage.TYPE_INT_RGB);
        color(img);
        int id = 1;
        File f = new File("Fractal.png");
        if (f.exists()) {
            f = new File("Fractal" + id + ".png");
            while (f.exists()) {
                id++;
                f = new File("Fractal" + id + ".png");
            }
        }
        try {
            ImageIO.write(img, "PNG", f);
        } catch (IOException e) {
            System.out.println("Couldn't write in file");
            e.printStackTrace();
        }
    }
}
