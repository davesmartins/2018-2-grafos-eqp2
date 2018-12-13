import java.util.ArrayList;

import static com.sun.tools.classfile.Instruction.TypeKind.get;

public class Dijkstra {
    String current;
    ArrayList<String> notVisited = new ArrayList<String>();
    ArrayList<Integer> distance;
    ArrayList<String> vertexes;

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

        vertexes = graph.getVertexes();

        this.distance = new ArrayList<Integer>();
        for (int i = 0; i < vertexes.size(); i++){
            distance.add(0);
        }
        this.notVisited = vertexes;
        this.current = startVertex;
        Integer value = 0;
        for (int i = 0; i < vertexes.size(); i++) {
            int vertexIndex;
            if (vertexes.get(i).equals(startVertex)) {
                vertexIndex = vertexes.indexOf(startVertex);
                this.distance.set(vertexIndex, 0);
            } else {
                vertexIndex = vertexes.indexOf(vertexes.get(i));
                this.distance.set(vertexIndex, 9999);
            }
        }

        while (!this.notVisited.isEmpty()) {
            this.distance = fillPathDijkstra(graph, graph.getNeighbors(current), value);
            Integer aux = 9999;
            for (int i = 0; i < this.distance.size(); i++){
                int indexHolder = vertexes.indexOf(get(i));
                indexHolder++;
                Integer cost = this.distance.get(i);
                //String vertex = vertexes.get(i);
                if (cost != 0 && cost < aux && this.notVisited.contains(indexHolder)){
                    aux = cost;
                }
                if(i==this.distance.size() -1) {
                    value = aux;
                    this.notVisited.remove(this.current);
                    this.current = vertexes.get(this.distance.indexOf(value));
                }
            }


        }

        return this.distance;
    }
}