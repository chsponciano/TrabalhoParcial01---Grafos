
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Carlos
 */
public class Vertice {
    private String identificacao;
    private String cor;
    private Vertice pai;
    private int distancia;
    private List<Vertice> parentes;

    public Vertice(String identificacao) {
        this.identificacao = identificacao;
        this.cor = "BRANCO";
        this.pai = null;
        this.distancia = 0;
        this.parentes = new ArrayList<>();
    }
    
    public void setCor(){
        switch(cor){
            case "BRANCO":
                this.cor = "CINZA";
                break;
            case "CINZA":
                this.cor = "PRETO";
                break;
            default:
                break;
        }
    }
    
    public void setPai(Vertice pai){
        this.pai = pai;
    }
    
    public void addParentes(Vertice v){
        this.parentes.add(v);
    }
    
    public List<Vertice> parentes(){
        return this.parentes;
    }

    public String getCor() {
        return cor;
    }

    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }

    
    public int getDistancia() {
        return distancia;
    }

    public String getIdentificacao() {
        return identificacao;
    }

    @Override
    public String toString() {
        return getIdentificacao();
    }
    
    
}
