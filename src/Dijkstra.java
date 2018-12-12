import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class Dijkstra {
    String current;
    ArrayList<String> notVisited = new ArrayList<String>();
    ArrayList<Integer> distance;

    public ArrayList<Integer> fillPathDijkstra(Graph graph, ArrayList<String> neighbors, int distanceIndex){
        ArrayList<Integer> path = new ArrayList<Integer>();
        path = this.distance;
        if (distanceIndex == 0){
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
        }else{

        }
        return path;
    }

    public ArrayList<String> findSmallerPathDijkstra(Graph graph, String startVertex, String endVertex) {

        distance = new ArrayList<Integer>(graph.getVertexes().size());
        this.notVisited = graph.getVertexes();
        current = startVertex;
        int distanceIndex = 0;
        for (int i = 0; i < graph.getVertexes().size(); i++) {
            int vertexIndex;
            if (graph.getVertexes().get(i).equals(startVertex)) {
                vertexIndex = graph.getVertexes().indexOf(startVertex);
                distance.set(vertexIndex, 0);
            } else {
                vertexIndex = graph.getVertexes().indexOf(graph.getVertexes().get(i));
                distance.set(vertexIndex, 9999);
            }
        }

        while (!this.notVisited.isEmpty()) {
            fillPathDijkstra(graph, graph.getNeighbors(current), distanceIndex);

            distanceIndex++;
            this.notVisited.remove(current);
            //current = neighbor.get(0);
        }

        return smallerPath;
    }
}