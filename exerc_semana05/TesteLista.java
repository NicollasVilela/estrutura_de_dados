import java.util.Scanner;

class ListaArray {
    private int[] array;
    private int tamanho;

    public ListaArray(int capacidade) {
        this.array = new int[capacidade];
        this.tamanho = 0;
    }

    public void adicionar(int elemento) {
        if (tamanho == array.length) {
            System.out.println("Erro: Lista cheia!");
            return;
        }
        array[tamanho++] = elemento;
    }

    public void remover(int posicao) {
        if (posicao < 0 || posicao >= tamanho) {
            System.out.println("Erro: Posição inválida!");
            return;
        }
        for (int i = posicao; i < tamanho - 1; i++) {
            array[i] = array[i + 1];
        }
        tamanho--;
    }

    public void imprimirLista() {
        System.out.print("Lista: ");
        for (int i = 0; i < tamanho; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public void adicionarNaPosicao(int posicao, int elemento) {
        if (posicao < 0 || posicao > tamanho || tamanho == array.length) {
            System.out.println("Erro: Posição inválida ou lista cheia!");
            return;
        }
        for (int i = tamanho; i > posicao; i--) {
            array[i] = array[i - 1];
        }
        array[posicao] = elemento;
        tamanho++;
    }
}

public class TesteLista {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ListaArray lista = new ListaArray(5);

        System.out.println("Adicionando elementos à lista:");
        lista.adicionar(10);
        lista.adicionar(20);
        lista.adicionar(30);
        lista.imprimirLista();

        System.out.println("Digite a posição e o valor para adicionar em uma posição específica:");
        int posicao = scanner.nextInt();
        int valor = scanner.nextInt();
        lista.adicionarNaPosicao(posicao, valor);
        lista.imprimirLista();

        System.out.println("Digite a posição do elemento a ser removido:");
        int removerPosicao = scanner.nextInt();
        lista.remover(removerPosicao);
        lista.imprimirLista();

        scanner.close();
    }
}

