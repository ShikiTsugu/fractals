package src.run;

import src.builders.buildFractals;
import src.sets.Julia;
import src.sets.Mandelbrot;
import src.sets.fractalSet;

import java.util.Scanner;

public class Main {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        System.out.println("What set do you want to use Julia (J) ? or Mandelbrot (M) ?");
        String rep = sc.nextLine();
        fractalSet set = null;
        if (rep.equals("J")) {
            set = new Julia();
        }else if (rep.equals("M")) {
            set = new Mandelbrot();
        }else {
            System.out.println("J or M expected");
            System.exit(-1);
        }
        System.out.println(set);
        buildFractals f = new buildFractals(set);
        f.buildPicture();
    }
}
