package src;

public class Main {
    public static void main(String[]args){
        Julia j = new Julia();
        System.out.println(j);
        buildFractals f = new buildFractals(j);
        f.buildPicture();
    }
}
