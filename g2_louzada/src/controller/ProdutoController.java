package controller;

import model.Produto;
import java.util.ArrayList;
import java.util.Collections;

public class ProdutoController {

	private ArrayList<Produto> produtos;

	public ProdutoController() {
		produtos = new ArrayList<>();
	}

	public void adicionarProduto(int id, String nome, double preco) {
		Produto produto = new Produto(id, nome, preco);
		produtos.add(produto);
		Collections.sort(produtos, (p1, p2) -> Integer.compare(p1.getId(), p2.getId()));
	}

	public Produto buscarProduto(int id) {
		for (Produto produto : produtos) {
			if (produto.getId() == id) {
				return produto;
			}
		}
		return null;
	}

	public ArrayList<Produto> listarProdutos() {
		return produtos;
	}
}
