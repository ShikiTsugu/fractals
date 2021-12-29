package src;

import java.util.Locale;
import java.util.Scanner;

public class Julia {
    private final double[] polynom;
    private final Complexe c;

    public Julia(){
        polynom = buildPolynom();
        this.c = new Complexe(polynom[1],polynom[2]);
    }

    public double[] getPolynom() {
        return polynom;
    }

    public Complexe getC() {
        return c;
    }

    //Création d'un polynôme complexe en demandant à l'utilisateur son degré et la valeur de la constante
    public double[] buildPolynom(){
        Scanner sc = new Scanner(System.in).useLocale(Locale.US);
        System.out.println("Enter degre of polynom (format : x) :");
        int degre = sc.nextInt();
        System.out.println("Enter the real part of the constant (format : x.x or x) :");
        double r = sc.nextDouble();
        System.out.println("Enter the imaginary part of the constant (without the i, just the value, format : x.x or x) :");
        double i = sc.nextDouble();
        return new double[]{degre, r, i};
    }

    public String toString(){
        return "f(z) = z^" + (int)polynom[0] + " + c" + "  with  c = "+c;
    }
}
