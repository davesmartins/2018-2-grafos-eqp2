import java.util.Scanner;

public class Menu {


    private int opcao;
    private String nomeAresta;
    private String nomeVertice;
    private String verticeSaida;
    private String verticeEntrada;


    Scanner lerOP = new Scanner(System.in);
    Scanner lerNV = new Scanner(System.in);
    Scanner lerNA = new Scanner(System.in);
    Scanner lerVS = new Scanner(System.in);
    Scanner lerVE = new Scanner(System.in);
	



    public void menuOp() {
        System.out.printf("1 - Criar Vertice \n 2 - Criar Aresta \n 3 - Exibir Grafo \n 0 - Sair");
        System.out.printf("Informe o numero desejado: ");
        this.opcao = lerOP.nextInt();
    }

    switch(opcao){
        case 1:
        System.out.println("Digite o nome de Vertice: ");
        this.nomeVertice = lerNV.nextInt();
        menuOp();
        break;
        case 2:
        System.out.println("Digite o nome de Aresta: ");
        this.nomeAresta = lerNA.nextInt();

	    System.out.println("Digite o vertice de saida de Aresta: ");
	    this.verticeSaida = lerVS.nextInt();
	
	    System.out.println("Digite o vertice de entrada de Aresta: ");
	    this.verticeEntrada = lerVE.nextInt();

        menuOp();
        break;
        case 3:
        imprimeGrafo();
        break;
        default:
            System.out.println("Opção inválida.");
    }
        }

    public int getAresta() {
        return aresta;
    }

    public int getVertice() {
        return vertice;
    }
}
