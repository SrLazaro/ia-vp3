package Main.Auxiliar;

public class EscritorDeCores {
    
    public static void escrever(String mensagem, Cor cor){
        System.out.println(cor.getValor() + mensagem + Cor.ANSI_RESET.getValor());
    }

    public static void escrever(String mensagem, Cor cor, boolean pularLinha){
        if(pularLinha){
            System.out.println(cor.getValor() + mensagem + Cor.ANSI_RESET.getValor());
        }else{
            System.out.print(cor.getValor() + mensagem + Cor.ANSI_RESET.getValor());
        }
    }

}
