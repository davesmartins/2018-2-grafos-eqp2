public class Aresta {
    private String nome;
    public String verticeOrigem;
    public String verticeDestino;


    public Aresta(String vertice1, String vertice2) {
        this.setNome(nome);
        this.setVerticeOrigem(vertice1);
        this.setVerticeDestino(vertice2);
    }

    public Aresta(){}

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getVerticeOrigem() {
        return verticeOrigem;
    }

    public void setVerticeOrigem(String verticeOrigem) {
        this.verticeOrigem = verticeOrigem;
    }

    public String getVerticeDestino() {
        return verticeDestino;
    }

    public void setVerticeDestino(String verticeDestino) {
        this.verticeDestino = verticeDestino;
    }
}




