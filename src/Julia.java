package src;

import java.util.Locale;
import java.util.Scanner;

public class Julia {
    public final double[] polynom;
    public final Complexe z0,c;

    public Julia(){
        polynom = buildPolynom();
        this.c = new Complexe(polynom[1],polynom[2]);
        this.z0 = c;
    }

    public double[] getPolynom() {
        return polynom;
    }

    public Complexe getC() {
        return c;
    }

    public Complexe getZ0() {
        return z0;
    }

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

    public Complexe nextTerm(Complexe z){
        Complexe base = z;
        int exponent = (int)polynom[0];
        Complexe res = new Complexe(1,1);

        while (exponent != 0) {
            res = res.multiplication(base);
            --exponent;
        }
        return res;
    }

    int divergenceIndex(Complexe z0){
        int max_i = 1000;
        int rad = 2;
        int i = 0;
        Complexe zn = z0;
        while(i < max_i-1 && zn.module() <= rad){
            zn = nextTerm(zn).somme(c);
            i++;
        }
        return i;
    }

    public String toString(){
        return "{z0 = "+z0+"\n"
                + "{zn+1 = zn^" + (int)polynom[0] + " + " + "( " + c + " )" + "\n";
    }
}
