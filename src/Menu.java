import java.util.Scanner;

public class Menu(){


    private int opcao;
    private int aresta;
    private int vertice;

    Scanner ler = new Scanner(System.in);
    Scanner lerA = new Scanner(System.in);
    Scanner lerV = new Scanner(System.in);



    public void menuOp() {
        System.out.printf("1 - Criar Aresta \n 2 - Criar Vertice \n 3 - Exibir Grafo \n");
        System.out.printf("Informe o numero desejado: ");
        this.opcao = ler.nextInt();
    }

    switch(opcao){
        case 1:
        System.out.println("Digite numero de Aresta: ");
        this.aresta = lerA.nextInt();
        menuOp();
        break;
        case 2:
        System.out.println("Digite numero de Vertice: ");
        this.vertice = lerV.nextInt();
        menuOp();
        break;
        case 3:
        imprimeGrafo();
        break;

        }

    public int getAresta() {
        return aresta;
    }

    public int getVertice() {
        return vertice;
    }
}
