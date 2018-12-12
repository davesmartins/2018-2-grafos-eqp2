import java.util.ArrayList;

public class Dijkstra {
    String current;
    ArrayList<String> notVisited = new ArrayList<String>();
    ArrayList<Integer> distance;

    public ArrayList<Integer> fillPathDijkstra(Graph graph, ArrayList<String> neighbors, Integer value){
        ArrayList<Integer> path = new ArrayList<Integer>();
        path = this.distance;
        for (String neighbor : neighbors){
            for (Edge edge : graph.getEdges()){
                if (edge.getStartVertex().equals(this.current) && edge.getEndVertex().equals(neighbor)){
                    Integer cost = edge.getCost() + value;
                    int neighborIndex = graph.getVertexes().indexOf(neighbor);
                    if (cost < path.get(neighborIndex)){
                        path.set(neighborIndex, cost);
                    }
                }
            }
        }
        return path;
    }

    public ArrayList<Integer> findSmallerPathDijkstra(Graph graph, String startVertex) {

        this.distance = new ArrayList<Integer>();
        for (int i = 0; i < graph.getVertexes().size(); i++){
            distance.add(0);
        }
        this.notVisited = graph.getVertexes();
        this.current = startVertex;
        Integer value = 0;
        for (int i = 0; i < graph.getVertexes().size(); i++) {
            int vertexIndex;
            if (graph.getVertexes().get(i).equals(startVertex)) {
                vertexIndex = graph.getVertexes().indexOf(startVertex);
                this.distance.set(vertexIndex, 0);
            } else {
                vertexIndex = graph.getVertexes().indexOf(graph.getVertexes().get(i));
                this.distance.set(vertexIndex, 9999);
            }
        }

        while (!this.notVisited.isEmpty()) {
            fillPathDijkstra(graph, graph.getNeighbors(current), value);
            Integer aux = 9999;
            for (Integer cost : this.distance){
                String vertex = graph.getVertexes().get(this.distance.indexOf(cost));
                if (cost != 0 && cost < aux && this.notVisited.contains(vertex)){
                    aux = cost;
                }
            }

            value = aux;
            this.notVisited.remove(this.current);
            this.current = graph.getVertexes().get(this.distance.indexOf(value));
        }

        return this.distance;
    }
}