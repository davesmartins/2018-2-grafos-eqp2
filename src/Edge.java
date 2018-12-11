public class Edge {
    private String name;
    private String startVertex;
    private String endVertex;
    private Integer cost;

    public Edge(String name, String startVertex, String endVertex, Integer cost){
        this.name = name;
        this.startVertex = startVertex;
        this.endVertex = endVertex;
        this.cost = cost;
    }

    public String getName(){
        return this.name;
    }

    public String getStartVertex(){
        return this.startVertex;
    }

    public String getEndVertex(){
        return this.endVertex;
    }

    public Integer getCost(){
        return this.cost;
    }

}
