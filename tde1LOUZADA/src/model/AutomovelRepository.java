package model;

import java.io.*;
import java.util.ArrayList;

public class AutomovelRepository {

    private final String ARQUIVO_AUTOMOVEL = "automoveis.txt";

    public void salvarArquivo(ArrayList<Automovel> automoveis) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARQUIVO_AUTOMOVEL))) {
            for (Automovel automovel : automoveis) {
                writer.write(automovel.toFileString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar automóveis: " + e.getMessage());
        }
    }

    public ArrayList<Automovel> carregarAutomoveis() {
        ArrayList<Automovel> automoveis = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(ARQUIVO_AUTOMOVEL))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                automoveis.add(Automovel.fromFileString(linha));
            }
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado. Será criado ao salvar novos automóveis.");
        } catch (IOException e) {
            System.out.println("Erro ao carregar automóveis: " + e.getMessage());
        }
        return automoveis;
    }
}
