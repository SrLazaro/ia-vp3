package Main;
public class Ponto {

    protected String nome;
    protected double x;
    protected double y;

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

    public String toString() {

        String textoPonto;

        textoPonto = getNome() + "(" + 
               getX() + "," + 
               getY() + ") ";
        
        if(Double.isNaN(getX())
        || Double.isNaN(getY())){
            textoPonto = getNome() + "( " + ")";
        }

        return textoPonto;
    }

}
