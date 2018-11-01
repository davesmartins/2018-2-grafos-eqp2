import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    private Grafo grafo;
    private ArrayList<Vertice> vertices;
    private ArrayList<Aresta> arestas;

    public void menuPrincipal(){
        int op = 0;
        Scanner scan = new Scanner(System.in);
        this.menuOp();
        do {
        System.out.println("Caso você queira rever o menu de opções, digite 00.");
        System.out.println("Qual operação você quer fazer agora?");
        op = scan.nextInt();
            switch (op){
                case 1:
                    this.criaVertice();
                    break;
                case 2:
                    this.criaAresta();
                    break;
                case 3:
                    this.criaGrafo();
                    break;
                case 4:
                    this.imprimeGrafo();
                    break;
                case 0:
                    x = 0;
                    break;
                case 00:
                    this.menuOp();
                    break;
                default:
                    System.out.printf("\n Digite apenas as opções de acordo com o menu de opções.\n");
                    break;
            }
        }while (op != 0);
    }

    public void menuOp(){
        System.out.println("*****************************************************************************************");
        System.out.println( "Digite 1 para Criar um Vertice.\n" +
                "Digite 2 para Criar uma Aresta.\n" +
                "Digite 3 para Criar uo Grafo.\n"   +
                "Digite 4 para Imprimir o Grafo.\n" +
                "Digite 0 para finalizar o programa.");
        System.out.println("*****************************************************************************************");
    }

    public void criaVertice(){
        String nome;
        Scanner scan = new Scanner(System.in);

        System.out.println("*************************************Criando Vertice*************************************");
        System.out.println("Digite o nome do Vertice:");
        nome = scan.next();

        if (this.vertices.isEmpty() || this.vertices.){
            System.out.println("O nome digitado já existe");
        }else{
            Vertice v = new Vertice(nome);
            this.vertices.add(v);
        }
    }

    public void criaAresta(){
        String nome;
        String vOrigem;
        String vDestino;
        Scanner scanno = new Scanner(System.in);
        Scanner scanvo = new Scanner(System.in);
        Scanner scanvd = new Scanner(System.in);

        System.out.println("*************************************Criando Aresta*************************************");
        System.out.println("Digite o nome da Aresta:");
        nome = scanno.next();
        System.out.println("Digite o nome do Vertice de Origem:");
        vOrigem = scanvo.next();
        System.out.println("Digite o nome do Vertice de Destino:");
        vDestino = scanvd.next();

        if ()
    }
}
