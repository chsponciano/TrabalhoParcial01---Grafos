
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Carlos Henrique Ponciano da Silva && Vinicius Luis da Silva
 */
public class Exercicio01 {

    private int[][] graus;

    public static void main(String[] args) {
        Exercicio01 t = new Exercicio01();

        int[][] adj = new int[][]{
            //A,B,C
            {0, 1, 1}, //A
            {1, 0, 1}, //B
            {1, 1, 0}  //C
        };

        System.out.println("1a. " + t.tipoDoGrafo(adj));
        System.out.println("1b. " + t.arestasDoGrafo(adj));
        System.out.println("1c. " + t.grausDoVertices(adj));
        System.out.println("");

        adj = new int[][]{
            //A,B,C
            {0, 1, 0}, //A
            {0, 0, 1}, //B
            {1, 0, 0}  //C
        };

        System.out.println("2a. " + t.tipoDoGrafo(adj));
        System.out.println("2b. " + t.arestasDoGrafo(adj));
        System.out.println("2c. " + t.grausDoVertices(adj));
        System.out.println("");

        adj = new int[][]{
            //A,B,C,D
            {0, 1, 1, 1}, //A
            {1, 0, 0, 0}, //B
            {1, 0, 0, 0}, //C
            {1, 0, 0, 0}  //D
        };

        System.out.println("3a. " + t.tipoDoGrafo(adj));
        System.out.println("3b. " + t.arestasDoGrafo(adj));
        System.out.println("3c. " + t.grausDoVertices(adj));
        System.out.println("");

        adj = new int[][]{
            //A,B,C,D
            {0, 1, 1, 1}, //A
            {1, 0, 1, 1}, //B
            {1, 1, 0, 1}, //C
            {1, 1, 1, 0}  //D
        };

        System.out.println("4a. " + t.tipoDoGrafo(adj));
        System.out.println("4b. " + t.arestasDoGrafo(adj));
        System.out.println("4c. " + t.grausDoVertices(adj));
        System.out.println("");

        adj = new int[][]{
            //A,B,C,D,E
            {0, 0, 0, 1, 0}, //A
            {0, 0, 0, 1, 0}, //B
            {0, 0, 0, 0, 1}, //C
            {1, 1, 0, 0, 0}, //D
            {0, 1, 1, 0, 0}  //E
        };

        System.out.println("5a. " + t.tipoDoGrafo(adj));
        System.out.println("5b. " + t.arestasDoGrafo(adj));
        System.out.println("5c. " + t.grausDoVertices(adj));
        System.out.println("");

        adj = new int[][]{
            //A,B,C,D,E
            {0, 0, 0, 1, 1}, //A
            {0, 0, 0, 1, 1}, //B
            {0, 0, 0, 1, 1}, //C
            {1, 1, 1, 0, 0}, //D
            {1, 1, 1, 0, 0}  //E
        };

        System.out.println("6a. " + t.tipoDoGrafo(adj));
        System.out.println("6b. " + t.arestasDoGrafo(adj));
        System.out.println("6c. " + t.grausDoVertices(adj));
        System.out.println("");

        adj = new int[][]{
            //A,B,C,D,E
            {0, 0, 0, 0, 1}, //A
            {0, 0, 0, 0, 1}, //B
            {0, 0, 0, 0, 1}, //C
            {0, 0, 0, 0, 1}, //D
            {1, 1, 1, 1, 0}  //E
        };

        System.out.println("7a. " + t.tipoDoGrafo(adj));
        System.out.println("7b. " + t.arestasDoGrafo(adj));
        System.out.println("7c. " + t.grausDoVertices(adj));
        System.out.println("");

        adj = new int[][]{
            //A,B,C,D,E
            {0, 1, 1, 0, 0}, //A
            {1, 0, 0, 1, 0}, //B
            {1, 0, 0, 0, 1}, //C
            {0, 1, 0, 0, 1}, //D
            {0, 0, 1, 1, 0}  //E
        };

        System.out.println("8a. " + t.tipoDoGrafo(adj));
        System.out.println("8b. " + t.arestasDoGrafo(adj));
        System.out.println("8c. " + t.grausDoVertices(adj));
        System.out.println("");

    }

    public String tipoDoGrafo(final int[][] adj) {
        boolean[] resultado = this.statusGrafos(adj);

        String str = "Tipo do grafo: ";
        str = (resultado[0]) ? "Não-Dirigido, " : "Dirigido, ";
        str += (resultado[1]) ? "Multigrafo, " : "Simples, ";
        str += (resultado[2]) ? "Regular, " : "";
        str += (resultado[3]) ? "Completo, " : "";
        str += (resultado[4]) ? "Nulo, " : "";
        str += (resultado[5]) ? "Bipartido, " : "";

        return str.substring(0, str.length() - 2);
    }

