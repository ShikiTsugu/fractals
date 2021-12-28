package src;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class buildFractals {
    private final Julia julia;

    public buildFractals(Julia j){
        julia = j;
    }

    public void color(BufferedImage img){

    }

    //création du fichier Fractal.png (ou Fractalx.png avec x un nombre si le fichier existe déjà)
    public void buildPicture() {
        var img = new BufferedImage(210, 210, BufferedImage.TYPE_INT_RGB);
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
