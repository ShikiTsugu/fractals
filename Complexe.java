public class Complexe {
    private final double reel,imaginaire;

    public Complexe(double pr, double pi){
        reel = pr;
        imaginaire = pi;
    }

    public double getReel() {
        return reel;
    }

    public double getImaginaire() {
        return imaginaire;
    }

    public Complexe somme(Complexe c){
        double resR = this.reel+c.reel;
        double resI = this.imaginaire+c.imaginaire;
        return new Complexe(resR,resI);
    }

    public Complexe soustraction(Complexe c){
        double resR = this.reel-c.reel;
        double resI = this.imaginaire-c.imaginaire;
        return new Complexe(resR,resI);
    }

    public Complexe multiplication(Complexe c){
        double resR1 = this.reel*c.reel;
        double resI1 = this.reel*c.imaginaire;
        double resR2 = this.imaginaire*c.imaginaire;
        double resI2 = this.imaginaire*c.reel;
        double resRF = resR1+resR2;
        double resIF = resI1+resI2;
        return new Complexe(resRF,resIF);
    }

    public Complexe division(Complexe c){
        Complexe inverse = new Complexe(c.reel,-c.imaginaire);
        Complexe num = this.multiplication(inverse);
        Complexe denom = c.multiplication(inverse);
        double resR = num.reel/denom.reel;
        double resI = num.imaginaire/denom.reel;
        return new Complexe(resR,resI);
    }

    public boolean equals(Complexe c){
        return reel==c.reel && imaginaire==c.imaginaire;
    }

    public double partieReel(){
        return reel;
    }

    public double partieImaginaire(){
        return imaginaire;
    }

    public Complexe conjugue(){
        double newIm = -imaginaire;
        return new Complexe(reel,newIm);
    }

    public double module(){
        return Math.sqrt((reel*reel)+(imaginaire*imaginaire));
    }

    public String toString(){
        return reel+" + i*"+imaginaire;
    }
}
