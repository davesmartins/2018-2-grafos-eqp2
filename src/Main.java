import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Vertice vertice1;
        Vertice vertice2;
        Vertice vertice3;
        Aresta aresta1;
        Aresta aresta2;
        Aresta aresta3;
        Grafo grafo1;
        Grafo grafo2;

        vertice1 = new Vertice("v1");
        vertice2 = new Vertice("v2");
        vertice3 = new Vertice("v3");
        aresta1 = new Aresta("a1", vertice1, vertice2);
        aresta2 = new Aresta("a2", vertice2, vertice3);
        aresta3 = new Aresta("a3", vertice3, vertice1);
        grafo1 = new Grafo("1", true);
        grafo2 = new Grafo("2", false);

        grafo1.addVertice(vertice1);
        grafo1.addVertice(vertice2);
        grafo1.addVertice(vertice3);
        grafo1.addAresta(aresta1);
        grafo1.addAresta(aresta2);
        grafo1.addAresta(aresta3);

        grafo2.addVertice(vertice1);
        grafo2.addVertice(vertice2);
        grafo2.addVertice(vertice3);
        grafo2.addAresta(aresta1);
        grafo2.addAresta(aresta2);
        grafo2.addAresta(aresta3);

        grafo1.imprimeGrafo(grafo1.gerarMatrizIncidencia());
        grafo2.imprimeGrafo(grafo2.gerarMatrizIncidencia());
    }
}