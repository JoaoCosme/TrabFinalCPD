package api;

import model.DBEntries;
import model.Jogador;
import service.ArvoreTrie;
import service.utils;

import java.util.ArrayList;
import java.util.Collection;
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
        var jogadoresOrdenados = jogadores.stream().map(playerDb::getJogador).sorted(Jogador::compareTo);

        jogadoresOrdenados.forEach(jogador -> {
            System.out.println(
                    jogador.getSofifaId() + "," +
                    jogador.getShortName() + "," +
                    jogador.getPlayerPositions().toString() + "," +
                    jogador.getGlobalRating() + "," +
                    jogador.getCount()
            );
        });
    }
}