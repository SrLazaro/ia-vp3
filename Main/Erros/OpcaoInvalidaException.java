package Main.Erros;

public class OpcaoInvalidaException extends Exception{

    public static String erro = "Por favor, digite um valor válido.";
    
    public OpcaoInvalidaException(){
        super(erro);
    }

}
