import java.util.Set;

public interface ResultadoBuscaProfundidade {

    public Set<Edge> arestasDeArvore(Graph g);

    public Set<Edge> arestasDeRetorno(Graph g);

    public Set<Edge> arestasDeAvanco(Graph g);

    public Set<Edge> arestasDeCruzamento(Graph g);

    public int tempoDeDescoberta(int origem);

    public int tempoDeFinalizacao(int destino);

    public boolean existeCiclo(Graph g);

}
