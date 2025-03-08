import java.util.ArrayList;
import java.util.List;

class Produto {
    private int codigo;
    private String nome;
    private int quantidade;

    public Produto(int codigo, String nome, int quantidade) {
        this.codigo = codigo;
        this.nome = nome;
        this.quantidade = quantidade;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    @Override
    public String toString() {
        return "Produto{codigo=" + codigo + ", nome='" + nome + "', quantidade=" + quantidade + "}";
    }
}

class Estoque {
    private List<Produto> produtos;

    public Estoque() {
        this.produtos = new ArrayList<>();
    }

    public void adicionarProduto(int codigo, String nome, int quantidade) {
        // Verificar se o produto já existe
        for (Produto produto : produtos) {
            if (produto.getCodigo() == codigo) {
                System.out.println("Produto com código " + codigo + " já existe!");
                return;
            }
        }
        // Adicionar novo produto
        Produto novoProduto = new Produto(codigo, nome, quantidade);
        produtos.add(novoProduto);
        System.out.println("Produto " + nome + " adicionado com sucesso!");
    }

    public void removerProduto(int codigo) {
        // Buscar e remover produto
        for (Produto produto : produtos) {
            if (produto.getCodigo() == codigo) {
                produtos.remove(produto);
                System.out.println("Produto " + produto.getNome() + " removido com sucesso!");
                return;
            }
        }
        System.out.println("Produto com código " + codigo + " não encontrado!");
    }

    public Produto buscarPorCodigo(int codigo) {
        // Buscar produto pelo código
        for (Produto produto : produtos) {
            if (produto.getCodigo() == codigo) {
                return produto;
            }
        }
        System.out.println("Produto com código " + codigo + " não encontrado!");
        return null;
    }

    public List<Produto> buscarPorNome(String nome) {
        // Buscar produtos pelo nome
        List<Produto> encontrados = new ArrayList<>();
        for (Produto produto : produtos) {
            if (produto.getNome().toLowerCase().contains(nome.toLowerCase())) {
                encontrados.add(produto);
            }
        }
        return encontrados.isEmpty() ? null : encontrados;
    }

    public void listarProdutos() {
        // Listar todos os produtos
        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto no estoque.");
        } else {
            for (Produto produto : produtos) {
                System.out.println(produto);
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // Criando uma instância do estoque
        Estoque estoque = new Estoque();

        // Adicionando produtos
        estoque.adicionarProduto(1, "Camiseta", 50);
        estoque.adicionarProduto(2, "Calça", 30);
        estoque.adicionarProduto(3, "Tênis", 20);

        // Listando todos os produtos
        System.out.println("\nLista de produtos no estoque:");
        estoque.listarProdutos();

        // Buscando produto pelo código
        System.out.println("\nBuscando produto pelo código 2:");
        Produto produto = estoque.buscarPorCodigo(2);
        if (produto != null) {
            System.out.println(produto);
        }

        // Buscando produto pelo nome
        System.out.println("\nBuscando produtos com o nome 'Camiseta':");
        List<Produto> produtosEncontrados = estoque.buscarPorNome("Camiseta");
        if (produtosEncontrados != null) {
            for (Produto p : produtosEncontrados) {
                System.out.println(p);
            }
        } else {
            System.out.println("Nenhum produto encontrado.");
        }

        // Removendo um produto
        System.out.println("\nRemovendo produto com código 2:");
        estoque.removerProduto(2);

        // Listando os produtos após remoção
        System.out.println("\nLista de produtos após remoção:");
        estoque.listarProdutos();
    }
}
