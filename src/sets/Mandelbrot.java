package src.sets;

import src.builders.Complexe;
import src.functions.Function;
import src.functions.Polynom;
import src.functions.Trigonometry;

import java.util.Locale;
import java.util.Scanner;

public class Mandelbrot extends fractalSet{
    private final Function type;
    private Complexe c;

    public Mandelbrot(){
        super();
        type = requestType();
    }

    @Override
    public Function getType() {
        return type;
    }

    public Complexe getC() {
        return c;
    }

    public void setC(Complexe c) {
        this.c = c;
    }

    public String toString(){
        String res = "";
        if (type instanceof Polynom){
            res = type + " + c" + "  with  z0 = 0";
        }
        if (type instanceof Trigonometry){
            res = "c * " + type + "  with  z0 = 0";
        }
        return "f(z) = "+res;
    }
}
