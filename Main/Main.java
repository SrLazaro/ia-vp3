package Main;
public class Main{

    public static CriadorConjunto criadorConjunto = new CriadorConjunto();
    public static Conjunto conjunto;
    public static Kmeans kmeans;
    public static void main(String[] args) {
        
        alimentarConjunto();
        kmeans = new Kmeans(conjunto);
        kmeans.iniciar();
        
    }
    private static void alimentarConjunto() {

        criadorConjunto.iniciar();
        conjunto = criadorConjunto.getConjunto();

    }
}