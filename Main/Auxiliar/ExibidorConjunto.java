package Main.Auxiliar;

import Main.Conjunto;
import Main.Ponto;

public class ExibidorConjunto {
    
    public static void exibir(Conjunto conjunto, Cor cor) {
        exibirConjunto(conjunto, cor);
    }

    public static void exibir(Conjunto conjunto) {
        exibirConjunto(conjunto, Cor.ANSI_RESET);
    }

    private static void exibirConjunto(Conjunto conjunto, Cor cor){

        String detalheConjunto;

        detalheConjunto = conjunto.getNome() + "[ ";
        for (Ponto ponto : conjunto.getPontos()) {
            detalheConjunto += ponto.toString();
        }
        detalheConjunto += "]";

        EscritorDeCores.escrever(detalheConjunto, cor);

    }

}
