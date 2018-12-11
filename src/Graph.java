import java.net.Inet4Address;
import java.util.ArrayList;

public class Graph {
    ArrayList<ArrayList<Integer>> incidenceMatrix = new ArrayList<ArrayList<Integer>>();
    ArrayList<String> vertexes = new ArrayList<String>();
    ArrayList<String> edges = new ArrayList<String>();
    Boolean oriented;
    Boolean valued;

    public Graph (Boolean oriented, Boolean valued){
        this.oriented = oriented;
        this.valued = valued;
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

    public void addEdge(String start, String end, Integer cost, String edge) {
        if (this.vertexes.contains(start) && this.vertexes.contains(end) && cost > 0 && !this.edges.contains(edge)) {
            Integer startIndex = this.vertexes.indexOf(start);
            Integer endIndex = this.vertexes.indexOf(end);
            for (ArrayList<Integer> a : this.incidenceMatrix) {
                a.add(0);
            }

            this.incidenceMatrix.get(startIndex).remove(this.incidenceMatrix.get(startIndex).size() - 1);
            this.incidenceMatrix.get(endIndex).remove(this.incidenceMatrix.get(endIndex).size() - 1);
            this.incidenceMatrix.get(startIndex).add(cost);
            if (this.isOriented()){
                this.incidenceMatrix.get(endIndex).add(-cost);
            }else{
                this.incidenceMatrix.get(endIndex).add(cost);
            }
            this.edges.add(edge);
        }else{
            System.out.println("ERROR: Lembre-se, Arestas precisam ter nomes diferentes!!!!!");
            System.out.println("ERROR: O custo DEVE ser MAIOR que 0(zero)!!!!");
            System.out.println("ERROR: O nome dos vertices podem estar errados, certifique-se de colocar cada caracter igual ao nome do vertice!!");
            System.out.println("ERROR: Aborting!!!");
        }
    }

    public void deleteVertex(String vertex){
        if(this.vertexes.contains(vertex)){
           Integer vertexIndex = this.vertexes.indexOf(vertex);
           this.vertexes.remove(vertexIndex);
           for (int i = 0; i < this.incidenceMatrix.get(vertexIndex).size(); i++){
               if (this.incidenceMatrix.get(vertexIndex).get(i) > 0){
                   this.deleteEdge(i);
               }
           }
        }else {
            System.out.println("ERROR: Não existe um Vértice com esse nome!!");
            System.out.println("ERROR: Aborting!!!");
            return;
        }
    }

    public void deleteEdge(String edge){
        if(this.edges.contains(edge)){
            Integer edgeIndex = this.edges.indexOf(edge);
            System.out.println(this.edges.size());
            this.edges.remove(edgeIndex);
            System.out.println(this.edges.size());
            for(int i = 0; i < this.incidenceMatrix.size(); i++){
                this.incidenceMatrix.get(i).remove(edgeIndex);
            }
        }else {
            System.out.println("ERROR: Não existe uma Aresta com esse nome!!");
            System.out.println("ERROR: Aborting!!!");
            return;
        }
    }

    public void deleteEdge(Integer index){
        this.edges.remove(index);
        for(int i = 0; i < this.incidenceMatrix.size(); i++){
            this.incidenceMatrix.get(i).remove(index);
        }
    }

    public Boolean isValued(){
        return this.valued;
    }

    public Boolean isOriented(){
        return this.oriented;
    }

    public Integer order(){
        return this.vertexes.size();
    }

    public Integer vertexDegree(String vertex){
        Integer degree = 0;
        if (this.getVertexes().contains(vertex)){
            Integer vertexIndex = this.getVertexes().indexOf(vertex);
            ArrayList<Integer> arrayList = this.incidenceMatrix.get(vertexIndex);
            for (Integer x: arrayList) {
                if (x != 0){
                    degree++;
                }
            }
            return degree;
        }else{
            return -1;
        }
    }

    public Integer vertexInputDegree(String vertex){
        Integer degree = 0;
        Integer vertexIndex = this.getVertexes().indexOf(vertex);
        ArrayList<Integer> arrayList = this.incidenceMatrix.get(vertexIndex);
        for (Integer x: arrayList) {
            if (x < 0){
                degree++;
            }
        }
        return degree;
    }

    public Integer vertexOutputDegree(String vertex){
        Integer degree = 0;
        Integer vertexIndex = this.getVertexes().indexOf(vertex);
        ArrayList<Integer> arrayList = this.incidenceMatrix.get(vertexIndex);
        for (Integer x: arrayList) {
            if (x > 0){
                degree++;
            }
        }
        return degree;
    }

    public ArrayList<String> getVertexes(){
        return this.vertexes;
    }

    @Override
    public String toString() {
        String s = "";
        Integer index = 0;
        for (ArrayList<Integer> a : this.incidenceMatrix) {
            for (Integer i : a) {
                if (i > 0) {
                    s += "   " + i + "|";
                } else {
                    s += "  " + i + "|";
                }
            }
            s += "  " + this.vertexes.get(index);
            index++;
            s += "\n";
        }
        return s;
    }
}