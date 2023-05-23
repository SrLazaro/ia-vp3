package Main.Auxiliar;

public class Calculadora {
    public static double potencia(double base, double potencia) {
        return Math.pow(base, potencia);
    }
    public static double subtrair(double valor1, double valor2) {
        return valor1 - valor2;
    }
    public static double dividir(double dividendo, double divisor) {
        return dividendo / divisor;
    }
    public static double raiz(double valor) {
        return Math.sqrt(valor);
    }
}
