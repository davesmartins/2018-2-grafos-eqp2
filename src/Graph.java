import java.util.ArrayList;

public class Graph {
    ArrayList<ArrayList<Integer>> incidenceMatrix = new ArrayList<ArrayList<Integer>>();
    ArrayList<String> vertexes = new ArrayList<String>();

    public void addVertex(String insert) {
        for (String v : this.vertexes) {
            if (v.equals(insert)) {
                System.out.println("ERROR: Vertices precisam ter nomes diferentes!!!!!");
                System.out.println("ERROR: Aborting!!!");
                return;
            }
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

    public void addEdge(String start, String end, Integer cost) {
        if (this.vertexes.contains(start) && this.vertexes.contains(end) && cost != 0) {
            Integer startIndex = this.vertexes.indexOf(start);
            Integer endIndex = this.vertexes.indexOf(end);
            for (ArrayList<Integer> a : this.incidenceMatrix) {
                a.add(0);
            }

            this.incidenceMatrix.get(startIndex).remove(this.incidenceMatrix.get(startIndex).size() - 1);
            this.incidenceMatrix.get(endIndex).remove(this.incidenceMatrix.get(endIndex).size() - 1);
            this.incidenceMatrix.get(startIndex).add(cost);
            this.incidenceMatrix.get(endIndex).add(-cost);
        }else{
            System.out.println("ERROR: O custo NÃO pode ser 0(zero)!!!!");
            System.out.println("ERROR: O nome dos vertices podem estar errados, certifique-se de colocar cada caracter igual ao do vertice!!");
            System.out.println("ERROR: Aborting!!!");
        }
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