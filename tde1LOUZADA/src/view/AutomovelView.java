package view;

import java.util.InputMismatchException;
import java.util.Scanner;
import controller.AutomovelController;
import model.Automovel;

public class AutomovelView {

    private AutomovelController controller;
    private Scanner scanner;

    public AutomovelView(AutomovelController controller) {
        this.controller = controller;
        this.scanner = new Scanner(System.in);
    }

    public void exibirMenu() {
        int opcao;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Adicionar Automóvel");
            System.out.println("2. Listar Automóveis");
            System.out.println("3. Alterar Automóvel");
            System.out.println("4. Excluir Automóvel");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            opcao = capturarInteiro();

            switch (opcao) {
                case 1 -> adicionarAutomovel();
                case 2 -> listarAutomoveis();
                case 3 -> alterarAutomovel();
                case 4 -> excluirAutomovel();
                case 0 -> System.out.println("Encerrando o programa.");
                default -> System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);
    }

    private void adicionarAutomovel() {
        String placa = capturarString("Placa do Automóvel: ");
        String modelo = capturarString("Modelo do Automóvel: ");
        String marca = capturarString("Marca do Automóvel: ");
        int ano = capturarInteiro("Ano do Automóvel: ");
        double valor = capturarDouble("Valor do Automóvel: ");
        controller.adicionarAutomovel(placa, modelo, marca, ano, valor);
        System.out.println("Automóvel adicionado com sucesso!");
    }

    private void listarAutomoveis() {
        for (Automovel a : controller.listarAutomoveis()) {
            System.out.println("Placa: " + a.getPlaca() + ", Modelo: " + a.getModelo() +
                    ", Marca: " + a.getMarca() + ", Ano: " + a.getAno() + ", Valor: R$" + a.getValor());
        }
    }

    private void alterarAutomovel() {
        String placa = capturarString("Placa do Automóvel a alterar: ");
        String novoModelo = capturarString("Novo modelo: ");
        double novoValor = capturarDouble("Novo valor: ");

        if (controller.alterarAutomovel(placa, novoModelo, novoValor)) {
            System.out.println("Automóvel alterado com sucesso!");
        } else {
            System.out.println("Automóvel com placa " + placa + " não encontrado.");
        }
    }

    private void excluirAutomovel() {
        String placa = capturarString("Placa do Automóvel a excluir: ");
        if (controller.excluirAutomovel(placa)) {
            System.out.println("Automóvel excluído com sucesso!");
        } else {
            System.out.println("Automóvel com placa " + placa + " não encontrado.");
        }
    }

    private int capturarInteiro() {
        return capturarInteiro(null);
    }

    private int capturarInteiro(String mensagem) {
        int valor = 0;
        boolean valido;
        do {
            try {
                if (mensagem != null) System.out.print(mensagem);
                valor = scanner.nextInt();
                valido = true;
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Insira um número inteiro.");
                valido = false;
                scanner.nextLine();
            }
        } while (!valido);
        scanner.nextLine();
        return valor;
    }

    private double capturarDouble(String mensagem) {
        double valor = 0.0;
        boolean valido;
        do {
            try {
                System.out.print(mensagem);
                valor = scanner.nextDouble();
                valido = true;
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Insira um número decimal.");
                valido = false;
                scanner.nextLine();
            }
        } while (!valido);
        scanner.nextLine();
        return valor;
    }

    private String capturarString(String mensagem) {
        System.out.print(mensagem);
        return scanner.nextLine();
    }
}
