package Main;

import java.util.ArrayList;
import java.util.Random;

import Main.Auxiliar.EscritorDeCores;
import Main.Auxiliar.ExibidorConjunto;
import Main.Auxiliar.Calculadora;
import Main.Auxiliar.Cor;

public class Kmeans {

    private Conjunto conjuntoInicial;
    private ArrayList<Conjunto> conjuntoFinal = new ArrayList<Conjunto>();
    private Centroide centroide1Anterior;
    private Centroide centroide2Anterior;
    private boolean processamentoDetalhado;

    public Kmeans(Conjunto conjuntoInicial, boolean processamentoDetalhado) {
        this.conjuntoInicial = conjuntoInicial;
        this.processamentoDetalhado = processamentoDetalhado;
    }

    public void iniciar() {

        CentroidesBase centroidesAleatorios;

        if(this.processamentoDetalhado){
            exibirTituloDetalhe();
        }

        centroidesAleatorios = escolherCentroidesAleatorios();
        buscarConjunto(centroidesAleatorios.getCentroide1(), centroidesAleatorios.getCentroide2());
        
    }

    private void exibirTituloDetalhe() {
        System.out.println("============================");
        System.out.println("      Resumo Detalhado");
        System.out.println("============================");
    }

    private void buscarConjunto(Centroide centroide1, Centroide centroide2) {
        
        calcularDistanciasCentroides(centroide1, centroide2);
        criarConjuntosCentroides(centroide1, centroide2);
        if(verificarSeHouveMudancasNosConjuntos(centroide1, centroide2)){
            CentroidesBase novosCentroide = criarNovosCentroides(centroide1, centroide2);
            buscarConjunto(novosCentroide.getCentroide1(), novosCentroide.getCentroide2());
        }else{
            conjuntoFinal = atribuirConjuntoFinal(centroide1, centroide2);
        }

    }

    private CentroidesBase criarNovosCentroides(Centroide centroide1, Centroide centroide2) {
        
        CentroidesBase centroidesBase;
        Centroide novoCentroide1, novoCentroide2;

        novoCentroide1 = calcularMediaCentroide(centroide1);
        novoCentroide2 = calcularMediaCentroide(centroide2);

        centroidesBase = new CentroidesBase(novoCentroide1, novoCentroide2);

        atribuirCentroidesAnteriores(centroide1, centroide2);

        return centroidesBase;

    }

    private void atribuirCentroidesAnteriores(Centroide centroide1, Centroide centroide2) {
        
        this.centroide1Anterior = atribuirCentroide(centroide1);
        this.centroide2Anterior = atribuirCentroide(centroide2);
    
    }

    private Centroide atribuirCentroide(Centroide centroideParametro) {

        Centroide centroide;
        Conjunto conjunto;

        conjunto = new Conjunto(centroideParametro.getConjunto().getNome());

        for (Ponto ponto : centroideParametro.getConjunto().getPontos()) {
            conjunto.getPontos().add(new Ponto(ponto.getNome(), 
                                    ponto.getX(), 
                                    ponto.getY()));
        }

        centroide = new Centroide(centroideParametro, conjunto);
        
        return centroide;

    }

    private Centroide calcularMediaCentroide(Centroide centroide) {

        Centroide novoCentroide;

        double quantidadeRegistros = centroide.getConjunto().getPontos().size();
        double valorXSumarizado = 0, valorYSumarizado = 0, mediaX = 0, mediaY = 0;

        for (Ponto ponto : centroide.getConjunto().getPontos()) {
            valorXSumarizado += ponto.getX();
            valorYSumarizado += ponto.getY();
        }

        mediaX = Calculadora.dividir(valorXSumarizado, quantidadeRegistros);
        mediaY = Calculadora.dividir(valorYSumarizado, quantidadeRegistros);

        novoCentroide = new Centroide(centroide.getNomeCentroide(), mediaX, mediaY);

        if(processamentoDetalhado){
            exibirCentroide(novoCentroide);
        }

        return novoCentroide;

    }

    private void exibirCentroide(Centroide centroide) {
        EscritorDeCores.escrever(centroide.toString() , Cor.ANSI_CIANO);
    }

    private ArrayList<Conjunto> atribuirConjuntoFinal(Centroide centroide1, Centroide centroide2) {
        
        ArrayList<Conjunto> conjuntos = new ArrayList<Conjunto>();

        if(centroide1.getConjunto() != null){
            centroide1.getConjunto().setCor(Cor.ANSI_VERMELHO);
            conjuntos.add(centroide1.getConjunto());
        }
        if(centroide2.getConjunto() != null){
            centroide2.getConjunto().setCor(Cor.ANSI_AMARELO);
            conjuntos.add(centroide2.getConjunto());
        }
        
        return conjuntos;
    }

    private boolean verificarSeHouveMudancasNosConjuntos(Centroide centroide1, Centroide centroide2) {
        
        boolean houveMudancas = true;

        if(centroide1Anterior != null){
            if(centroide1Anterior.getConjunto().getPontos() !=
               centroide1.getConjunto().getPontos()){
                    houveMudancas = false;
            }
        }

        if(centroide2Anterior != null){
            if(centroide2Anterior.getConjunto().getPontos() !=
               centroide2.getConjunto().getPontos()){
                    houveMudancas = false;
            }
        }
        
        return houveMudancas;
    }

