import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        for (int p = 1; p != 0; p++) {
            p = menu();
        }
    }

    public static int menu() {
        Grafo grafo = new Grafo();
        int resultado = 1;
        int opcao;
        String nomeAresta;
        String nomeVertice;
        int orientado;
        Scanner lerOpcao = new Scanner(System.in);
        Scanner lerNewVertice = new Scanner(System.in);
        Scanner lerNewAresta = new Scanner(System.in);
        Scanner lerVerticeOrigem = new Scanner(System.in);
        Scanner lerVerticeDestino = new Scanner(System.in);
        Scanner lerOrientado = new Scanner(System.in);

        //Grafo grafo = null;

        System.out.printf(" 1 - Criar Vertice \n 2 - Criar Aresta \n 3 - Criar Grafo \n 4 - Imprimir Grafo \n 0 - Sair");
        System.out.printf("\n Informe o numero desejado: ");
        opcao = lerOpcao.nextInt();


        switch (opcao) {
            case 1:
                System.out.printf("\n Informe o nome do Vertice: ");
                nomeVertice = lerNewVertice.next();
                boolean igual = false;

                //if (grafo.getVertices().size() > 0) {
                    for (int i = 0; i <grafo.getVertices().size(); i++) {
                        if (nomeVertice == grafo.getVertices().get(i) ) {
                            igual = true;
                        }
                    }
                    
                    if (igual) {
                        System.out.printf("\n Não será possivel criar este vertice, pois já existe um vertice com este nome.");
                    } else {

                        grafo.getVertices().add(nomeVertice);
                        System.out.println(grafo.getVertices().get(0)+'\n');
                        //System.out.println(grafo.getVertices().get(1));
                    }
                /*} else {
                    Vertice vertice = new Vertice(nomeVertice);
                    grafo.getVertices().add(vertice.getNome());
                    System.out.println(grafo.getVertices().get(0));
                }*/

                break;

            case 2:
                //System.out.printf("\n Informe o nome da Aresta: ");
                //nomeAresta = lerNewAresta.next();

                System.out.printf("\n Informe o nome do Vertice de origem: ");
                String nomeVerticeOrigem = lerVerticeOrigem.next();
                String vertice1 = null;
                String vertice2 = null;
                for (int i = 0; i <grafo.getVertices().size(); i++) {
                    if (grafo.getVerticeOrigem(grafo.getVertices(),i) == nomeVerticeOrigem) {
                        vertice1 = grafo.getVertices().get(i);
                    }
                }

                if (vertice1 == null) {
                    System.out.printf("\n O nome do Vertice informado não existe.");
                } else {
                    System.out.printf("\n Informe o nome do Vertice de Destino: ");
                    String nomeVerticeDestino = lerVerticeDestino.next();
                    for (int i = 0; i <grafo.getVertices().size(); i++) {
                        if (nomeVerticeDestino == grafo.getVertices().get(i)) {
                            vertice2 = grafo.getVertices().get(i);
                        }
                    }
                }

                if (vertice2 == null) {
                    System.out.printf("\n O nome do Vertice informado não existe.");
                } else {
                    Aresta aresta = new Aresta(vertice1, vertice2);
                    grafo.getArestas().add(aresta.getVerticeOrigem()+"/"+aresta.getVerticeDestino());
                    grafo.getNomeArestas().add(aresta.getNome());
                }
                break;

            case 3:
                System.out.printf("\n Digite 1(um) se o grafo for orientado e 0(zero) para caso o grafo não seja orientado.");
                orientado = lerOrientado.nextInt();
                if(orientado == 1 )
                grafo.setOrientada(true);
                    else
                        grafo.setOrientada(false);
                break;
            case 4:
                System.out.println("\n Grafo:\n");
                grafo.printMatriz();



                /*ArrayList<String> matriz = new ArrayList<String>();
                matriz = grafo.printMatriz();
                for (int i = 0; i < matriz.size(); i++) {
                    System.out.println(matriz.get(i) + "\n");
                }*/
                break;
            case 0:
                resultado = -1;
                break;
            default:
                System.out.printf("\n Digite apenas os números dentro do padrão.\n");

        }
        return resultado;
    }

}