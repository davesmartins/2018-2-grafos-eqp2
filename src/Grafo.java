import java.util.ArrayList;

public class Grafo {
    private int grau = 0;
    private int ordem = 0;
    private ArrayList<Aresta> aresta = new ArrayList<Aresta>();
    private ArrayList<Vertice> vertice = new ArrayList<Vertice>();
  //  private int[][] matrizIncidente;
    private boolean orientada;

    public String toString(){

        return "oi";
    }

    public void GrafoOrientado(ArrayList<Vertice> vertices, ArrayList<Aresta> arestas){
        for(int i = 0; i<vertices.size(); i++){
            this.adicionaVertice(vertices.get(i));
        }

        for(int j = 0; j<arestas.size(); j++){
            this.adicionaAresta(arestas.get(j));
        }

        this.setOrientada(true);
    }



    public ArrayList<String> printMatriz(){

            int[][] mat = armazenarGrafo();
            ArrayList<String> lista = mew ArrayList<>();
            for (int linha =0; linha < getOrdem(); linha++){
                String linha = "";
                for(int coluna=0; coluna < aresta.size(); coluna++ ){
                    linha += mat[linha][coluna]+" ";
                }
                lista.add(linha);    
            }
            return lista

    }

    public int getGrau(Vertice v){
int cont = 0;
        for(Aresta a: aresta){
            if ( v.getNome().equals( a.getVertice1().getNome() ) ||
                 v.getNome().equals( a.getVertice2().getNome() )){
                    cont++;
            }

        }
        return cont;
    }

    public int getOrdem(){

        return vertice.size();
    }

    public void GrafoNaoOrientado(ArrayList<Vertice> vertices, ArrayList<Aresta> arestas){
        for(int i = 0; i<vertices.size(); i++){
            this.adicionaVertice(vertices.get(i));
        }

        for(int j = 0; j<arestas.size(); j++){
            this.adicionaAresta(arestas.get(j));
        }

        this.setOrientada(false);
    }

    public void setOrientada(boolean orientada) {
        this.orientada = orientada;
    }

    public boolean isOrientada() {
        return orientada;
    }

    public void adicionaAresta(Aresta a){
        int i = this.getGrau() + 1;
        aresta.add(a);
        this.setGrau(i);
    }

    public void adicionaVertice(Vertice v){
        int i = this.getOrdem() + 1;
        vertice.add(v);
        this.setOrdem(i);
    }

    public void setGrau(int grau) {
        this.grau = grau;
    }

    public void setOrdem(int ordem) {
        this.ordem = ordem;
    }

    public int getGrau() {
        return grau;
    }

    public int getOrdem() {
        return ordem;
    }

    public int[][] getMatrizIncidenteFull(){
        return armazenarGrafo();
    }

    public int getMatrizIncidente(int i, int j) {
        return armazenarGrafo()[i][j];
    }

    public void setMatrizIncidente(int i, int j, int v){
        this.matrizIncidente[i][j] = v;
    }

    public int[][] armazenarGrafo(){
        int [][] matrizIncidente = new int[this.getOrdem()][this.getGrau()];

        if(this.isOrientada()) {
            for (int i = 0; i < this.getOrdem(); i++) {
                for (int j = 0; j < this.getGrau(); j++) {
                    if (this.aresta.get(j).getVertice1() == vertice.get(i)) {
                        this.setMatrizIncidente(i, j, 1);
                    } else {
                        if (this.aresta.get(j).getVertice2() == vertice.get(i)) {
                            this.setMatrizIncidente(i, j, -1);
                        } else {
                            this.setMatrizIncidente(i, j, 0);
                        }
                    }
                }
            }
        }else {
            for (int i = 0; i < this.getOrdem(); i++) {
                for (int j = 0; j < this.getGrau(); j++) {
                    if (this.aresta.get(j).getVertice1() == vertice.get(i) || this.aresta.get(j).getVertice2() == vertice.get(i)) {
                        this.setMatrizIncidente(i, j, 1);
                    } else {
                        this.setMatrizIncidente(i, j, 0);
                    }
                }
            }
        }
        return matrizIncidente;
    }

    public void imprimeGrafo(){
        System.out.println("Grafo em Matriz de Incidência:\n" + this.getMatrizIncidenteFull());
    }
}
