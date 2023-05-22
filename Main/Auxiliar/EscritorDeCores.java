package Main.Auxiliar;

public class EscritorDeCores {
    
    public static void escrever(String mensagem, Cor cor){
        System.out.println(cor.getValor() + mensagem + Cor.ANSI_RESET.getValor());
    }

    public static String getErro(String mensagem, Cor cor){
        String erro;
        erro = cor.getValor() + mensagem + Cor.ANSI_RESET.getValor();
        return erro;
    }

}