    private boolean[] statusGrafos(int[][] adj) {
        //0 - dirigido(false) ou não-dirigido(true);        
        //1 - simples(false) ou multigrafo(true);        
        //2 - regular;
        //3 - completo;        
        //4 - nulo ou bipartido;

        boolean[] resultado = {true, false, true, true, true, false};
        this.graus = new int[2][adj.length];

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
                this.graus[0][v] += adj[v][w]; //Saida
                this.graus[1][w] += adj[v][w]; //Entrada

                //Completo
                if (v != w) {
                    resultado[3] = (resultado[3] && adj[v][w] > 0);
                }

                //Nulo 
                resultado[4] = (resultado[4] && adj[v][w] == 0);
            }
        }

        resultado[2] = isRegular(resultado[0]);
        resultado[5] = isBipartido(adj);

        return resultado;
    }

    public String arestasDoGrafo(final int[][] adj) {
        String saida = new String();
        String totalizador = new String();
        boolean isSimetrico = this.statusGrafos(adj)[0];
        int nArestas = 0;

        saida += " E = {";
        for (int v = 0; v < adj.length; v++) {
            for (int w = 0; w < adj[v].length; w++) {
                if (adj[v][w] > 0) {
//                    if (!isSimetrico || w > v) {
                    saida += "(v" + (v + 1) + ", v" + (w + 1) + "), ";
                    nArestas++;
//                    }
                }
            }
        }
        if (isSimetrico) {
            totalizador = "N° arestas: " + (nArestas / 2) + " | ";
        } else {
            totalizador = "N° arestas de Entrada : " + nArestas + " | N° arestas de Saida : " + nArestas + " | ";
        }

        return totalizador + saida.substring(0, saida.length() - 2) + "}";
    }

    public String grausDoVertices(final int[][] adj) {
        String saida = new String();
        List<Integer> graus = new ArrayList();

        if (this.statusGrafos(adj)[0]) {

            for (int i = 0; i < this.graus[0].length; i++) {
                graus.add(this.graus[0][i]);
                saida += "v" + (i + 1) + " = " + this.graus[0][i] + ", ";
            }

        } else {

            saida = "Saida: ";
            for (int i = 0; i < this.graus[0].length; i++) {
                graus.add(this.graus[0][i]);
                saida += "v" + (i + 1) + " = " + this.graus[0][i] + ", ";
            }

            saida = saida.substring(0, saida.length() - 2) + " | Entrada: ";

            for (int i = 0; i < this.graus[1].length; i++) {
                saida += "v" + (i + 1) + " = " + this.graus[1][i] + ", ";
            }

        }

        Collections.sort(graus);

        saida = saida.substring(0, saida.length() - 2) + " | (";
        for (Integer g : graus) {
            saida += g + ", ";
        }

        return saida.substring(0, saida.length() - 2) + ")";
    }

    private boolean isBipartido(int[][] adj) {
        Set<Integer> controle1 = new HashSet<>();
        Set<Integer> controle2 = new HashSet<>();
        Set<Integer> adjacencias;
        boolean continua = true;
        for (int linha = 0; linha < adj.length; linha++) {
            adjacencias = getAdjacencias(adj, linha);
            if (controle1.contains(linha)) {
                continua = true;
            } else {
                continua = false;
            }
            if (continua) {
                if (collectionContainsAny(controle1, adjacencias)) {
                    return false;
                } else {
                    controle1.add(linha);
                    controle2.addAll(adjacencias);
                }
            } else {
                if (collectionContainsAny(controle2, adjacencias)) {
                    return false;
                } else {
                    controle2.add(linha);
                    controle1.addAll(adjacencias);
                }
            }

        }
        return true;
    }

    private Set<Integer> getAdjacencias(int[][] adj, int linha) {
        Set<Integer> adjacencias = new HashSet();
        for (int i = 0; i < adj.length; i++) {
            if (adj[linha][i] > 0) {
                adjacencias.add(i);
            }
        }
        return adjacencias;
    }

    private boolean collectionContainsAny(Set<Integer> collection, Set<Integer> adjacencias) {
        for (Integer adj : adjacencias) {
            if (collection.contains(adj)) {
                return true;
            }
        }
        return false;
    }

    private boolean isRegular(boolean isSemetrico) {
        if (isSemetrico) {
            for (int v = 1; v <= this.graus.length; v++) {
                if (this.graus[0][v - 1] != this.graus[0][v]) {
                    return false;
                }
            }
        } else {
            for (int v = 0; v < this.graus.length; v++) {
                for (int j = 1; j < this.graus[v].length; j++) {
                    if (this.graus[v][j - 1] != this.graus[v][j]) {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}
