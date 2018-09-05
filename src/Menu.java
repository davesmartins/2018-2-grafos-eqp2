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


        switch (opcao) {
            case 1:
                System.out.println("Digite o nome de Vertice: ");
                this.nomeVertice = lerNV.next();
                menuOp();
                break;
            case 2:
                System.out.println("Digite o nome de Aresta: ");
                this.nomeAresta = lerNA.next();

                System.out.println("Digite o vertice de saida de Aresta: ");
                this.verticeSaida = lerVS.next();

                System.out.println("Digite o vertice de entrada de Aresta: ");
                this.verticeEntrada = lerVE.next();

                menuOp();
                break;
            case 3:

                Grafo grafo = new Grafo();
                grafo.imprimeGrafo();

                break;
            default:

                System.out.println("Opção inválida.");
        }
    }

    public void setNomeAresta(String nomeAresta) {
        this.nomeAresta = nomeAresta;
    }

    public void setNomeVertice(String nomeVertice) {
        this.nomeVertice = nomeVertice;
    }

    public void setVerticeSaida(String verticeSaida) {
        this.verticeSaida = verticeSaida;
    }

    public void setVerticeEntrada(String verticeEntrada) {
        this.verticeEntrada = verticeEntrada;
    }
}
