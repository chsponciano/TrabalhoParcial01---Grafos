
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 *
 * @author Carlos
 */
public class Grafo {

    private Map<String, Vertice> vertices;
    private int qtdVertices;
    private int qtdArestas;

    public Grafo() {
        this.vertices = new HashMap<>();
        
    }

    public int buscar(){
        return buscar(this.vertices.get("Entrada"));
    }
    
    private int buscar(Vertice inicial){
        return 0;
    }
    
    public void montarGrafo(String entrada) {
        entrada = entrada.replace("\n", " ");
        String[] info = entrada.split(" ");
        Vertice v1 = null;
        Vertice v2 = null;

        this.qtdVertices = Integer.parseInt(info[0]);
        this.qtdArestas = Integer.parseInt(info[1]);

        for (int i = 2, j = 3; j < info.length; i++, j++) {
            v1 = this.vertices.get(info[i]);
            v2 = this.vertices.get(info[j]);

            if (v1 == null) {
                v1 = new Vertice(info[i]);
                this.vertices.put(info[i], v1);
            }

            if (v2 == null) {
                v2 = new Vertice(info[j]);
                this.vertices.put(info[j], v2);
            }
            
            v1.addParentes(v2);
            v2.addParentes(v1);
        }
    }

}
