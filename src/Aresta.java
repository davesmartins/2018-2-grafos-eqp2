public class Aresta {
    private String nome;
    private Vertice vertice1;
    private Vertice vertice2;


    public void Aresta(Vertice vertice1, Vertice vertice2, String nome){
        this.setNome(nome);
        this.setVertice1(vertice1);
        this.setVertice2(vertice2);
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setVertice1(Vertice vertice1) {
        this.vertice1 = vertice1;
    }

    public void setVertice2(Vertice vertice2) {
        this.vertice2 = vertice2;
    }

    public Vertice getVertice2() {
        return vertice2;
    }

    public Vertice getVertice1() {
        return vertice1;
    }
}
