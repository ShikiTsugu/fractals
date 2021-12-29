package src.sets;

import src.builders.Complexe;

import java.util.Locale;
import java.util.Scanner;

public class Mandelbrot extends fractalSet{
    private final double[] polynom;
    private Complexe c;

    public Mandelbrot(){
        super();
        polynom = buildPolynom();
        this.c = new Complexe(0,0);
    }

    public double[] getPolynom() {
        return polynom;
    }

    public Complexe getC() {
        return c;
    }

    public void setC(Complexe c) {
        this.c = c;
    }

    //Création d'un polynôme complexe en demandant à l'utilisateur son degré
    public double[] buildPolynom(){
        Scanner sc = new Scanner(System.in).useLocale(Locale.US);
        System.out.println("Enter degre of polynom (format : x) :");
        int degre = sc.nextInt();
        return new double[]{degre};
    }

    public String toString(){
        return "f(z) = z^" + (int)polynom[0] + " + c  with  z0 = 0";
    }
}
