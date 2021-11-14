package api;

import model.DBEntries;
import service.ArvoreTrie;
import service.QuickSorterJogador;

import java.util.Collections;
import java.util.stream.Collectors;

public class PlayerNameSearch {
    private DBEntries dbEntries = null;
    private ArvoreTrie arvoreTrie = null;

    public PlayerNameSearch(DBEntries dbEntries,ArvoreTrie arvoreTrie) {
        this.dbEntries = dbEntries;
        this.arvoreTrie = arvoreTrie;
    }

    public PlayerNameSearch(){

    }

    public void searchPlayer(String Name){
        var playerDb = dbEntries.getJogadores();
        var jogadores = (arvoreTrie.keysWithPrefix(Name));
        var jogadoresOrdenados = jogadores.stream().map(playerDb::getJogador).collect(Collectors.toList());

        QuickSorterJogador.sort(jogadoresOrdenados);

        System.out.printf(
                "%8s %40s %20s %12s %5s \n",
                "sofifaID",
                "ShortName",
                "PlayerPositions",
                "GlobalRating",
                "Count"
        );

        jogadoresOrdenados.forEach(jogador -> {
            System.out.printf(
                    "%8d %40s %20s %12f %5d \n",
                    jogador.getSofifaId(),
                    jogador.getShortName(),
                    jogador.getPlayerPositions().toString(),
                    jogador.getGlobalRating(),
                    jogador.getCount()
            );
        });


    }
}