public class Aresta {
    private String id;
    private Vertice verticeOrigem;
    private Vertice verticeDestino;

    public Aresta(String nome, Vertice vertice1, Vertice vertice2) {
        this.id = nome;
        this.verticeOrigem = vertice1;
        this.verticeDestino = vertice2;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Vertice getVerticeOrigem() {
        return verticeOrigem;
    }

    public void setVerticeOrigem(Vertice verticeOrigem) {
        this.verticeOrigem = verticeOrigem;
    }

    public Vertice getVerticeDestino() {
        return verticeDestino;
    }

    public void setVerticeDestino(Vertice verticeDestino) {
        this.verticeDestino = verticeDestino;
    }
}
