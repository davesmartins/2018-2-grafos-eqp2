import java.util.ArrayList;
import java.util.List;


public class Graph {
    private String name;
    private ArrayList<Boolean> visited = new ArrayList<Boolean>();
    private ArrayList<ArrayList<Integer>> incidenceMatrix = new ArrayList<ArrayList<Integer>>();
    private ArrayList<String> vertexes = new ArrayList<String>();
    private ArrayList<Edge> edges = new ArrayList<Edge>();
    private Boolean oriented;
    private Boolean valued;
    private List<Edge> nosVisitados = new ArrayList<Edge>();

    public Graph(String name, Boolean oriented, Boolean valued) {
        this.name = name;
        this.oriented = oriented;
        this.valued = valued;
    }

    public String getName() {
        return this.name;
    }

    public ArrayList<String> getVertices() {

        return this.vertexes;
    }

    public String getDescricao(){

        return name;

    }

    public void addVertex(String insert) {
        if (this.vertexes.contains(insert)) {
            System.out.println("ERROR: Vertices precisam ter nomes diferentes!!!!!");
            System.out.println("ERROR: Aborting!!!");
            return;
        }
        this.vertexes.add(insert);
        ArrayList<Integer> a = new ArrayList<Integer>();
        if (!this.incidenceMatrix.isEmpty()) {
            for (int i = 0; i < this.incidenceMatrix.get(0).size(); i++) {
                a.add(0);
            }
        }
        this.incidenceMatrix.add(a);
    }

    public void addEdge(String start, String end, Integer cost, String name) {
        for (Edge e : this.getEdges()) {
            if (e.getName().equals(name)) {
                System.out.println("ERROR: Lembre-se, Arestas precisam ter nomes diferentes!!!!!");
                System.out.println("ERROR: Aborting!!!");
                return;
            }
        }

        if (this.vertexes.contains(start) && this.vertexes.contains(end) && cost > 0) {
            int startIndex = this.vertexes.indexOf(start);
            int endIndex = this.vertexes.indexOf(end);
            for (ArrayList<Integer> a : this.incidenceMatrix) {
                a.add(0);
            }

            this.incidenceMatrix.get(startIndex).remove(this.incidenceMatrix.get(startIndex).size() - 1);
            this.incidenceMatrix.get(endIndex).remove(this.incidenceMatrix.get(endIndex).size() - 1);
            this.incidenceMatrix.get(startIndex).add(cost);
            if (this.isOriented()) {
                this.incidenceMatrix.get(endIndex).add(-cost);
            } else {
                this.incidenceMatrix.get(endIndex).add(cost);
            }

            Edge edge = new Edge(name, start, end, cost);
            this.getEdges().add(edge);
        } else {
            if (this.isValued()) {
                System.out.println("ERROR: O custo DEVE ser MAIOR que 0(zero)!!!!");
            }
            System.out.println("ERROR: O nome dos vertices podem estar errados, certifique-se de colocar cada caracter igual ao nome do vertice!!");
            System.out.println("ERROR: Aborting!!!");
        }
    }

    public void deleteVertex(String vertex) {
        if (this.vertexes.contains(vertex)) {
            int vertexIndex = this.vertexes.indexOf(vertex);
            this.vertexes.remove(vertexIndex);
            for (int i = 0; i < this.incidenceMatrix.get(vertexIndex).size(); i++) {
                if (this.incidenceMatrix.get(vertexIndex).get(i) != 0) {
                    this.deleteEdge(this.edges.get(i));
                    i = -1;
                }
            }
            this.incidenceMatrix.remove(vertexIndex);
        } else {
            System.out.println("ERROR: Não existe um Vértice com esse nome!!");
            System.out.println("ERROR: Aborting!!!");
            return;
        }
    }

    public void deleteEdge(Edge edge) {
        if (edge != null) {
            int edgeIndex = this.edges.indexOf(edge);
            this.edges.remove(edgeIndex);
            for (int i = 0; i < this.incidenceMatrix.size(); i++) {
                this.incidenceMatrix.get(i).remove(edgeIndex);
            }
        } else {
            System.out.println("ERROR: Não existe uma Aresta com esse nome!!");
            System.out.println("ERROR: Aborting!!!");
            return;
        }
    }

    public Boolean isValued() {
        return this.valued;
    }

    public Boolean isOriented() {
        return this.oriented;
    }

