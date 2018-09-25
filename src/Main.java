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
        String nomeVerticeSaida;
        String nomeVerticeEntrada;
        boolean orientado;
        ArrayList<Vertice> vertices = new ArrayList<Vertice>();
        ArrayList<Aresta> arestas = new ArrayList<Aresta>();

        Scanner lerOpcao = new Scanner(System.in);
        Scanner lerNewVertice = new Scanner(System.in);
        Scanner lerNewAresta = new Scanner(System.in);
        Scanner lerVerticeSaida = new Scanner(System.in);
        Scanner lerVerticeEntrada = new Scanner(System.in);
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

                if (x != 0) {
                    for (Vertice v : vertices) {
                        if (nomeVertice.contains(v.getNome())) {
                            igual = true;
                        }
                    }
                    if (igual) {
                        System.out.printf("\n Não será possivel criar este vertice, pois já existe um vertice com este nome.");
                    } else {
                        Vertice vertice = new Vertice(nomeVertice);
                        vertices.add(vertice);
                    }
                } else {
                    Vertice vertice = new Vertice(nomeVertice);
                    vertices.add(vertice);
                }
                break;
            case 2:
                System.out.printf("\n Informe o nome da Aresta: ");
                nomeAresta = lerNewAresta.next();

                System.out.printf("\n Informe o nome do Vertice de Saida: ");
                nomeVerticeSaida = lerVerticeSaida.next();
                Vertice vertice1 = null;
                Vertice vertice2 = null;
                for (Vertice v1 : vertices) {
                    if (nomeVerticeSaida == v1.getNome()) {
                        vertice1 = v1;
                    }
                }

                if (vertice1 == null) {
                    System.out.printf("\n O nome do Vertice informado não existe.");
                } else {
                    System.out.printf("\n Informe o nome do Vertice de Entrada: ");
                    nomeVerticeEntrada = lerVerticeEntrada.next();
                    for (Vertice v2 : vertices) {
                        if (nomeVerticeEntrada == v2.getNome()) {
                            vertice2 = v2;
                        }
                    }
                }

                if (vertice2 == null) {
                    System.out.printf("\n O nome do Vertice informado não existe.");
                } else {
                    Aresta aresta = new Aresta(vertice1, vertice2, nomeAresta);
                    arestas.add(aresta);
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