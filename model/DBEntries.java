package model;

import com.sun.jdi.PrimitiveValue;
import service.JogadorHashTable;
import service.UserHashTable;
import service.tagHashTable;

import static java.util.Objects.isNull;

public class DBEntries {
    private final JogadorHashTable jogadores;
    private final UserHashTable users;
    private final tagHashTable tagHashTable;
    private static DBEntries instanciaUnica;

    private DBEntries(JogadorHashTable jogadores, UserHashTable users, tagHashTable tagHashTable){
        this.jogadores = jogadores;
        this.users = users;
        this.tagHashTable = tagHashTable;
    }

    public JogadorHashTable getJogadores() {
        return this.jogadores;
    }

    public UserHashTable getUsers() {
        return this.users;
    }

    public tagHashTable getTagHashTable(){return this.tagHashTable;}

    public static void get_instance(JogadorHashTable jogadores, UserHashTable users, tagHashTable tagHashTable){
        if(isNull(instanciaUnica)){
            instanciaUnica = new DBEntries(jogadores,users,tagHashTable);
        }
    }

    public static DBEntries get_instance(){
        return instanciaUnica;
    }
}
