package Main;
import java.util.Scanner;

import Main.Auxiliar.Cor;
import Main.Auxiliar.EscritorDeCores;
import Main.Auxiliar.ExibidorConjunto;
import Main.Erros.OpcaoInvalidaException;

public class CriadorConjunto {

    private int opcaoDesejada = 0;
    private Scanner leitorDados = new Scanner(System.in);
    private Conjunto conjunto = new Conjunto("Inicial");

    public void iniciar(){

        selecionarOpcaoConjunto();

        switch (opcaoDesejada) {
            case 1: 
                criarConjunto();
                break;

            case 2:
                criarConjuntoExemplo();
                break;
        }


    }

    private void criarConjuntoExemplo() {

        conjunto.getPontos().add(new Ponto("D1", 1, 1));
        conjunto.getPontos().add(new Ponto("D2", 9.4, 6.4));
        conjunto.getPontos().add(new Ponto("D3", 2.5, 2.1));
        conjunto.getPontos().add(new Ponto("D4", 8, 7.7));
        conjunto.getPontos().add(new Ponto("D5", 0.5, 2.2));
        conjunto.getPontos().add(new Ponto("D6", 7.9, 8.4));
        conjunto.getPontos().add(new Ponto("D7", 7, 7));
        conjunto.getPontos().add(new Ponto("D8", 2.8, 0.8));
        conjunto.getPontos().add(new Ponto("D9", 1.2, 3));
        conjunto.getPontos().add(new Ponto("D10", 7.8, 6.1));

        ExibidorConjunto.exibir(conjunto, Cor.ANSI_AZUL);

    }

    private void criarConjunto() {

        boolean continuar = true;
        double x, y = 0;
        int contador = 1;
        String nomePonto;
        int resposta = 0;

        while(continuar){
            try {
                System.out.print("Digite um valor para X: ");
                x = leitorDados.nextDouble();
                System.out.print("Digite um valor para Y: ");
                y = leitorDados.nextDouble();
                
                nomePonto = "D" + contador;
                conjunto.getPontos().add(new Ponto(nomePonto, x, y));

                contador++;

                ExibidorConjunto.exibir(conjunto, Cor.ANSI_AZUL);

                System.out.println("Deseja continuar?");
                System.out.print("Não[0] | Sim[qualquer caractere]: ");
                try {
                    resposta = leitorDados.nextInt();
                    if(resposta == 0){
                        continuar = false;
                    }
                } catch (Exception e) {
                    leitorDados.next();
                }
                
            }catch (Exception e) {
                EscritorDeCores.escrever(OpcaoInvalidaException.erro, Cor.ANSI_VERMELHO);
                leitorDados.next();
            }
        }

    }

    private void selecionarOpcaoConjunto() {

        boolean continuar = true;

        System.out.println("1 - Criar Conjunto");
        System.out.println("2 - Utilizar Conjunto Exemplo");

        while(continuar){

            try {
                System.out.print("Digite a opção desejada: ");
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

    }

    public int getOpcaoDesejada() {
        return opcaoDesejada;
    }

    public void setOpcaoDesejada(int opcaoDesejada) {
        this.opcaoDesejada = opcaoDesejada;
    }

    public Scanner getLeitorDados() {
        return leitorDados;
    }

    public void setLeitorDados(Scanner leitorDados) {
        this.leitorDados = leitorDados;
    }

    public Conjunto getConjunto() {
        return conjunto;
    }

    public void setConjunto(Conjunto conjunto) {
        this.conjunto = conjunto;
    }
    
}
