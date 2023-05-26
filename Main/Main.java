package Main;

import Main.Auxiliar.EscritorDeCores;
import Main.Auxiliar.ExibidorConjunto;
import Main.Erros.OpcaoInvalidaException;

import java.util.ArrayList;
import java.util.Scanner;

import Main.Auxiliar.Cor;

public class Main{

    public static CriadorConjunto criadorConjunto = new CriadorConjunto();
    public static Scanner leitorDados = new Scanner(System.in);
    public static Conjunto conjunto;
    public static Kmeans kmeans;
    public static boolean processamentoDetalhado = false;

    public static void main(String[] args) {
        
        alimentarConjunto();
        verificarExibicao();
        kmeans = new Kmeans(conjunto, processamentoDetalhado);
        kmeans.iniciar();
        exibirConjuntoResultado(kmeans.getConjuntoFinal());
        
    }
    private static void exibirConjuntoResultado(ArrayList<Conjunto> conjuntoFinal) {
        System.out.println("============================");
        System.out.println("      Conjuntos Finais");
        System.out.println("============================");
        for (Conjunto conjuntoF : conjuntoFinal) {
            ExibidorConjunto.exibir(conjuntoF);
        }
    }

    private static void verificarExibicao() {

        boolean continuar = true;
        int opcaoDesejada = 0;

        while(continuar){

            try {
                EscritorDeCores.escrever("Exibir Detalhado[1] ou Exibir apenas Resultado[2]: ", Cor.ANSI_AMARELO, false);
                opcaoDesejada = leitorDados.nextInt();
                if(opcaoDesejada == 1 || opcaoDesejada == 2){
                    continuar = false;
                }else{
                    EscritorDeCores.escrever(OpcaoInvalidaException.erro, Cor.ANSI_VERMELHO);
                }
            } catch (Exception e) {
                EscritorDeCores.escrever(OpcaoInvalidaException.erro, Cor.ANSI_VERMELHO);
                leitorDados.next();
            }

        }

        if(opcaoDesejada == 1){
            processamentoDetalhado = true;
        }

    }
    private static void alimentarConjunto() {

        criadorConjunto.iniciar();
        conjunto = criadorConjunto.getConjunto();

    }
}