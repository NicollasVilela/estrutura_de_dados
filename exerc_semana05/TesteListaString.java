import java.util.Scanner;

class ListaArrayString {
    private String[] array;
    private int tamanho;

    public ListaArrayString(int capacidade) {
        this.array = new String[capacidade];
        this.tamanho = 0;
    }

    public void adicionar(String elemento) {
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
        System.out.print("Lista de Nomes: ");
        for (int i = 0; i < tamanho; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public void buscarNome(String nome) {
        for (int i = 0; i < tamanho; i++) {
            if (array[i].equalsIgnoreCase(nome)) {
                System.out.println("Nome encontrado: " + array[i]);
                return;
            }
        }
        System.out.println("Nome não encontrado.");
    }
}

public class TesteListaString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ListaArrayString lista = new ListaArrayString(4);

        // Adicionando nomes à lista
        System.out.println("Digite 3 nomes para adicionar à lista:");
        for (int i = 0; i < 3; i++) {
            lista.adicionar(scanner.nextLine());
        }
        lista.imprimirLista();

        // Remover um nome
        System.out.println("Digite a posição do nome a ser removido:");
        int posicao = scanner.nextInt();
        lista.remover(posicao);
        lista.imprimirLista();

        // Buscar um nome
        scanner.nextLine(); // Limpar o buffer
        System.out.println("Digite um nome para buscar:");
        String nomeBusca = scanner.nextLine();
        lista.buscarNome(nomeBusca);

        scanner.close();
    }
}

