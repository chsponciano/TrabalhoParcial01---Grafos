
import java.util.Map;

/**
 *
 * @author Carlos Henrique Ponciano da Silva && Vinicius Luis da Silva
 */
public class Grafo {

    private Map<String, Vertice> vertices;

    public void setVertices(Map<String, Vertice> vertices) {
        this.vertices = vertices;
    }

    public Map<String, Vertice> getVertices() {
        return vertices;
    }

    public boolean existeCiclo(){
        for (Map.Entry<String, Vertice> u : vertices.entrySet()) {
            if(u.getValue().getCor().equals("BRANCO")){
                return dfsVisit(u.getValue());
            }
        }
        
        return false;
    }

    private boolean dfsVisit(Vertice u) {
        u.setCor();
        for (Vertice v : u.adjacentes()) {
            if(v.getCor().equals("CINZA")){
                return true;
            }
        }
        
        for (Vertice v : u.adjacentes()) {
            if(v.getCor().equals("BRANCO")){
                return dfsVisit(v);
            }
        }
        u.setCor();
        return false;
    }
}
