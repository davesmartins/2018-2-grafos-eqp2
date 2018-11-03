import java.util.Scanner;

public class Menu {
    private Graph graph = new Graph();

    public void mainMenu(){
        String vertex = "";
        String start = "";
        String end = "";
        Integer cost;
        Integer option = 0;
        Scanner scan = new Scanner(System.in);

        do {
            System.out.println("*****************************************************************************************");
            System.out.println("Digite 0 para Sair do Programa.\n" +
                    "Digite 1 para Adicionar um Vertice no Grafo.\n" +
                    "Digite 2 para Adicionar uma Aresta no Grafo.\n" +
                    "Digite 3 para Imprimir o Grafo em uma Matriz de Incidência.");
            System.out.println("*****************************************************************************************");
            System.out.println("O que você deseja fazer agora?");
            option = scan.nextInt();
            switch (option){
                case 0:
                    break;
                case 1:
                    System.out.println("****************************** Criando Vertice ******************************");
                    System.out.println("Digite um nome para o novo Vertice:");
                    vertex = scan.next();
                    graph.addVertex(vertex);
                    break;
                case 2:
                    System.out.println("****************************** Criando Aresta ******************************");
                    System.out.println("Digite o nome do Vertice de Origem:");
                    start = scan.next();
                    System.out.println("Digite o nome do Vertice de Destino:");
                    end = scan.next();
                    System.out.println("Digite o custo da Aresta:");
                    cost = scan.nextInt();
                    graph.addEdge(start, end, cost);
                    break;
                case 3:
                    System.out.println("****************************** Imprimindo Grafo ******************************");
                    System.out.println(graph.toString());
                    break;
                default:
                    System.out.println("O comando digitado NÃO existe!!!");
                    break;
            }
        }while (option != 0);
    }
}