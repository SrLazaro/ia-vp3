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

    private static void exibirConjunto(Conjunto conjunto, Cor corParametro){

        String detalheConjunto;
        Cor cor;

        cor = corParametro;

        detalheConjunto = conjunto.getNome() + "[ ";
        for (Ponto ponto : conjunto.getPontos()) {
            detalheConjunto += ponto.toString();
        }
        detalheConjunto += "]";

        if(conjunto.getCor() != null){
            cor = conjunto.getCor();
        }

        EscritorDeCores.escrever(detalheConjunto, cor);

    }

}
