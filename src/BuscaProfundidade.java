import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;


public class BuscaEmProfundidade implements ResultadoBuscaProfundidade {

    /**
     * cores 0 = branco | 1 = cinza | 2 = preto
     *
     */
    private boolean buscaRealizada = false;
    private int[] cor;
    private int[] tempoDescoberta;
    private int[] tempoFinalizacao;
    private int numVertices;
    private Set<Edge> arestasDeArvore;
    private Set<Edge> arestasDeAvanco;
    private Set<Edge> arestasDeCruzamento;
    private Set<Edge> arestasDeRetorno;
    private Graph g;
    private int tempo = 0;

    public void dfs(Graph g) throws Exception {
        this.g = g;
        this.numVertices = g.getEdges();
        this.cor = new int[this.numVertices];
        this.tempoDescoberta = new int[this.numVertices];
        this.tempoFinalizacao = new int[this.numVertices];

        arestasDeArvore = new HashSet<>();
        arestasDeAvanco = new HashSet<>();
        arestasDeCruzamento = new HashSet<>();
        arestasDeRetorno = new HashSet<>();

        for (int i = 0; i < cor.length; i++) {
            cor[i] = 0;
        }
        this.tempo = 0;
        for (int i = 0; i < numVertices; i++) {
            if (cor[i] == 0) {
                visit(i);
            }
        }
        this.buscaRealizada = true;
        escreveBusca();

    }

    private void visit(int u) throws Exception {
        cor[u] = 1;
        tempo++;
        tempoDescoberta[u] = tempo;
        List<Integer> adjacentes = g.listDeAdjacentes(u);
        for (int v : adjacentes) {
            if (cor[v] == 1) {
                arestasDeRetorno.add(new Aresta(u, v));
            }
            if (cor[v] == 2) {
                if (tempoDescoberta[u] < tempoDeDescoberta(v)) {
                    arestasDeAvanco.add(new Aresta(u, v));
                } else {
                    arestasDeCruzamento.add(new Aresta(u, v));
                }
            }
            if (cor[v] == 0) {
                arestasDeArvore.add(new Aresta(u, v));
                visit(v);
            }
        }
        cor[u] = 2;
        tempo++;
        tempoFinalizacao[u] = tempo;
    }

    @Override
    public Set<Aresta> arestasDeArvore(Grafo g) {
        if (!this.buscaRealizada) {
            try {
                dfs(g);
            } catch (Exception ex) {
                Logger.getLogger(BuscaEmProfundidade.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return arestasDeArvore;
    }

    @Override
    public Set<Aresta> arestasDeRetorno(Grafo g) {
        if (!this.buscaRealizada) {
            try {
                dfs(g);
            } catch (Exception ex) {
                Logger.getLogger(BuscaEmProfundidade.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return arestasDeRetorno;
    }

    @Override
    public Set<Aresta> arestasDeAvanco(Grafo g) {
        if (!this.buscaRealizada) {
            try {
                dfs(g);
            } catch (Exception ex) {
                Logger.getLogger(BuscaEmProfundidade.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return arestasDeAvanco;
    }

    @Override
    public Set<Aresta> arestasDeCruzamento(Grafo g) {
        if (!this.buscaRealizada) {
            try {
                dfs(g);
            } catch (Exception ex) {
                Logger.getLogger(BuscaEmProfundidade.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return arestasDeCruzamento;
    }

    @Override
    public Set<Edge> arestasDeArvore(Graph g) {
        return null;
    }

    @Override
    public Set<Edge> arestasDeRetorno(Graph g) {
        return null;
    }

    @Override
    public Set<Edge> arestasDeAvanco(Graph g) {
        return null;
    }

    @Override
    public Set<Edge> arestasDeCruzamento(Graph g) {
        return null;
    }

    @Override
    public int tempoDeDescoberta(int origem) {
        return tempoDescoberta[origem];
    }

    @Override
    public int tempoDeFinalizacao(int destino) {
        return tempoFinalizacao[destino];
    }

    @Override
    public boolean existeCiclo(Graph g) {
        return false;
    }

    @Override
    public boolean existeCiclo(Grafo g) {
        if (arestasDeRetorno.size() > 0) {
            return true;
        }
        return false;
    }

    public void escreveArestas(Set<Aresta> arestas) {
        for (Aresta a : arestas) {
            System.out.println(a.getOrigem() + "\t" + a.getDestino());
        }
    }

    public void escreveBusca() {
        System.out.println("Vértice | Cor | D | F");
        for (int i = 0; i < numVertices; i++) {
            System.out.println(i + "\t   " + cor[i] + "\t" + tempoDescoberta[i] + " / " + tempoFinalizacao[i]);
        }
    }

}