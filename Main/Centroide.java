package Main;

import java.util.ArrayList;

import javax.swing.text.StyledEditorKit.BoldAction;

public class Centroide extends Ponto{

    private String nomeCentroide;
    Conjunto conjunto;
    private ArrayList<DistanciaPonto> distancias = new ArrayList<DistanciaPonto>();

    public Centroide(String nomeCentroide, String nome, double x, double y) {
        super(nome, x, y);
    }

    public Centroide(String nomeCentroide, Ponto ponto){

        super(nomeCentroide, ponto.getX(), ponto.getY());
        this.nome = nomeCentroide + " - " + ponto.getNome();
        this.nomeCentroide = nomeCentroide;
        this.conjunto = new Conjunto("Conjunto - " + nomeCentroide);
        
    }

    public Centroide(String nomeCentroide, Ponto ponto, Conjunto conjunto){

        super(nomeCentroide, ponto.getX(), ponto.getY());
        this.nome = nomeCentroide + " - " + ponto.getNome();
        this.nomeCentroide = nomeCentroide;
        this.conjunto = conjunto;
        this.conjunto.setNome("Conjunto - " + nomeCentroide);
        
    }

    public double getDistancia(Ponto ponto){
        double distancia = 0;

        for (DistanciaPonto distanciaPonto : distancias) {
            if(distanciaPonto.getPonto().getNome().equals(ponto.getNome())
            &  distanciaPonto.getPonto().getX() == ponto.getX()
            &  distanciaPonto.getPonto().getY() == ponto.getY()
            ){
                distancia = distanciaPonto.getDistancia();
            }
        }

        return distancia;
    }

    public Conjunto getConjunto() {
        return conjunto;
    }

    public void setConjunto(Conjunto conjunto) {
        this.conjunto = conjunto;
    }

    public ArrayList<DistanciaPonto> getDistancias() {
        return distancias;
    }

    public void setDistancias(ArrayList<DistanciaPonto> distancias) {
        this.distancias = distancias;
    }

    public String getNomeCentroide() {
        return nomeCentroide;
    }

    public void setNomeCentroide(String nomeCentroide) {
        this.nomeCentroide = nomeCentroide;
    }

}
