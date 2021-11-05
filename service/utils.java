package service;

import model.Jogador;
import model.UserClassJogador;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import java.util.stream.Collectors;

// Classe com funcoes auxiliares
public class utils {
    public static String[] remove_nulls(String[] array_com_nulls) {
        return Arrays.stream(array_com_nulls)
            .filter(Objects::nonNull)
            .toArray(String[]::new);
    }


    public static Scanner create_scanner(String nome_do_arquivo) {
        File arquivo = new File(nome_do_arquivo);
        try {
            return new Scanner(arquivo);
        } catch (Exception e) {
            System.out.println("Erro ao abrir arquivo: "+nome_do_arquivo);
            return null;
        }
    }

    public static PrintWriter create_escritor(String nome_do_arquivo) {
        File lo_arquivo_de_saida = new File(nome_do_arquivo);
        try {
            lo_arquivo_de_saida.createNewFile();
            return new PrintWriter(lo_arquivo_de_saida);
        } catch (IOException e) {
            System.out.println("Erro ao criar arquivo: "+nome_do_arquivo);
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

    public static void reverseSort(List<UserClassJogador> objects){
        Collections.sort(objects);
        Collections.reverse(objects);
        // Talvez criar uma estrutura sofifaID+rating e usar a mesma para ordenar tudo que preciso?
    }


    public static void sort(List<Jogador> jogadoresOrdenados) {
        jogadoresOrdenados.stream().sorted().collect(Collectors.toList());
    }
}