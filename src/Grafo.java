import java.util.ArrayList;

public class Grafo{

    private ArrayList<Aresta> arestas;
    private ArrayList<Vertice> vertices;
    private String id;
    private Boolean orientada;


    public Grafo(String id, Boolean orientada) {
        this.id = id;
        arestas = new ArrayList<>();
        vertices = new ArrayList<>();
        this.orientada = orientada;
    }

    public Grafo(ArrayList<Aresta> arestas, ArrayList<Vertice> vertices, String id, Boolean orientada) {
        this.arestas = arestas;
        this.vertices = vertices;
        this.id = id;
        this.orientada = orientada;
    }

    public void addAresta(Aresta aresta){
        this.arestas.add(aresta);
    }

    public void addVertice(Vertice vertice){
        this.vertices.add(vertice);
    }

    public ArrayList<Aresta> getArestas() {
        return arestas;
    }

    public void setArestas(ArrayList<Aresta> arestas) {
        this.arestas = arestas;
    }

    public ArrayList<Vertice> getVertices() {
        return vertices;
    }

    public void setVertices(ArrayList<Vertice> vertices) {
        this.vertices = vertices;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Boolean isOrientada(){
        return this.orientada;
    }

    public void setOrientada(Boolean orientada){
        this.orientada = orientada;
    }

    public String[][] gerarMatrizIncidencia(){
        String[][] matriz = new String[getVertices().size()][getArestas().size()];
        if(this.isOrientada()){
            for (int i = 0; i < getVertices().size(); i++){
                for(int j = 0; j < getArestas().size(); j++){
                    if (getVertices().get(i).equals(getArestas().get(j).getVerticeOrigem())){
                        matriz[i][j] = "1";
                    }else{
                        if (getVertices().get(i).equals(getArestas().get(j).getVerticeDestino())){
                            matriz[i][j] = "-1";
                        }else{
                            matriz[i][j] = "0";
                        }
                    }
                }
            }
        }else{
            for (int i = 0; i < getVertices().size(); i++){
                for(int j = 0; j < getArestas().size(); j++){
                    if (getVertices().get(i).equals(getArestas().get(j).getVerticeOrigem()) ||
                        getVertices().get(i).equals(getArestas().get(j).getVerticeDestino())){
                        matriz[i][j] = "1";
                    }else{
                        matriz[i][j] = "0";
                    }
                }
            }
        }

        return matriz;
    }

    public void imprimeGrafo(String[][] matrizI){
        if (matrizI != null) {
            ArrayList<String> matriz = new ArrayList<String>();
            String linha;
            String arestas = "\t";

            for (int i = 0; i < this.getVertices().size(); i++) {
                linha = "";
                for (int j = 0; j < this.getArestas().size(); j++) {
                    linha += matrizI[i][j] + "\t";
                }
                matriz.add(linha);
            }

            for (int i = 0; i < this.getArestas().size(); i++) {
                arestas += this.getArestas().get(i).getId() + "\t";
            }

            System.out.println(arestas);

            for (int i = 0; i < this.getVertices().size(); i++) {
                System.out.println(this.getVertices().get(i).getId() + "\t" + matriz.get(i));
            }

            System.out.println("\n\n");
        }else{
            System.out.println("A matriz ainda não foi construida, ou o Grafo não existe");
        }
    }
}