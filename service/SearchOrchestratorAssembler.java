package service;

import api.searchOrchestrator;
import model.Jogador;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SearchOrchestratorAssembler{
    public static searchOrchestrator create() {
        Scanner jogadorInfo = utils.create_scanner("dados/players.csv");
//        Scanner ratingInfo = utils.create_scanner("rating.csv");
//        Scanner tagsInfo = utils.create_scanner("tags.csv");

        if (jogadorInfo == null){ //|| ratingInfo == null || tagsInfo == null){
            System.out.println("Erro ao abrir arquivos!");
            return null;
        }

        var jogadoresHashTable = new JogadorHashTable(30000);

//        jogadorInfo.useDelimiter(",");
//        ratingInfo.useDelimiter(",");
//        tagsInfo.useDelimiter(",");

        jogadorInfo.nextLine();

        while (jogadorInfo.hasNext()){
            var line = jogadorInfo.nextLine().split(",");
            var jogador = new Jogador(Integer.parseInt(line[0]),line[1], Arrays.stream(line[2].split(",")).collect(Collectors.toList()),0,0,null);
            jogadoresHashTable.add(jogador);
        }


        System.out.println(jogadoresHashTable.getJogador(158023).getShortName());


        jogadorInfo.close();
//        ratingInfo.close();
//        tagsInfo.close();
        return null;
    }
}