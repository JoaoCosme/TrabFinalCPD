package service;

import api.*;
import model.*;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.util.Objects.isNull;

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

        final int hashSize = 20000;
        var jogadoresHashTable = new JogadorHashTable(hashSize/2);
        var playerTagHashTable = new TagHashTable(hashSize/2);
        var userHashTable = new UserHashTable(hashSize);
        var positionHashTable = new PositionHashTable(30);
        var listaDeTodasPosicoes = new ArrayList<String>();
        var arvoreTrie = new ArvoreTrie();

        jogadorInfo.nextLine();
        ratingInfo.nextLine();
        tagsInfo.nextLine();

        while (jogadorInfo.hasNext()){
            String[] line = jogadorInfo.nextLine().replaceAll("\"","").split(",");
            var listaDePosicoes = getPosicoes(line);
            var sofifaId = Integer.parseInt(line[0]);
            var name = line[1];
            var jogador = new Jogador(sofifaId,name,listaDePosicoes);


            listaDePosicoes.forEach(
                    posicao -> {
                        if(!listaDeTodasPosicoes.contains(posicao)){
                            listaDeTodasPosicoes.add(posicao);
                        }

                        var positionPlayerList = positionHashTable.getTag(posicao);

                        if (isNull(positionPlayerList)) {
                            var newPositionPlayer = new PositionPlayerList(posicao,sofifaId);
                            positionHashTable.add(newPositionPlayer);
                        } else {
                           positionPlayerList.addPlayer(sofifaId);
                        }
                    }
            );

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
            int sofifaID = Integer.parseInt((tagLine[1]));

            if (tagLine.length > 2) {
                String tag = tagLine[2].toUpperCase();

                var playerTag = playerTagHashTable.getTag(tag);

                if (isNull(playerTag)) {
                    var newTag = new PlayerTag(tag, sofifaID);
                    playerTagHashTable.add(newTag);
                } else {
                    if(playerTag.getSofifaIdList().contains(sofifaID)){
                        continue;
                    }
                    playerTag.addSoFifaId(sofifaID);
                }
            }
        }

        System.out.println("Carregado");

        DBEntries.get_instance(jogadoresHashTable,userHashTable,playerTagHashTable,positionHashTable);

        listaDeTodasPosicoes.forEach(
                posicao -> {
                    var positionPlayerList = positionHashTable.getTag(posicao);
                    QuickSorterId.sort(positionPlayerList.getPlayerList());
                }
        );

        var playerNameSearch = new PlayerNameSearch(arvoreTrie);
        var tagSearch  = new TagSearch();
        var topNSearch = new TopNSearch();
        var userRatesSearch = new UsersRatesSearch();

        var returnSearchOrchestrator = new SearchOrchestrator(playerNameSearch,tagSearch,topNSearch,userRatesSearch);

        jogadorInfo.close();
        ratingInfo.close();
        tagsInfo.close();

        System.out.println(
                "Tempo total = "+Duration.between(now,Instant.now()).toSecondsPart()+ " segundos"
        );

        return returnSearchOrchestrator;
    }

    private static List<String> getPosicoes(String[] linhaCsv){
        List<String> returnList = new ArrayList<>();
        int i = 2;
        while (i < linhaCsv.length) {
            returnList.add(linhaCsv[i].replace(" ",""));
            i++;
        }
        return  returnList;
    }
}