import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        for (int i = 1; i != 0; i++) {
            i = menu();
        }
    }

    public static int menu() {
        int resultado = 1;
        int opcao;
        String nomeAresta;
        String nomeVertice;
        boolean orientado;
        ArrayList<String> vertices = new ArrayList<String>();
        ArrayList<String> arestas = new ArrayList<String>();
        ArrayList<String> nomeArestas = new ArrayList<String>();

        Scanner lerOpcao = new Scanner(System.in);
        Scanner lerNewVertice = new Scanner(System.in);
        Scanner lerNewAresta = new Scanner(System.in);
        Scanner lerVerticeOrigem = new Scanner(System.in);
        Scanner lerVerticeDestino = new Scanner(System.in);
        Scanner lerOrientado = new Scanner(System.in);

        Grafo grafo = null;

        System.out.printf(" 1 - Criar Vertice \n 2 - Criar Aresta \n 3 - Criar Grafo \n 4 - Imprimir Grafo \n 0 - Sair");
        System.out.printf("\n Informe o numero desejado: ");
        opcao = lerOpcao.nextInt();


        switch (opcao) {
            case 1:
                System.out.printf("\n Informe o nome do Vertice: ");
                nomeVertice = lerNewVertice.next();
                boolean igual = false;
                int x = vertices.size();

                if (x > 0) {
                    for (int i = 0; i <vertices.size(); i++) {
                        if (nomeVertice == vertices.get(i) ) {
                            igual = true;
                        }
                    }
                    if (igual) {
                        System.out.printf("\n Não será possivel criar este vertice, pois já existe um vertice com este nome.");
                    } else {
                        Vertice vertice = new Vertice(nomeVertice);
                        vertices.add(vertice.getNome());
                    }
                } else {
                    Vertice vertice = new Vertice(nomeVertice);
                    vertices.add(vertice.getNome());
                }
                break;
            case 2:
                System.out.printf("\n Informe o nome da Aresta: ");
                nomeAresta = lerNewAresta.next();

                System.out.printf("\n Informe o nome do Vertice de origem: ");
                String nomeVerticeOrigem = lerVerticeOrigem.next();
                String vertice1 = null;
                String vertice2 = null;
                for (int i = 0; i <vertices.size(); i++) {
                    if (nomeVerticeOrigem == vertices.get(i)) {
                        vertice1 = vertices.get(i);
                    }
                }

                if (vertice1 == null) {
                    System.out.printf("\n O nome do Vertice informado não existe.");
                } else {
                    System.out.printf("\n Informe o nome do Vertice de Destino: ");
                    String nomeVerticeDestino = lerVerticeDestino.next();
                    for (int i = 0; i <vertices.size(); i++) {
                        if (nomeVerticeDestino == vertices.get(i)) {
                            vertice2 = vertices.get(i);
                        }
                    }
                }

                if (vertice2 == null) {
                    System.out.printf("\n O nome do Vertice informado não existe.");
                } else {
                    Aresta aresta = new Aresta(vertice1, vertice2, nomeAresta);
                    arestas.add(aresta.getVerticeOrigem()+"/"+aresta.getVerticeDestino());
                    nomeArestas.add(aresta.getNome());
                }
                break;

            case 3:
                System.out.printf("\n Digite 1(um) se o grafo for orientado e 0(zero) para caso o grafo não seja orientado.");
                orientado = lerOrientado.nextBoolean();
                grafo = new Grafo(arestas, vertices, orientado);
                break;
            case 4:
                ArrayList<String> matriz = new ArrayList<String>();
                matriz = grafo.printMatriz();
                for (int i = 0; i < matriz.size(); i++) {
                    System.out.println(matriz.get(i) + "\n");
                }
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