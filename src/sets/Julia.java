package src.sets;

import src.builders.Complexe;
import src.functions.Function;
import src.functions.Polynom;
import src.functions.Trigonometry;

import java.util.Locale;
import java.util.Scanner;

public class Julia extends fractalSet{
    private final Function type;
    private final Complexe c;

    public Julia(){
        super();
        type = requestType();
        c = requestConstant();
    }

    @Override
    public Function getType() {
        return type;
    }

    public Complexe getC() {
        return c;
    }
    //Création de la constante c avec les valeurs souhaitées par l'utilisateur

    public Complexe requestConstant(){
        Scanner sc = new Scanner(System.in).useLocale(Locale.US);
        System.out.println("Enter the real part of the constant (format : x.x or x) :");
        double r = sc.nextDouble();
        System.out.println("Enter the imaginary part of the constant (without the i, just the value, format : x.x or x) :");
        double i = sc.nextDouble();
        return new Complexe(r, i);
    }

    public String toString(){
        String res = "";
        if (type instanceof Polynom){
            res = type + " + c" + "  with  c = "+c;
        }
        if (type instanceof Trigonometry){
            res = "c * " + type + "  with  c = "+c;
        }
        return "f(z) = "+res;
    }
}
