public class Aresta {
    private String nome;
    private Vertice verticesaida;
    private Vertice verticechegada;


    public void Aresta(Vertice vertice1, Vertice vertice2, String nome){
        this.setNome(nome);
        this.setVerticeSaida(vertice1);
        this.setVerticeChegada(vertice2);
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Vertice getVerticeChegada() {
        return verticechegada;
    }

    public void setVerticeChegada(Vertice vertice2) {
        this.verticechegada = vertice2;
    }

    public void setVerticeSaida(Vertice vertice1) {
        this.verticesaida = vertice1;
    }

    public Vertice getVerticeSaida() {
        return verticesaida;
    }
}
