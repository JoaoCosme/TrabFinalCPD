package service;

import api.searchOrchestrator;
import model.Jogador;
import model.User;
import model.UserClassJogador;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SearchOrchestratorAssembler{
    public static searchOrchestrator create() {
        Scanner jogadorInfo = utils.create_scanner("dados/players.csv");
        Scanner ratingInfo = utils.create_scanner("dados/minirating.csv");
//        Scanner tagsInfo = utils.create_scanner("tags.csv");

        if (jogadorInfo == null || ratingInfo == null){ //|| ratingInfo == null || tagsInfo == null){
            System.out.println("Erro ao abrir arquivos!");
            return null;
        }

        var jogadoresHashTable = new JogadorHashTable(30000);
        var userHashTable = new UserHashTable(300000);

        //Passar por headers
        jogadorInfo.nextLine();
        ratingInfo.nextLine();

        while (jogadorInfo.hasNext()){
            var line = jogadorInfo.nextLine().replaceAll("\"","").split(",");
            var listaDePosicoes = getPosicoes(line);
            var sofifaId = Integer.parseInt(line[0]);
            var name = line[1];
            var jogador = new Jogador(sofifaId,name,listaDePosicoes,0,0,null);
            jogadoresHashTable.add(jogador);
        }

        while (ratingInfo.hasNext()){
            var line = ratingInfo.nextLine().split(",");
            var jogador = jogadoresHashTable.getJogador(Integer.parseInt(line[1]));
            var notaUser = Double.parseDouble(line[2]);
            var userId = Integer.parseInt(line[0]);

            jogador.incCount();
            jogador.addClassificao(notaUser);

            var userClassJogador = new UserClassJogador(jogador.getSofifaId(),notaUser);

            var user = userHashTable.getUser(userId);
            if(user!=null){
                user.getJogadoresClassificados().add(userClassJogador);
            }else{
                var listaClassificados = new ArrayList<UserClassJogador>();
                listaClassificados.add(userClassJogador);
                var newUser = new User(userId,listaClassificados);
                userHashTable.add(newUser);
            }
        }


        System.out.println(jogadoresHashTable.getJogador(158023).toString());
        System.out.println(jogadoresHashTable.getJogador(201041).toString());
        System.out.println(jogadoresHashTable.getJogador(223150).toString());
        System.out.println(userHashTable.getUser(12389).toString());

        jogadorInfo.close();
        ratingInfo.close();
//        tagsInfo.close();
        return null;
    }

    private static List<String> getPosicoes(String[] linhaCsv){
        List<String> returnList = new ArrayList<String>();
        for (int i = 2; i < linhaCsv.length; i++) {
            returnList.add(linhaCsv[i]);
        }
        return  returnList;
    }
}