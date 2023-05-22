package Main;

import java.util.ArrayList;

public class Centroide extends Ponto{

    private ArrayList<DistanciaPonto> distancias = new ArrayList<DistanciaPonto>();

    public Centroide(String nome, double x, double y) {
        super(nome, x, y);
    }

    public Centroide(Ponto ponto){
        super(ponto.getNome(), ponto.getX(), ponto.getY());
    }

    public ArrayList<DistanciaPonto> getDistancias() {
        return distancias;
    }

    public void setDistancias(ArrayList<DistanciaPonto> distancias) {
        this.distancias = distancias;
    }
    
}
