import java.util.Scanner;

import Auxiliar.Cor;
import Auxiliar.EscritorDeCores;
import Erros.OpcaoInvalidaException;

public class CriadorConjunto {

    private boolean criarConjunto;
    private Scanner leitorDados = new Scanner(System.in);

    public void iniciar(){

        selecionarOpcaoConjunto();


    }

    private void selecionarOpcaoConjunto() {

        boolean continuar = true;
        int opcaoDesejada = 0;

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
                };
            } catch (Exception e) {
                EscritorDeCores.escrever(OpcaoInvalidaException.erro, Cor.ANSI_VERMELHO);
                leitorDados.next();
            }

        }

    }
    
}
