package view;

import java.util.ArrayList;
import java.util.Scanner;

import controller.ProdutoController;
import model.Produto;

public class ProdutoView {

	public void exibirMenu() {
		System.out.println("""
				    === Menu Produtos ===
				    1 - Adicionar Produto
				    2 - Buscar Produto por ID
				    3 - Listar Produtos
				    0 - Sair
				""");
	}

	public void exibirProduto(Produto produto) {
		if (produto != null) {
			System.out.println("Produto encontrado: " + produto);
		} else {
			System.out.println("Produto não encontrado.");
		}
	}

	public void exibirListaProdutos(ArrayList<Produto> produtos) {
		if (produtos.isEmpty()) {
			System.out.println("Nenhum produto cadastrado.");
		} else {
			for (Produto p : produtos) {
				System.out.println(p);
			}
		}
	}

	public void receberDadosProduto() {
		System.out.print("ID: ");
		int id = new Scanner(System.in).nextInt();
		System.out.print("Nome: ");
		String nome = new Scanner(System.in).nextLine();
		System.out.print("Preço: ");
		double preco = new Scanner(System.in).nextDouble();

		new ProdutoController().adicionarProduto(id, nome, preco);
	}

	public int receberIdBusca() {
		System.out.print("Digite o ID do produto para buscar: ");
		return new Scanner(System.in).nextInt();
	}
}
