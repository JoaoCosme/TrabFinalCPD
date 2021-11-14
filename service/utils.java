package service;

import model.Jogador;
import model.UserClassJogador;

import java.io.File;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

// Classe com funcoes auxiliares
public class utils {
    public static Scanner create_scanner(String nome_do_arquivo) {
        File arquivo = new File(nome_do_arquivo);
        try {
            return new Scanner(arquivo);
        } catch (Exception e) {
            System.out.println("Erro ao abrir arquivo: "+nome_do_arquivo);
            return null;
        }
    }

    public static String removeSpaces(String stringToFilter) {
        String[] arrayDePalavras = stringToFilter.split(" ");
        StringBuilder arrayDeRetorno = new StringBuilder();
        for (String word : arrayDePalavras) {
            if (word.length()>1) {
                arrayDeRetorno.append(word);
            }
        }
        return arrayDeRetorno.toString();
    }

    public static void jogadorSort(List<Jogador> listaAOrdenar){
        for (int i = 0; i < listaAOrdenar.size(); i++) {
            var chave= listaAOrdenar.get(i);
            int j = i-1;

            while(j >=0 && listaAOrdenar.get(j).compareTo(chave) > 0){
                listaAOrdenar.set(j+1,listaAOrdenar.get(j));
                j--;
            }
            listaAOrdenar.set(j+1,chave);
        }
    }
    public static void userClassSort(List<UserClassJogador> listaAOrdenar){
        for (int i = 0; i < listaAOrdenar.size(); i++) {
            var chave= listaAOrdenar.get(i);
            int j = i-1;

            while(j >=0 && listaAOrdenar.get(j).compareTo(chave) > 0){
                listaAOrdenar.set(j+1,listaAOrdenar.get(j));
                j--;
            }
            listaAOrdenar.set(j+1,chave);
        }
    }
}