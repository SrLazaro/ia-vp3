package Main;
import java.util.ArrayList;

public class Conjunto {
    
    private String nome;
    private ArrayList<Ponto> pontos = new ArrayList<Ponto>();

    public Conjunto(String nome) {
        this.nome = nome;
    }
    
    public Conjunto(String nome, ArrayList<Ponto> pontos) {
        this.nome = nome;
        this.pontos = pontos;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public ArrayList<Ponto> getPontos() {
        return pontos;
    }
    public void setPontos(ArrayList<Ponto> pontos) {
        this.pontos = pontos;
    }

}
