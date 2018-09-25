import java.util.ArrayList;
import java.util.List;

/**
 * @author Carlos Henrique Ponciano da Silva && Vinicius Luis da Silva
 */
public class Vertice {
    private String identificacao;
    private String cor;
    private List<Vertice> adj;

    public Vertice(String identificacao) {
        this.identificacao = identificacao;
        this.cor = "BRANCO";
        this.adj = new ArrayList<>();
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
    
    public void addAdj(Vertice v){
        this.adj.add(v);
    }
    
    public List<Vertice> adjacentes(){
        return this.adj;
    }

    public String getCor() {
        return cor;
    }

    public String getIdentificacao() {
        return identificacao;
    }
}
