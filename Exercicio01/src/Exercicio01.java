
/**
 *
 * @author Carlos Henrique Ponciano da Silva && Vinicius Luis da Silva
 */
public class Exercicio01 {

    public static void main(String[] args) {
        Exercicio01 t = new Exercicio01();
        int[][] adj = new int[3][3];
        //Não dirigido
        adj[0][0] = 0;
        adj[0][1] = 0;
        adj[0][2] = 0;

        adj[1][0] = 1;
        adj[1][1] = 0;
        adj[1][2] = 1;

        adj[2][0] = 1;
        adj[2][1] = 1;
        adj[2][2] = 0;

        System.out.println(t.tipoDoGrafo(adj));

        System.out.println("\n-----------------------\n");

        adj = new int[4][4];
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
        adj[3][1] = 1;
        adj[3][2] = 1;
        adj[3][3] = 0;
        System.out.println(t.tipoDoGrafo(adj));
    }

    public String tipoDoGrafo(final int[][] adj) {
        //0 - dirigido(false) ou não-dirigido(true);        
        //1 - simples(false) ou multigrafo(true);        
        //2 - regular;
        //3 - completo;        
        //4 - nulo ou bipartido;
        boolean[] resultado = {true, false, true, true, true, false};
        int[][] graus = new int[2][adj.length];

        for (int v = 0; v < adj.length; v++) {
            for (int w = 0; w < adj[v].length; w++) {
                //Simetria
                if (resultado[0]) {
                    resultado[0] = (adj[v][w] == adj[w][v]);
                }

                //Simples ou Multigrafo
                if (!resultado[1]) {
                    resultado[1] = (((v == w) && (adj[v][w] != 0)) || (adj[v][w] > 1));
                }

                //Graus - Regular
                graus[0][v] += adj[v][w]; //Saida
                graus[1][w] += adj[v][w]; //Entrada

                //Completo
                if (v != w) {
                    resultado[3] = (resultado[3] && adj[v][w] > 0);
                }

                //Nulo 
                resultado[4] = (resultado[4] && adj[v][w] == 0);
            }
        }

        if (resultado[0]) {
            for (int v = 1; v <= graus.length; v++) {
                if (graus[0][v - 1] != graus[0][v]) {
                    resultado[2] = false;
                    break;
                }
            }
        } else {
            for (int v = 0; v < graus.length; v++) {
                for (int j = 1; j < graus[v].length; j++) {
                    if (graus[v][j - 1] != graus[v][j]) {
                        resultado[2] = false;
                        break;
                    }
                }
            }
        }

        //Saida
        String str = (resultado[0]) ? "Não-Dirigido, " : "Dirigido, ";
        str += (resultado[1]) ? "Multigrafo, " : "Simples, ";
        str += (resultado[2]) ? "Regular, " : "";
        str += (resultado[3]) ? "Completo, " : "";
        str += (resultado[4]) ? "Nulo, " : "";
        str += (resultado[5]) ? "Bipartido, " : "";

        return str;
    }

    int[] cor;

    private int bipartido(int[][] adj) {
        int v;
        this.cor = new int[adj.length];
        for (v = 0; v < adj.length; ++v) {
            this.cor[v] = -1;
        }
        for (v = 0; v < adj.length; ++v) {
            if (this.cor[v] == -1) {
                if (dfsCor(v, 0) == 0) {
                    return 0;
                }
            }
        }
        return 1;
    }

    public String arestasDoGrafo(final int[][] adj) {
        return null;
    }

    public String grausDoVertices(final int[][] adj) {
        String str = "Graus: ";

        return str;
    }
}
