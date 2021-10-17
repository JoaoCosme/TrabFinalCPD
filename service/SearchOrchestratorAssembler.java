package service;

import api.*;
import model.DBEntries;
import model.Jogador;
import model.User;
import model.UserClassJogador;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SearchOrchestratorAssembler{
    public static SearchOrchestrator create() {
        Instant now = Instant.now();
        Scanner jogadorInfo = utils.create_scanner("dados/players.csv");
        Scanner ratingInfo = utils.create_scanner("dados/rating.csv");
        Scanner tagsInfo = utils.create_scanner("dados/tags.csv");

        if (jogadorInfo == null || ratingInfo == null || tagsInfo == null){
            System.out.println("Erro ao abrir arquivos!");
            return null;
        }

        final int hashSize = 200000;
        var jogadoresHashTable = new JogadorHashTable(hashSize/2);
        var userHashTable = new UserHashTable(hashSize);
        // Talvez tenha que criar hash para rating e count e tag
        // TAG:List<Jogadores>
        // Jogador:GLobalRating
        // Jogador:Count

        //Passar por headers
        jogadorInfo.nextLine();
        ratingInfo.nextLine();
        tagsInfo.nextLine();

        while (jogadorInfo.hasNext()){
            var line = jogadorInfo.nextLine().replaceAll("\"","").split(",");
            var listaDePosicoes = getPosicoes(line);
            var sofifaId = Integer.parseInt(line[0]);
            var name = line[1];
            var jogador = new Jogador(sofifaId,name,listaDePosicoes);

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

        while (tagsInfo.hasNext()){
            var tagLine = tagsInfo.nextLine().split(",");
            var jogador = jogadoresHashTable.getJogador(Integer.parseInt(tagLine[1]));
            if(tagLine.length>2)
                jogador.addTag(tagLine[2]);
        }


//        System.out.println(jogadoresHashTable.getJogador(158023).toString());

        var dataBase = new DBEntries(jogadoresHashTable,userHashTable);

        var playerNameSearch = new PlayerNameSearch();
        var tagSearch  = new TagSearch();
        var topNSearch = new TopNSearch();
        var userRatesSearch = new UsersRatesSearch();

        var returnSearchOrchestrator = new SearchOrchestrator(playerNameSearch,tagSearch,topNSearch,userRatesSearch);

        jogadorInfo.close();
        ratingInfo.close();
        tagsInfo.close();

        System.out.println(Duration.between(now,Instant.now()).toSecondsPart());

        return returnSearchOrchestrator;
    }

    private static List<String> getPosicoes(String[] linhaCsv){
        List<String> returnList = new ArrayList<String>();
        for (int i = 2; i < linhaCsv.length; i++) {
            returnList.add(linhaCsv[i]);
        }
        return  returnList;
    }
}