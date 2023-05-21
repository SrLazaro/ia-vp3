package Auxiliar;
public enum Cor {
    
    ANSI_RESET("\u001B[0m"),
    ANSI_VERMELHO("\u001B[31m"),
    ANSI_VERDE("\u001B[32m"),
    ANSI_AMARELO("\u001B[33m"),
    ANSI_AZUL("\u001B[34m"),
    ANSI_ROXA("\u001B[35m"),
    ANSI_CIANO("\u001B[36m"),
    ANSI_BRANCO("\u001B[37m");

    private String valor;

    Cor(String valor) {
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }


}
