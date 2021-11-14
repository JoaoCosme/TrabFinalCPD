package model;

import com.sun.jdi.PrimitiveValue;
import service.JogadorHashTable;
import service.UserHashTable;

import static java.util.Objects.isNull;

public class DBEntries {
    private final JogadorHashTable jogadores;
    private final UserHashTable users;
    private static DBEntries instanciaUnica;

    private DBEntries(JogadorHashTable jogadores, UserHashTable users){
        this.jogadores = jogadores;
        this.users = users;
    }

    public JogadorHashTable getJogadores() {
        return this.jogadores;
    }

    public UserHashTable getUsers() {
        return this.users;
    }

    public static void get_instance(JogadorHashTable jogadores, UserHashTable users){
        if(isNull(instanciaUnica)){
            instanciaUnica = new DBEntries(jogadores,users);
        }
    }

    public static DBEntries get_instance(){
        return instanciaUnica;
    }
    
}
