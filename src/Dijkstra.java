import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Dijkstra {
    ArrayList<String> smallerPath = new ArrayList<String>();
    String pathVertex;
    String current;
    String neighbor;
    ArrayList<String> notVisited = new ArrayList<String>();
    ArrayList<ArrayList<Integer>> distance = new ArrayList<ArrayList<Integer>>;

    public ArrayList<String> findSmallerPathDijkstra(Graph graph, String startVertex, String endVertex) {

        smallerPath.add(v1);
        ArrayList<Integer> x = new ArrayList<Integer>(graph.getVertexes().size());

        for (int i = 0; i < graph.getVertexes().size(); i++) {
            int vertexIndex;
            if (graph.getVertexes().get(i).equals(startVertex)) {
                vertexIndex = graph.getVertexes.indexOf(startVertex);
                x.set(vertexIndex, 0);
            } else {
                vertexIndex = graph.getVertexes.indexOf(graph.getVertexes().get(i));
                x.set(vertexIndex, 9999);
                this.naoVisitados.add(grafo.getVertices().get(i));
            }
        }

        distance.add(x);


        while (!this.naoVisitados.isEmpty()) {

            // Toma-se sempre o vertice com menor distancia, que eh o primeiro
            // da
            // lista

            atual = this.naoVisitados.get(0);
            System.out.println("Pegou esse vertice:  " + atual);
            /*
             * Para cada vizinho (cada aresta), calcula-se a sua possivel
             * distancia, somando a distancia do vertice atual com a da aresta
             * correspondente. Se essa distancia for menor que a distancia do
             * vizinho, esta eh atualizada.
             */
            for (int i = 0; i < atual.getArestas().size(); i++) {

                vizinho = atual.getArestas().get(i).getDestino();
                System.out.println("Olhando o vizinho de " + atual + ": "
                        + vizinho);
                if (!vizinho.verificarVisita()) {

                    // Comparando a distância do vizinho com a possível
                    // distância
                    if (vizinho.getDistancia() > (atual.getDistancia() + atual
                            .getArestas().get(i).getPeso())) {

                        vizinho.setDistancia(atual.getDistancia()
                                + atual.getArestas().get(i).getPeso());
                        vizinho.setPai(atual);

                        /*
                         * Se o vizinho eh o vertice procurado, e foi feita uma
                         * mudanca na distancia, a lista com o menor caminho
                         * anterior eh apagada, pois existe um caminho menor
                         * vertices pais, ateh o vertice origem.
                         */
                        if (vizinho == v2) {
                            menorCaminho.clear();
                            verticeCaminho = vizinho;
                            menorCaminho.add(vizinho);
                            while (verticeCaminho.getPai() != null) {

                                menorCaminho.add(verticeCaminho.getPai());
                                verticeCaminho = verticeCaminho.getPai();

                            }
                            // Ordena a lista do menor caminho, para que ele
                            // seja exibido da origem ao destino.
                            Collections.sort(menorCaminho);

                        }
                    }
                }

            }
            // Marca o vertice atual como visitado e o retira da lista de nao
            // visitados
            atual.visitar();
            this.naoVisitados.remove(atual);
            /*
             * Ordena a lista, para que o vertice com menor distancia fique na
             * primeira posicao
             */

            Collections.sort(naoVisitados);
            System.out.println("Nao foram visitados ainda:"+naoVisitados);

        }

        return menorCaminho;
    }

}
