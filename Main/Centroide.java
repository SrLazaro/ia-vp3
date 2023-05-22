package Main;

public class Centroide extends Ponto{

    public Centroide(String nomeCentroide, String nome, double x, double y) {
        super(nome, x, y);
    }

    public Centroide(String nomeCentroide, Ponto ponto){

        super(nomeCentroide, ponto.getX(), ponto.getY());
        this.nome = nomeCentroide + " - " + ponto.getNome();
        
    }

    
}
