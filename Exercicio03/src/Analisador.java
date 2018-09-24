
import java.util.HashMap;
import java.util.Map;

public abstract class Analisador {

    public static String montarGrafos(String dados) {
        String[] listaDados = dados.replace("\n", " ").split(" ");

        Map<String, Vertice> vertices;
        int contador = 1, contadorInt = 2;
        Vertice v1, v2;
        Grafo grafos;

        String str = "";
        for (int i = 0; i < Integer.parseInt(listaDados[0]); i++) {
            grafos = new Grafo();
            vertices = new HashMap<>();
            for (int j = 1; j <= Integer.parseInt(listaDados[contador]); j++, contadorInt++) {

                v1 = vertices.get(listaDados[j + contador]);
                v2 = vertices.get(listaDados[contadorInt + contador]);

                if (v1 == null) {
                    v1 = new Vertice(listaDados[j + contador]);
                    vertices.put(listaDados[j + contador], v1);
                }

                if (v2 == null) {
                    v2 = new Vertice(listaDados[contadorInt + contador]);
                    vertices.put(listaDados[contadorInt + contador], v2);
                }

                v1.addAdj(v2);
            }
            contador += contadorInt;
            contadorInt = 2;
            grafos.setVertices(vertices);
            str += ((grafos.existeCiclo()) ? "SIM" : "NAO") + "\n";
        }

        return str;
    }
}
