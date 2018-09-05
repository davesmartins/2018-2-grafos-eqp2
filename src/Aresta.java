public class Aresta {
    private String nome;
    private Vertice vertice1;
    private Vertice vertice2;


    public void Aresta(Vertice vertice1, Vertice vertice2, String nome){
        setNome(nome);

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
