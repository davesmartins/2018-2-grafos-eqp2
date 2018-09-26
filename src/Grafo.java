import java.util.ArrayList;

public class Grafo {
    private ArrayList<String> arestas = new ArrayList<String>();
    private ArrayList<String> vertices = new ArrayList<String>();
    private ArrayList<String> nomeArestas = new ArrayList<String>();
    private boolean orientada;

    public  Grafo (ArrayList<String> arestas, ArrayList<String> vertices, boolean orientada, ArrayList<String> nomeArestas){
        this.arestas = arestas;
        this.vertices = vertices;
        this.nomeArestas = nomeArestas;
        this.setOrientada(orientada);
    }

    public boolean isOrientada() {
        return orientada;
    }

    public void setOrientada(boolean orientada) {
        this.orientada = orientada;
    }

    public ArrayList<String> printMatriz(){

            int[][] mat = armazenarGrafo();
            ArrayList<String> lista = new ArrayList<>();
            for (int i = 0; i < getOrdem(); i++){
                String linha = "";
                for(int j = 0; j < arestas.size(); j++ ){
                    linha += mat[i][j]+" ";
                }
                lista.add(linha);
            }
            return lista;
    }

    private int[][] armazenarGrafo() {
        int [][] matriz = new int[this.getOrdem()][];
        if (this.isOrientada()){
            for (int i = 0; i < this.getOrdem(); i++){
                for (int j = 0; j < this.arestas.size(); j++){
                    if (this.arestas.get(j).getVerticeSaida() == this.vertices.get(i)){
                        matriz[i][j] = 1;
                    }else{
                        if (this.arestas.get(j).getVerticeChegada() == this.vertices.get(i)){
                            matriz[i][j] = -1;
                        }else {
                            matriz[i][j] = 0;
                        }
                    }
                }
            }
        }else{
            for (int i = 0; i < this.getOrdem(); i++){
                for (int j = 0; j < this.arestas.size(); j++){
                    if (this.arestas.get(j).getVerticeSaida() == this.vertices.get(i) ||
                        this.arestas.get(j).getVerticeChegada() == this.vertices.get(i)){
                        matriz[i][j] = 1;
                    }else{
                        matriz[i][j] = 0;
                    }
                }
            }
        }

        return matriz;
    }

    public int getGrau(Vertice v){
        int cont = 0;
        for(Aresta a: arestas){
            if ( v.getNome().equals( a.getVerticeSaida().getNome() ) ||
                 v.getNome().equals( a.getVerticeChegada().getNome() )){
                    cont++;
            }
        }
        return cont;
    }

    public int getOrdem(){
        return vertices.size();
    }

    public void adicionaAresta(Aresta a){
        this.arestas.add(a);
    }

    public void excluiAresta(Aresta a){
        this.arestas.remove(a);
    }

    public void adicionaVertice(Vertice v){
        this.vertices.add(v);
    }

    public void excluiVertice(Vertice v){
        this.vertices.remove(v);
    }
}