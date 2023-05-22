package Main;

import java.util.Random;

import Main.Auxiliar.EscritorDeCores;
import Main.Auxiliar.Cor;

public class Kmeans {

    private Conjunto conjuntoInicial;
    private boolean processamentoDetalhado;
    private Centroide centroideAleatorio_1;
    private Centroide centroideAleatorio_2;

    public Kmeans(Conjunto conjuntoInicial, boolean processamentoDetalhado) {
        this.conjuntoInicial = conjuntoInicial;
        this.processamentoDetalhado = processamentoDetalhado;
    }

    public void iniciar() {

        escolherCentroidesAleatorios();

        
    }

    private void escolherCentroidesAleatorios() {

        Random geradorNumeroAleatorio = new Random();
        boolean continuar = true;
        int qtdPontos;
        int pontoAleatorio_1 = 0;
        int pontoAleatorio_2 = 0;

        qtdPontos = conjuntoInicial.getPontos().size();

        while(continuar){

            pontoAleatorio_1 = geradorNumeroAleatorio.nextInt(qtdPontos);
            pontoAleatorio_2 = geradorNumeroAleatorio.nextInt(qtdPontos);

            if(pontoAleatorio_1 != pontoAleatorio_2
                || qtdPontos == 1){
                continuar = false;
            }
        }

        centroideAleatorio_1 = new Centroide("Centroide 1", conjuntoInicial.getPontos().get(pontoAleatorio_1));
        centroideAleatorio_2 = new Centroide("Centroide 2", conjuntoInicial.getPontos().get(pontoAleatorio_2));

        if(processamentoDetalhado){
            exibirCentroides(centroideAleatorio_1, centroideAleatorio_2);
        }

    }

    private void exibirCentroides(Ponto cetroide1, Ponto cetroide2) {

        EscritorDeCores.escrever(cetroide1.toString() , Cor.ANSI_CIANO);
        EscritorDeCores.escrever(cetroide2.toString() , Cor.ANSI_CIANO);

    }

}
