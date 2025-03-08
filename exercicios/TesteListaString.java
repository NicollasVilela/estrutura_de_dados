public class TesteListaString {
    public static void main(String[] args) {
        ListaArrayString lista = new ListaArrayString(4);
        lista.adicionar("Ana");
        lista.adicionar("Bruno");
        lista.adicionar("Carlos");

        lista.imprimirLista();
        
        int posicao = lista.buscar("Bruno");
        if (posicao != -1) {
            System.out.println("Nome encontrado na posição: " + posicao);
        } else {
            System.out.println("Nome não encontrado.");
        }
        
        lista.remover(1);
        lista.imprimirLista();
    }
}
