package Main;
public class Ponto {

    private String nome;
    private double x;
    private double y;

    public Ponto(String nome, double x, double y) {
        this.nome = nome;
        this.x = x;
        this.y = y;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

}