    public Integer order() {
        return this.vertexes.size();
    }

    public Integer vertexDegree(String vertex) {
        Integer degree = 0;
        if (this.getVertexes().contains(vertex)) {
            Integer vertexIndex = this.getVertexes().indexOf(vertex);
            ArrayList<Integer> arrayList = this.incidenceMatrix.get(vertexIndex);
            for (Integer x : arrayList) {
                if (x != 0) {
                    degree++;
                }
            }
            return degree;
        } else {
            return -1;
        }
    }

    public Integer vertexInputDegree(String vertex) {
        Integer degree = 0;
        int vertexIndex = this.getVertexes().indexOf(vertex);
        ArrayList<Integer> arrayList = this.incidenceMatrix.get(vertexIndex);
        for (Integer x : arrayList) {
            if (x < 0) {
                degree++;
            }
        }
        return degree;
    }

    public Integer vertexOutputDegree(String vertex) {
        Integer degree = 0;
        int vertexIndex = this.getVertexes().indexOf(vertex);
        ArrayList<Integer> arrayList = this.incidenceMatrix.get(vertexIndex);
        for (Integer x : arrayList) {
            if (x > 0) {
                degree++;
            }
        }
        return degree;
    }

    public ArrayList<String> getVertexes() {
        return this.vertexes;
    }

    public Integer isRegular() {
        Integer degree = -1;
        for (String vertex : vertexes) {
            if (degree == -1) {
                degree = vertexDegree(vertex);

            } else if (degree != vertexDegree(vertex)) {
                System.out.println("Esse Grafo Não é regular");
                return 0;
            }

        }
        System.out.println("Esse Grafo É regular");

        return degree;
    }

    public void isComplete() {
        if (isRegular() == order() - 1) {
            System.out.println("Esse Grafo É completo");
        } else {
            System.out.println("Esse Grafo Não é completo");
        }
    }

    public ArrayList<Edge> getEdges() {
        return this.edges;
    }

    public Edge getEdge(String name) {
        Edge edge = null;

        for (Edge e : this.getEdges()) {
            if (e.getName().equals(name)) {
                edge = e;
            }
        }
        return edge;
    }

    public ArrayList<String> getNeighbors(String vertex){
        ArrayList<String> neighbors = new ArrayList<String>(); //Criando lista com os vizinhos do vertice
        ArrayList<Edge> lookingEdges = new ArrayList<Edge>(); //Criando lista de arestas com vertice de origem = vertex

        for (Edge e : this.getEdges()){
            if(this.isOriented()){
                if(e.getStartVertex().equals(vertex)){
                    lookingEdges.add(e);
                }
            }else{
                if(e.getStartVertex().equals(vertex) || e.getEndVertex().equals(vertex)){
                    lookingEdges.add(e);
                }
            }
        }

        for (Edge e : lookingEdges){
            if(this.isOriented()){
                neighbors.add(e.getEndVertex());
            }else{
                if(e.getStartVertex().equals(vertex)){
                    neighbors.add(e.getEndVertex());
                }else{
                    neighbors.add(e.getStartVertex());
                }
            }
        }

        return neighbors;
    }

    public void depthFirstSearch(String vertex, ArrayList<Boolean> visited){

        visited.set(this.getVertexes().indexOf(vertex), true);
        System.out.println("Visitando Vertice: " + vertex);

        for (String neighbor : this.getNeighbors(vertex)){
            int index = this.getNeighbors(vertex).indexOf(neighbor);
            if (!visited.get(index)){
                this.depthFirstSearch(neighbor, visited);
            }
        }
    }

    public void fillVisited(){
        for (int i = 0; i < this.getVertexes().size(); i++){
            this.visited.add(false);
        }
    }

    public ArrayList<Boolean> getVisited(){
        return this.visited;
    }
    

    @Override
    public String toString() {
        String s = "\t";
        int index = 0;
        for (Edge edge : this.getEdges()) {
            s += "| " + edge.getName() + "\t";
        }
        s += "\n";
        for (ArrayList<Integer> a : this.incidenceMatrix) {
            s += " " + this.vertexes.get(index) + "\t";
            for (Integer i : a) {
                if (i < 0) {
                    s += "|" + i + "\t";
                } else {
                    s += "| " + i + "\t";
                }
            }
            index++;
            s += "\n";
        }
        return s;
    }


}