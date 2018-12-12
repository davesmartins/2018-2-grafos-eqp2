import java.util.Scanner;

public class Menu {
    private Graph graph;

    public void createGraphMenu(){
        String option;
        String name;
        Boolean oriented;
        Boolean valued;
        Scanner scan = new Scanner(System.in);
        System.out.println("****************************** Criando Grafo ******************************");
        System.out.println("Qual o nome do Grafo a ser criado?");
        name = scan.next();
        System.out.println("O Grafo será orientado?(Digite 'y' para Sim e 'n' para Não)");
        option = scan.next();
        if (option.equals("y") || option.equals("Y")){
            oriented = true;
        }else if (option.equals("n") || option.equals("N")){
            oriented = false;
        }else{
            System.out.println("ERROR: Digite apenas y ou n");
            System.out.println("ERROR: Aborting!!!");
            return;
        }

        System.out.println("O Grafo será valorado?(Digite 'y' para Sim e 'n' para Não)");
        option = scan.next();
        if (option.equals("y") || option.equals("Y")){
            valued = true;
        }else if (option.equals("n") || option.equals("N")){
            valued = false;
        }else{
            System.out.println("ERROR: Digite apenas y ou n");
            System.out.println("ERROR: Aborting!!!");
            return;
        }
        System.out.println("*****************************************************************************************");
        this.graph = new Graph(name, oriented, valued);
        this.graphMenu();
    }

    public void graphMenu(){
        String vertex = "";
        String edge = "";
        String start = "";
        String end = "";
        Integer cost;
        Integer option;
        Scanner scan = new Scanner(System.in);

        do {
            System.out.println("*****************************************************************************************");
            System.out.println("Digite 0 para Sair do Programa.\n" +
                    "Digite 1 para Adicionar um Vertice no Grafo.\n" +
                    "Digite 2 para Adicionar uma Aresta no Grafo.\n" +
                    "Digite 3 para Remover uma Aresta no Grafo.\n" +
                    "Digite 4 para Remover uma Vertice no Grafo.\n" +
                    "Digite 5 para Imprimir o Grafo em uma Matriz de Incidência.\n" +
                    "Digite 6 para Exibir o Menu de Informações do Grafo.\n" +
                    "Digite 7 para Exportar o Grafo em um arquivo PNG.");
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
                    System.out.println("Digite o nome da Aresta:");
                    edge = scan.next();
                    System.out.println("Digite o nome do Vertice de Origem:");
                    start = scan.next();
                    System.out.println("Digite o nome do Vertice de Destino:");
                    end = scan.next();
                    if (graph.isValued()) {
                        System.out.println("Digite o custo da Aresta(Não aceitamos valores negativos):");
                        cost = scan.nextInt();
                    }else{
                        cost = 1;
                    }
                    graph.addEdge(start, end, cost, edge);
                    break;
                case 3:
                    System.out.println("****************************** Remove Aresta ******************************");
                    System.out.println("Digite o nome da Aresta à ser removida:");
                    edge = scan.next();
                    graph.deleteEdge(graph.getEdge(edge));
                    break;
                case 4:
                    System.out.println("****************************** Remove Vertice ******************************");
                    System.out.println("Digite o nome do Vertice à ser removido:");
                    vertex = scan.next();
                    graph.deleteVertex(vertex);
                    break;

                case 5:
                    System.out.println("****************************** Imprimindo Matriz de Incidência ******************************");
                    System.out.println(graph.toString());
                    break;

                case 6:
                    this.informationMenu();
                    break;

                case 7:
                    ExportGraph eg = new ExportGraph(graph);
                    eg.exportationGraph(eg.toDotLanguage());
                    break;

                default:
                    System.out.println("O comando digitado NÃO existe!!!");
                    break;
            }
        }while (option != 0);
    }

    public void informationMenu(){
        System.out.println("****************************** Informações do Grafo ******************************");
        System.out.println("Ordem do Grafo: " + graph.order());
        for (int i = 0; i < graph.getVertexes().size(); i++){
            if(!graph.isOriented()){
                System.out.println("\nGrau do Vertice '" + graph.getVertexes().get(i) + "': " + graph.vertexDegree(graph.getVertexes().get(i)));
            }else{
                System.out.println("\nGrau de Entrada do Vertice '" + graph.getVertexes().get(i) + "': " + graph.vertexInputDegree(graph.getVertexes().get(i)));
                System.out.println("Grau de Saída do Vertice '" + graph.getVertexes().get(i) + "': " + graph.vertexOutputDegree(graph.getVertexes().get(i)));
            }
        }
        System.out.println("\n");
        graph.isComplete();
        graph.isOriented();
        graph.isRegular();
        System.out.println("*****************************************************************************************");
    }
}
