package controller;

import java.util.ArrayList;
import model.Automovel;
import model.AutomovelRepository;

public class AutomovelController {

	private ArrayList<Automovel> automoveis;
	private AutomovelRepository automovelRepository;

	public AutomovelController() {
		this.automovelRepository = new AutomovelRepository();
		this.automoveis = automovelRepository.carregarAutomoveis();
	}

	public ArrayList<Automovel> listarAutomoveis() {
		return new ArrayList<>(automoveis);
	}

	public boolean adicionarAutomovel(String placa, String modelo, String marca, int ano, double valor) {
		if (buscarAutomovelPorPlaca(placa) != null) {
			return false;
		}

		Automovel automovel = new Automovel(placa, modelo, marca, ano, valor);
		automoveis.add(automovel);
		automovelRepository.salvarArquivo(automoveis);
		return true;
	}

	public boolean alterarAutomovel(String placa, String novoModelo, double novoValor) {
		Automovel automovel = buscarAutomovelPorPlaca(placa);
		if (automovel != null) {
			automovel.setModelo(novoModelo);
			automovel.setValor(novoValor);
			automovelRepository.salvarArquivo(automoveis);
			return true;
		}
		return false;
	}

	public boolean excluirAutomovel(String placa) {
		Automovel automovel = buscarAutomovelPorPlaca(placa);
		if (automovel != null) {
			automoveis.remove(automovel);
			automovelRepository.salvarArquivo(automoveis);
			return true;
		}
		return false;
	}

	private Automovel buscarAutomovelPorPlaca(String placa) {
		for (Automovel automovel : automoveis) {
			if (automovel.getPlaca().equals(placa)) {
				return automovel;
			}
		}
		return null;
	}
}
