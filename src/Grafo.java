import java.util.ArrayList;

public class Grafo {
    private static int grau;
    private static int ordem;
    private ArrayList aresta;
    private ArrayList vertice;
    public void Grafo(){

    }
    public void adicionaAresta(Aresta a){
        aresta.add(a);
    }
    public void adicionaVertice(Vertice v){
        vertice.add(v);
    }

    public static void setGrau(int grau) {
        Grafo.grau = grau;
    }

    public static void setOrdem(int ordem) {
        Grafo.ordem = ordem;
    }

    public static int getGrau() {
        return grau;
    }

    public static int getOrdem() {
        return ordem;
    }
}
