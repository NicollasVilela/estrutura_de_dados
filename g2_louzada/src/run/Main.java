package run;

import java.util.Scanner;

import controller.ProdutoController;
import model.Produto;
import view.ProdutoView;

public class Main {
	public static void main(String[] args) {
		ProdutoController controller = new ProdutoController();
		ProdutoView view = new ProdutoView();

		Scanner scanner = new Scanner(System.in);
		int opcao;

		do {
			view.exibirMenu();
			System.out.print("Escolha: ");
			opcao = scanner.nextInt();

			switch (opcao) {
			case 1:
				view.receberDadosProduto();
				break;

			case 2:
				int idBusca = view.receberIdBusca();
				Produto produto = controller.buscarProduto(idBusca);
				view.exibirProduto(produto);
				break;

			case 3:
				view.exibirListaProdutos(controller.listarProdutos());
				break;

			case 0:
				System.out.println("Saindo do sistema...");
				break;

			default:
				System.out.println("Opção inválida. Tente novamente.");
			}
		} while (opcao != 0);

		scanner.close();
	}
}
