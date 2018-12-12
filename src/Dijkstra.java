import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Dijkstra {
    ArrayList<String> smallerPath = new ArrayList<String>();
    String pathVertex;
    String current;
    ArrayList<String> notVisited = new ArrayList<String>();
    ArrayList<ArrayList<Integer>> distance = new ArrayList<ArrayList<Integer>>();
    public ArrayList<Integer> fillPathDijkstra(Graph graph, ArrayList<String> neighbors, int distanceIndex){
        ArrayList<Integer> path = new ArrayList<Integer>();
        path = this.distance.get(distanceIndex);
        for (String neighbor : neighbors){
            for (Edge edge : graph.getEdges()){
                if (edge.getStartVertex().equals(this.current) && edge.getEndVertex().equals(neighbor)){
                    Integer cost = edge.getCost();
                    int neighborIndex = graph.getVertexes().indexOf(neighbor);
                    if (cost < path.get(neighborIndex)){
                        path.set(neighborIndex, cost);
                    }
                }
            }
        }
        return path;
    }
    public ArrayList<String> findSmallerPathDijkstra(Graph graph, String startVertex, String endVertex) {
        smallerPath.add(startVertex);
        ArrayList<Integer> x = new ArrayList<Integer>(graph.getVertexes().size());
        for (int i = 0; i < graph.getVertexes().size(); i++) {
            int vertexIndex;
            if (graph.getVertexes().get(i).equals(startVertex)) {
                vertexIndex = graph.getVertexes().indexOf(startVertex);
                x.set(vertexIndex, 0);
            } else {
                vertexIndex = graph.getVertexes().indexOf(graph.getVertexes().get(i));
                x.set(vertexIndex, 9999);
                this.notVisited.add(graph.getVertices().get(i));
            }
        }
        distance.add(x);
        current = startVertex;
        int distanceIndex = 0;
        while (!this.notVisited.isEmpty()) {
            fillPathDijkstra(graph, graph.getNeighbors(current), distanceIndex);
            // Falta colocar distanceIndex++ e alterar o current
            System.out.println("Nao foram visitados ainda:"+notVisited);
        }
        return smallerPath;
    }
}