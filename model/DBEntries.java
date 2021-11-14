package model;

import service.JogadorHashTable;
import service.UserHashTable;
import service.PositionHashTable;
import service.TagHashTable;

import static java.util.Objects.isNull;

public class DBEntries {
    private final JogadorHashTable jogadores;
    private final UserHashTable users;
    private final TagHashTable tagHashTable;
    private final PositionHashTable positionHashTable;
    private static DBEntries instanciaUnica;

    private DBEntries(JogadorHashTable jogadores,
                      UserHashTable users,
                      TagHashTable tagHashTable,
                      PositionHashTable positionHashTable){
        this.jogadores = jogadores;
        this.users = users;
        this.tagHashTable = tagHashTable;
        this.positionHashTable = positionHashTable;
    }

    public JogadorHashTable getJogadores() {
        return this.jogadores;
    }

    public UserHashTable getUsers() {
        return this.users;
    }

    public TagHashTable getTagHashTable(){return this.tagHashTable;}

    public static void get_instance(JogadorHashTable jogadores,
                                    UserHashTable users,
                                    TagHashTable tagHashTable,
                                    PositionHashTable positionHashTable){
        if(isNull(instanciaUnica)){
            instanciaUnica = new DBEntries(jogadores,users,tagHashTable,positionHashTable);
        }
    }

    public static DBEntries get_instance(){
        return instanciaUnica;
    }
}
