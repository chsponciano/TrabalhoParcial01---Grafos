
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 *
 * @author Carlos
 */
public class Grafo {

    private Map<String, Vertice> vertices;
    private int qtdVertices;
    private int qtdArestas;
    private int total;

    public Grafo() {
        this.vertices = new HashMap<>();
        
    }

    public int buscar() {
        this.total = 0;
        Queue<Vertice> fila = new LinkedBlockingQueue<>();
        fila.add(vertices.get("Entrada"));
        int ateQueijo = this.buscar(fila, vertices.get("*"));
        total = 0;
        fila.clear();
        fila.add(vertices.get("*"));
        int ateSaida = this.buscar(fila, vertices.get("Saida"));
        return ateQueijo + ateSaida;
    }
    
    
    private int buscar(Queue<Vertice> vertices, Vertice destino){
        Queue<Vertice> fila = new LinkedBlockingQueue<>();
        Vertice v;
        while(!vertices.isEmpty()) {
            v = vertices.poll();
            if(destino.getIdentificacao().equals(v.getIdentificacao())) {
                return total;
            } else {
                botaAdjacentesNaFila(v, fila);
            }
        }
        total++;
        return buscar(fila, destino);
    }
    
    private void botaAdjacentesNaFila(Vertice v, Queue<Vertice> q) {
        q.addAll(v.parentes());
    }
    
    public void montarGrafo(String entrada) {
        entrada = entrada.replace("\n", " ");
        String[] info = entrada.split(" ");
        Vertice v1 = null;
        Vertice v2 = null;

        this.qtdVertices = Integer.parseInt(info[0]);
        this.qtdArestas = Integer.parseInt(info[1]);

        for (int i = 2, j = 3; j < info.length; i += 2, j += 2) {
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
