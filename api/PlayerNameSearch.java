package api;

import model.DBEntries;
import service.ArvoreTrie;

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
        arvoreTrie.keysWithPrefix(Name).forEach(value -> {
            System.out.println(playerDb.getJogador(Integer.parseInt(value)).toString());
        });
    }
}