    private void criarConjuntosCentroides(Centroide centroide1, Centroide centroide2) {
        
        double distancia_centroide_1, distancia_centroide_2 = 0;
        ArrayList<Ponto> pontos = new ArrayList<Ponto>();

        pontos = conjuntoInicial.getPontos();

        for (Ponto ponto : pontos) {

            distancia_centroide_1 = centroide1.getDistancia(ponto);
            distancia_centroide_2 = centroide2.getDistancia(ponto);

            if(distancia_centroide_1 < distancia_centroide_2){
                centroide1.getConjunto().getPontos().add(ponto);
            }else{
                centroide2.getConjunto().getPontos().add(ponto);
            }

        }

        if(processamentoDetalhado){
            ExibidorConjunto.exibir(centroide1.getConjunto(), Cor.ANSI_ROXA);
            ExibidorConjunto.exibir(centroide2.getConjunto(), Cor.ANSI_VERDE);
        } 

    }

    private void calcularDistanciasCentroides(Centroide centroide1, Centroide centroide2) {
        
        double distancia_centroide_1 = 0, distancia_centroide_2 = 0;
        ArrayList<Ponto> pontos = new ArrayList<Ponto>();

        pontos = conjuntoInicial.getPontos();

        for (Ponto ponto : pontos) {

            distancia_centroide_1 = calcularDistancia(centroide1, ponto);
            distancia_centroide_2 = calcularDistancia(centroide2, ponto);

            centroide1.getDistancias().add(new DistanciaPonto(ponto, distancia_centroide_1));
            centroide2.getDistancias().add(new DistanciaPonto(ponto, distancia_centroide_2));

        }

        if(processamentoDetalhado){
            exibirDistancias(centroide1, Cor.ANSI_ROXA);
            exibirDistancias(centroide2, Cor.ANSI_VERDE);
        }
    
    }

    private void exibirDistancias(Centroide centroide, Cor cor) {

        String espacamento = "  ";
        String saida;

        EscritorDeCores.escrever(centroide.getNome(), cor);
        for (DistanciaPonto distancia : centroide.getDistancias()) {
            saida = espacamento + distancia.getPonto().toString()
                    + " | " + distancia.getDistancia();
            EscritorDeCores.escrever(saida, cor);
        }

    }

    private double calcularDistancia(Centroide centroide, Ponto ponto) {

        double resultado, potencia_x, potencia_y, diferenca_x, diferenca_y, raiz = 0;

        diferenca_x = Calculadora.subtrair(centroide.getX(), ponto.getX());
        potencia_x = Calculadora.potencia(diferenca_x, 2);

        diferenca_y = Calculadora.subtrair(centroide.getY(), ponto.getY());
        potencia_y = Calculadora.potencia(diferenca_y, 2);

        raiz = potencia_x + potencia_y;
        resultado = Calculadora.raiz(raiz);

        return resultado;

    }

    private CentroidesBase escolherCentroidesAleatorios() {

        Random geradorNumeroAleatorio = new Random();
        boolean continuar = true;
        int qtdPontos;
        int pontoAleatorio_1 = 0;
        int pontoAleatorio_2 = 0;
        Centroide centroideAleatorio_1;
        Centroide centroideAleatorio_2;
        CentroidesBase centroidesAleatorios;

        qtdPontos = conjuntoInicial.getPontos().size();

        while(continuar){

            pontoAleatorio_1 = geradorNumeroAleatorio.nextInt(qtdPontos);
            pontoAleatorio_2 = geradorNumeroAleatorio.nextInt(qtdPontos);

            if(pontoAleatorio_1 != pontoAleatorio_2
                || qtdPontos == 1){
                continuar = false;
            }
        }

        centroideAleatorio_1 = new Centroide("Centroide 1", 
                                           conjuntoInicial.getPontos().get(pontoAleatorio_1));
                                           //conjuntoInicial.getPontos().get(2));
        centroideAleatorio_2 = new Centroide("Centroide 2", 
                                            conjuntoInicial.getPontos().get(pontoAleatorio_2));
                                            //conjuntoInicial.getPontos().get(7));

        centroidesAleatorios = new CentroidesBase(centroideAleatorio_1, centroideAleatorio_2);

        if(processamentoDetalhado){
            exibirCentroides(centroideAleatorio_1, centroideAleatorio_2);
        }

        return centroidesAleatorios;

    }

    private void exibirCentroides(Ponto cetroide1, Ponto cetroide2) {

        EscritorDeCores.escrever(cetroide1.toString() , Cor.ANSI_CIANO);
        EscritorDeCores.escrever(cetroide2.toString() , Cor.ANSI_CIANO);

    }

    public Conjunto getConjuntoInicial() {
        return conjuntoInicial;
    }

    public void setConjuntoInicial(Conjunto conjuntoInicial) {
        this.conjuntoInicial = conjuntoInicial;
    }

    public ArrayList<Conjunto> getConjuntoFinal() {
        return conjuntoFinal;
    }

    public void setConjuntoFinal(ArrayList<Conjunto> conjuntoFinal) {
        this.conjuntoFinal = conjuntoFinal;
    }

    public Centroide getCentroide1Anterior() {
        return centroide1Anterior;
    }

    public void setCentroide1Anterior(Centroide centroide1Anterior) {
        this.centroide1Anterior = centroide1Anterior;
    }

    public Centroide getCentroide2Anterior() {
        return centroide2Anterior;
    }

    public void setCentroide2Anterior(Centroide centroide2Anterior) {
        this.centroide2Anterior = centroide2Anterior;
    }

    public boolean isProcessamentoDetalhado() {
        return processamentoDetalhado;
    }

    public void setProcessamentoDetalhado(boolean processamentoDetalhado) {
        this.processamentoDetalhado = processamentoDetalhado;
    }

}
