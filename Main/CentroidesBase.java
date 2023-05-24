package Main;

public class CentroidesBase {
    
    Centroide centroide1;
    Centroide centroide2;

    public CentroidesBase() {
    }

    public CentroidesBase(Centroide centroide1, Centroide centroide2) {
        this.centroide1 = centroide1;
        this.centroide2 = centroide2;
    }

    public Centroide getCentroide1() {
        return centroide1;
    }

    public void setCentroide1(Centroide centroide1) {
        this.centroide1 = centroide1;
    }
    public Centroide getCentroide2() {
        return centroide2;
    }
    public void setCentroide2(Centroide centroide2) {
        this.centroide2 = centroide2;
    }

}
