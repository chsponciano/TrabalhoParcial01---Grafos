
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Stack;

/**
 *
 * @author Carlos Henrique Ponciano da Silva && Vinicius Luis da Silva
 */
public class Exercicio01 {

    public static void main(String[] args) {
        Exercicio01 t = new Exercicio01();
        
        int[][] adj = new int[][] {
           //A,B,C
            {0,1,1},  //A
            {1,0,1},  //B
            {1,1,0}   //C
        };
        
        System.out.println(t.isBipartido(adj) ? "Bipartido" : "Não Bipartido(Certo)");
        
        adj = new int[][] {
           //A,B,C,D
            {0,1,1,0},  //A
            {1,0,0,1},  //B
            {1,0,0,1},  //C
            {0,1,1,0}   //D
        };
        
        System.out.println(t.isBipartido(adj) ? "Bipartido(Certo)" : "Não Bipartido");
        
        adj = new int[][] {
           //A,B,C,D
            {0,1,1,1},  //A
            {1,0,0,0},  //B
            {1,0,0,0},  //C
            {1,0,0,0}   //D
        };
        
        System.out.println(t.isBipartido(adj) ? "Bipartido(Certo)" : "Não Bipartido");
        
        adj = new int[][] {
           //A,B,C,D
            {0,1,1,1},  //A
            {1,0,1,1},  //B
            {1,1,0,1},  //C
            {1,1,1,0}   //D
        };
        
        System.out.println(t.isBipartido(adj) ? "Bipartido" : "Não Bipartido(Certo)");
        
        adj = new int[][] {
           //A,B,C,D,E
            {0,0,0,1,0},  //A
            {0,0,0,1,0},  //B
            {0,0,0,0,1},  //C
            {1,1,0,0,0},  //D
            {0,1,1,0,0}   //E
        };
        
        System.out.println(t.isBipartido(adj) ? "Bipartido(Certo)" : "Não Bipartido");
        
        adj = new int[][] {
           //A,B,C,D,E
            {0,0,0,1,1},  //A
            {0,0,0,1,1},  //B
            {0,0,0,1,1},  //C
            {1,1,1,0,0},  //D
            {1,1,1,0,0}   //E
        };
        
        System.out.println(t.isBipartido(adj) ? "Bipartido(Certo)" : "Não Bipartido");
        
        adj = new int[][] {
           //A,B,C,D,E
            {0,0,0,0,1},  //A
            {0,0,0,0,1},  //B
            {0,0,0,0,1},  //C
            {0,0,0,0,1},  //D
            {1,1,1,1,0}   //E
        };
        
        System.out.println(t.isBipartido(adj) ? "Bipartido(Certo)" : "Não Bipartido");
        
        adj = new int[][] {
           //A,B,C,D,E
            {0,1,1,0,0},  //A
            {1,0,0,1,0},  //B
            {1,0,0,0,1},  //C
            {0,1,0,0,1},  //D
            {0,0,1,1,0}   //E
        };
        
        System.out.println(t.isBipartido(adj) ? "Bipartido" : "Não Bipartido(Certo)");
        
        
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
            //resultado[5] = isBipartido(adj);
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

    public String arestasDoGrafo(final int[][] adj) {
        String ret = new String();
        boolean isSimetrico = true;
        int[][] graus = new int[2][adj.length];
        for (int v = 0; v < adj.length; v++) {
            for (int w = 0; w < adj[v].length; w++) {
                //Simetria
                if (isSimetrico) {
                    isSimetrico = (adj[v][w] == adj[w][v]);
                }
                //Graus - Regular
                graus[0][v] += adj[v][w]; //Saida
                graus[1][w] += adj[v][w]; //Entrada
            }
        }
        int total = 0;
        if (isSimetrico) {
            for (int v = 1; v <= graus.length; v++) {
                ret += "e" + v + ", ";
                total += graus[0][v];
            }
            total /= 2;
        } else {
            for (int v = 1; v <= graus.length; v++) {
                for (int i = 0; i < graus.length; i++) {
                    ret += "e" + v + ", ";
                    total += adj[v][i]; //Saida
                }
            }
        }
        return total + " -> " + ret;
    }

    public String grausDoVertices(final int[][] adj) {
        String str = "Graus: ";

        return str;
    }
    
    private boolean isBipartido(int[][] adj) {
        HashSet<Integer> bolsonaro = new HashSet<>();
        HashSet<Integer> lula = new HashSet<>();
        HashSet<Integer> adjacencias;
        boolean isBolsonaro = true;
        for (int linha = 0; linha < adj.length; linha++) {
            adjacencias = getAdjacencias(adj, linha);
            if(bolsonaro.contains(linha)) {
                isBolsonaro = true;
            } else {
                isBolsonaro = false;
            }
            if(isBolsonaro) {
                if(collectionContainsAny(bolsonaro, adjacencias)) {
                    return false;
                } else {
                    bolsonaro.add(linha);
                    lula.addAll(adjacencias);
                }
            } else {
                if(collectionContainsAny(lula, adjacencias)) {
                    return false;
                } else {
                    lula.add(linha);
                    bolsonaro.addAll(adjacencias);
                }
            }
            
        }
        return true;
    }
    
    private HashSet<Integer> getAdjacencias(int[][] adj, int linha) {
        HashSet<Integer> adjacencias = new HashSet();
        for (int i = 0; i < adj.length; i++) {
            if(adj[linha][i] > 0) {
                adjacencias.add(i);
            }
        }
        return adjacencias;
    }

    private boolean collectionContainsAny(HashSet<Integer> collection, HashSet<Integer> adjacencias) {
        for(Integer adj: adjacencias) {
            if(collection.contains(adj)) {
                return true;
            }
        }
        return false;
    }

}
