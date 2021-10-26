package model;

import service.JogadorHashTable;
import service.UserHashTable;

public class DBEntries {
    private final JogadorHashTable jogadores;
    private final UserHashTable users;

    public DBEntries(JogadorHashTable jogadores, UserHashTable users){
        this.jogadores = jogadores;
        this.users = users;
    }

    public JogadorHashTable getJogadores() {
        return this.jogadores;
    }

//    public void setJogadores(JogadorHashTable jogadores) {
//        this.jogadores = jogadores;
//    }

    public UserHashTable getUsers() {
        return this.users;
    }
//
//    public void setUsers(UserHashTable users) {
//        this.users = users;
//    }

    public DBEntries get_instance(){
        return this;
    }
    
}
