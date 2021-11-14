package api;

import model.DBEntries;
import service.ArvoreTrie;
import service.QuickSorterJogador;

import java.util.Collections;
import java.util.stream.Collectors;

public class PlayerNameSearch {
    private DBEntries dbEntries = null;
    private ArvoreTrie arvoreTrie = null;

    public PlayerNameSearch(ArvoreTrie arvoreTrie) {
        this.dbEntries = DBEntries.get_instance();
        this.arvoreTrie = arvoreTrie;
    }

    public PlayerNameSearch(){

    }

    public void searchPlayer(String Name){
        var jogadores = (arvoreTrie.keysWithPrefix(Name));

        if (jogadores.isEmpty()){
            System.out.println("Nenhum jogador encontrado!");
            return;
        }

        var playerDb = dbEntries.getJogadores();
        var listaJogadores = jogadores.stream()
                .map(playerDb::getJogador)
                .collect(Collectors.toList());

        QuickSorterJogador.sort(listaJogadores);

        System.out.printf(
                "%8s %40s %20s %12s %5s \n",
                "sofifaID",
                "ShortName",
                "PlayerPositions",
                "GlobalRating",
                "Count"
        );

        listaJogadores.forEach(jogador -> {
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