import edu.ifet.grafos.graphview.GraphView;
import java.io.File;

public class ExportGraph {
    Graph graph;

    public ExportGraph(Graph graph){
        this.graph = graph;
    }

    public String toDotLanguage(){
        String graphDot;
        String aux;

        if (graph.isOriented()){
            graphDot = "Digraph ";
        }else {
            graphDot = "Graph ";
        }
        graphDot += graph.getName() + "{\n";

        for (String vertex : graph.getVertexes()) {
            graphDot += vertex + ";\n";
        }

        for (String edge : graph.getEdges()){
            int edgeIndex = graph.getEdges().indexOf(edge);
            if (graph.isValued()){
                aux = " [label = \"" + graph.getEdgesCost().get(edgeIndex) + "\", name = \"" + edge + "\" ];";
            }else{
                aux = " [name = \"" + edge + "\" ];";
            }

            if (graph.isOriented()){
                graphDot += " " + aresta.getInicio().getId() + " -> " + aresta.getFim().getId() + aux;
            }else {
                graphDot += " " + aresta.getInicio().getId() + " -- " + aresta.getFim().getId() + aux;
            }
        }

        return graphDot;
    }
}
