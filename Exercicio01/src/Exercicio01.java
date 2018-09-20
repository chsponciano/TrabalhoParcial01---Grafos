
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
        System.out.println(t.tipoDoGrafo(adj));

        System.out.println("\n-----------------------\n");

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
        boolean[] resultado = {true, false, true, false, false};

        for (int v = 0; v < adj.length; v++) {
            for (int w = 0; w < adj[v].length; w++) {
                if (resultado[0]) {
                    resultado[0] = (adj[v][w] == adj[w][v]);
                }

                if (!resultado[1]) {
                    resultado[1] = (((v == w) && (adj[v][w] != 0)) || (adj[v][w] > 1));
                }
            }
        }

        if (resultado[0]) {
            int[] g = listaDeGrausNaoDirigido(adj);
            for (int i = 1; i < g.length; i++) {
                if (g[i - 1] != g[i]) {
                    resultado[2] = false;
                    break;
                }
            }
        } else {
            int[][] g = listaDeGrausDirigido(adj);
            for (int i = 0; i < g.length; i++) {
                for (int j = 1; j < g[i].length; j++) {
                    if (g[i][j - 1] != g[i][j]) {
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
        str += (resultado[4]) ? "Nulo." : "Bipartido.";

        return str;
    }

    private int[] listaDeGrausNaoDirigido(final int[][] adj) {
        int[] graus = new int[adj.length];

        for (int v = 0; v < adj.length; v++) {
            for (int w = 0; w < adj[v].length; w++) {
                graus[v] += adj[v][w];
            }
        }

        return graus;
    }

    private int[][] listaDeGrausDirigido(final int[][] adj) {
        int[][] graus = new int[2][adj.length];

        for (int v = 0; v < adj.length; v++) {
            for (int w = 0; w < adj[v].length; w++) {
                if (adj[v][w] > 0) {
                    graus[0][v] += adj[v][w]; //Saida
                    graus[1][w] += adj[v][w]; //Entrada
                }
            }
        }

        return graus;
    }

    public String arestasDoGrafo(final int[][] adj) {
        return null;
    }

    public String grausDoVertices(final int[][] adj) {
        String str = "Graus: ";

        return str;
    }
}
