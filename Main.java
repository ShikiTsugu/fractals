public class Main {
    public static void main(String[]args){
        Julia j = new Julia();
        System.out.println(j);
        int div = j.divergenceIndex(j.getZ0());
        System.out.println(div);
    }
}
