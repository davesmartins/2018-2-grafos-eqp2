import java.util.ArrayList;

public class Grafo {
    private ArrayList<String> arestas = new ArrayList<String>();
    private ArrayList<String> vertices = new ArrayList<String>();
    private ArrayList<String> nomeArestas = new ArrayList<String>();
    private boolean orientada;
    int [][] matriz = new int[this.getOrdem()][];

    public  Grafo (ArrayList<String> arestas, ArrayList<String> vertices, ArrayList<String> nomeArestas, boolean orientada){
        this.arestas = arestas;
        this.vertices = vertices;
        this.nomeArestas = nomeArestas;
        this.setOrientada(orientada);
    }

    public Grafo (){
    }

    public boolean isOrientada() {
        return orientada;
    }

    public void setOrientada(boolean orientada) {
        this.orientada = orientada;
    }

    public void printMatriz(){

            /*int[][] mat = armazenarGrafo();
            ArrayList<String> lista = new ArrayList<>();
            for (int i = 0; i < getOrdem(); i++){
                String linha = "";
                for(int j = 0; j < arestas.size(); j++ ){
                    linha += mat[i][j]+" ";
                }
                lista.add(linha);
            }
            return lista;*/

            for(int k = 0; k<matriz.length; k++){

                for(int j = 0; j< matriz.length;j++){

                    System.out.printf("%d", matriz[k][j]);

                }

            }

    }

    private int[][] armazenarGrafo() {

        if (this.isOrientada()){
            for (int i = 0; i < arestas.size(); i++){
                for (int j = 0; j < this.vertices.size(); j++){
                    if (this.vertices.get(j) == getVerticeOrigem(arestas,i)){
                        matriz[i][j] = 1;
                    }else{
                        if (this.vertices.get(j) == getVerticeDestino(arestas,i)){
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
                    if (this.vertices.get(j) == getVerticeOrigem(arestas,i) ||
                        this.vertices.get(j) == getVerticeDestino(arestas,i)){
                        matriz[i][j] = 1;
                    }else{
                        matriz[i][j] = 0;
                    }
                }
            }
        }

        return matriz;
    }

    public String getVerticeOrigem(ArrayList<String> a, int i){
        int j = 0;
        String aresta = a.get(i);
        while(aresta.charAt(j)!= '/'){
            j++;
        }
        return aresta.substring(0,j-1);
    }
    public String getVerticeDestino(ArrayList<String> a, int i){
        int j = 0;
        String aresta = a.get(i);
        while(aresta.charAt(j)!= '/'){
            j++;
        }
        return aresta.substring(j+1,aresta.length()-1);
    }
    public int getGrau(Vertice v){
        int cont = 0;
        for(int i =0; i<arestas.size(); i++){
            if ( v.getNome().equals( arestas.get(i) ) ||
                 v.getNome().equals( arestas.get(i) )){
                    cont++;
            }
        }
        return cont;
    }

    public void adicionaVertice(String vertice){
        vertices.add(vertice);
    }

    public int getOrdem(){
        return vertices.size();
    }

    public ArrayList<String> getArestas() {
        return arestas;
    }

    public void setArestas(ArrayList<String> arestas) {
        this.arestas = arestas;
    }

    public ArrayList<String> getVertices() {
        return vertices;
    }

    public void setVertices(ArrayList<String> vertices) {
        this.vertices = vertices;
    }

    public ArrayList<String> getNomeArestas() {
        return nomeArestas;
    }

    public void setNomeArestas(ArrayList<String> nomeArestas) {
        this.nomeArestas = nomeArestas;
    }

    public int[][] getMatriz() {
        return matriz;
    }

    public void setMatriz(int[][] matriz) {
        this.matriz = matriz;
    }
}