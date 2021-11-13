package service;

import api.*;
import com.sun.jdi.Value;
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
        Scanner ratingInfo = utils.create_scanner("dados/minirating.csv");
        Scanner tagsInfo = utils.create_scanner("dados/tags.csv");

        if (jogadorInfo == null || ratingInfo == null || tagsInfo == null){
            System.out.println("Erro ao abrir arquivos!");
            return null;
        }

        final int hashSize = 20000;
        var jogadoresHashTable = new JogadorHashTable(hashSize/2);
        var userHashTable = new UserHashTable(hashSize);
        var arvoreTrie = new ArvoreTrie();
        // Talvez tenha que criar hash para rating e count e tag
        // TAG:List<Jogadores>
        // Jogador:GLobalRating
        // Jogador:Count

        //Passar por headers
        //Talvez ler eles para saber o index de cada coisa? QOL
        jogadorInfo.nextLine();
        ratingInfo.nextLine();
        tagsInfo.nextLine();

        while (jogadorInfo.hasNext()){
            String[] line = jogadorInfo.nextLine().replaceAll("\"","").split(",");
            var listaDePosicoes = getPosicoes(line);
            var sofifaId = Integer.parseInt(line[0]);
            var name = line[1];
            var jogador = new Jogador(sofifaId,name,listaDePosicoes);

            jogadoresHashTable.add(jogador);
            arvoreTrie.put(name,sofifaId);
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
                user.addJogadoresClassificados(userClassJogador);
            }else{
                var newUser = new User(userId, List.of(userClassJogador));
                userHashTable.add(newUser);
            }
        }

        while (tagsInfo.hasNext()){
            var tagLine = tagsInfo.nextLine().split(",");
            var jogador = jogadoresHashTable.getJogador(Integer.parseInt(tagLine[1]));
            if(tagLine.length>2)
                jogador.addTag(tagLine[2]);
        }


        System.out.println(jogadoresHashTable.getJogador(158023).toString());
        // Testar userHashTable
        System.out.println(userHashTable.getUser(1000));

        System.out.println("Carregado");

        var dbEntries = new DBEntries(jogadoresHashTable,userHashTable);

        var playerNameSearch = new PlayerNameSearch(dbEntries.get_instance(),arvoreTrie);
//        var tagSearch  = new TagSearch(dbEntries.get_instance());
//        var topNSearch = new TopNSearch(dbEntries.get_instance());
//        var userRatesSearch = new UsersRatesSearch(dbEntries.get_instance());
        var tagSearch  = new TagSearch();
        var topNSearch = new TopNSearch();
        var userRatesSearch = new UsersRatesSearch(dbEntries.get_instance());

        var returnSearchOrchestrator = new SearchOrchestrator(playerNameSearch,tagSearch,topNSearch,userRatesSearch);

        jogadorInfo.close();
        ratingInfo.close();
        tagsInfo.close();

        System.out.println(
                "Tempo total ="+Duration.between(now,Instant.now()).toSecondsPart()
        );

        return returnSearchOrchestrator;
    }

    private static List<String> getPosicoes(String[] linhaCsv){
        List<String> returnList = new ArrayList<>();
        int i = 2;
        while (i < linhaCsv.length) {
            returnList.add(linhaCsv[i]);
            i++;
        }
        return  returnList;
    }
}