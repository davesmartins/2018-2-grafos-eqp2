import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        int opcao;
        String nomeAresta;
        String nomeVertice;
        String nomeVerticeSaida;
        String nomeVerticeEntrada;

        Scanner lerOpcao = new Scanner(System.in);
        Scanner lerNewVertice = new Scanner(System.in);
        Scanner lerNewAresta = new Scanner(System.in);
        Scanner lerVerticeSaida = new Scanner(System.in);
        Scanner lerVerticeEntrada = new Scanner(System.in);

        Grafo grafo = new Grafo();

        System.out.printf(" 1 - Criar Vertice \n 2 - Criar Aresta \n 3 - Exibir Grafo \n 0 - Sair");
        System.out.printf("\n Informe o numero desejado: ");
        opcao = lerOpcao.nextInt();


        switch (opcao) {

    }
}
