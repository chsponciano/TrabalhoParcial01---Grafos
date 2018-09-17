
/**
 *
 * @author Carlos Henrique Ponciano da Silva && Vinicius Luis da Silva
 */
public class Exercicio01 {

    public static void main(String[] args) {
        Exercicio01 t = new Exercicio01();
        int[][] adj = new int[4][4];
        //Não dirigido
        adj[0][0] = 0;
        adj[0][1] = 1;
        adj[0][2] = 1;
        adj[0][3] = 0;

        adj[1][0] = 1;
        adj[1][1] = 0;
        adj[1][2] = 0;
        adj[1][3] = 1;

        adj[2][0] = 1;
        adj[2][1] = 0;
        adj[2][2] = 0;
        adj[2][3] = 1;

        adj[3][0] = 0;
        adj[3][1] = 1;
        adj[3][2] = 1;
        adj[3][3] = 0;
        System.out.println((t.isSimetrico(adj)) ? "Não dirigido" : "Dirigido");

        //Dirigido
        adj[0][0] = 0;
        adj[0][1] = 1;
        adj[0][2] = 0;
        adj[0][3] = 1;

        adj[1][0] = 0;
        adj[1][1] = 0;
        adj[1][2] = 0;
        adj[1][3] = 0;

        adj[2][0] = 0;
        adj[2][1] = 1;
        adj[2][2] = 0;
        adj[2][3] = 0;

        adj[3][0] = 0;
        adj[3][1] = 0;
        adj[3][2] = 1;
        adj[3][3] = 0;
        System.out.println((t.isSimetrico(adj)) ? "Não dirigido" : "Dirigido");
    }

    //Todo grafo simetrico é não-dirigido
    private boolean isSimetrico(final int[][] adj) {
        for (int v = 0; v < adj.length; v++) {
            for (int w = 0; w < adj[v].length; w++) {
                if (adj[v][w] != adj[w][v]) {
                    return false;
                }
            }
        }
        return true;
    }

    public String tipoDoGrafo(final int[][] adj) {
        return null;
    }

    public String arestasDoGrafo(final int[][] adj) {
        return null;
    }

    public String grausDoVertices(final int[][] adj) {
        return null;
    }
}
