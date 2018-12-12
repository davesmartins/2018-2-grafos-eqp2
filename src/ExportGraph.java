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

        for (Edge edge: graph.getEdges()){
            if (graph.isValued()){
                aux = " [label = \"" + edge.getCost() + "\", name = \"" + edge.getName() + "\" ];\n";
            }else{
                aux = " [name = \"" + edge.getName() + "\" ];\n";
            }

            if (graph.isOriented()){
                graphDot += " " + edge.getStartVertex() + " -> " + edge.getEndVertex() + aux;
            }else{
                graphDot += " " + edge.getStartVertex() + " -- " + edge.getEndVertex() + aux;
            }
        }

        graphDot += "}";

        return graphDot;
    }

    public void exportationGraph(String graph){
        String filename = this.graph.getName() + ".png";

        GraphView gv = new GraphView();
        gv.readString(graph);
        System.out.println(gv.getDotSource());

        File out = new File(filename);
        gv.writeGraphToFile(out);
    }
}
