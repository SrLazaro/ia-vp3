import java.util.Scanner;

public class CriadorConjunto {

    boolean criarConjunto;
    Scanner leitorDados = new Scanner(System.in);

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
                    System.out.println("Por favor, digite um valor válido.");
                }
            } catch (Exception e) {
                System.out.println("Por favor, digite um valor válido.");
                leitorDados.next();
            }

        }

    }
    
}
