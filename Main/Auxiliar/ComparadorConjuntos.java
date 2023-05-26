package Main.Auxiliar;

import java.util.ArrayList;

import Main.Conjunto;
import Main.Ponto;

public class ComparadorConjuntos {

    public static boolean compararConjuntos(Conjunto conjunto1, Conjunto conjunto2){

        boolean saoIguais = true;
        boolean encontrou = false;
        ArrayList<Ponto> pontos1 = conjunto1.getPontos();
        ArrayList<Ponto> pontos2 = conjunto2.getPontos();

        if(pontos1.size() == pontos2.size()){
            for (Ponto ponto1 : pontos1) {

                for (Ponto ponto2 : pontos2) {
                    
                    if(ponto1.getNome().equals(ponto2.getNome())){
                        encontrou = true;
                        break;
                    }
                }

                if(encontrou){
                    encontrou = false;
                }else{
                    saoIguais = false;
                    break;
                }
            }
        }else{
            saoIguais = false;
        }

        return saoIguais;

    }
    
}
