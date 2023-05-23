package Main;

public class DistanciaPonto {
    
    Ponto ponto;
    double distancia;

    public DistanciaPonto(Ponto ponto, double distancia) {
        this.ponto = ponto;
        this.distancia = distancia;
    }

    public Ponto getPonto() {
        return ponto;
    }

    public void setPonto(Ponto ponto) {
        this.ponto = ponto;
    }
    public double getDistancia() {
        return distancia;
    }
    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }
    
}
