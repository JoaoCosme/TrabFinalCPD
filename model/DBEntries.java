package model;

import service.JogadorHashTable;
import service.UserHashTable;

public class DBEntries {
    private JogadorHashTable jogadores;
    private UserHashTable users;
    private static DBEntries dbEntries = null;

    private DBEntries(){}

    private DBEntries(JogadorHashTable jogadores, UserHashTable users) {
        dbEntries = new DBEntries();
        dbEntries.setJogadores(jogadores);
        dbEntries.setUsers(users);
    }

    public static DBEntries get_instance(JogadorHashTable jogadorHashTable, UserHashTable userHashTable){
        if (dbEntries == null){
            dbEntries = new DBEntries(jogadorHashTable,userHashTable);
        }
        return dbEntries;
    }

    public static void set_instance(JogadorHashTable jogadorHashTable, UserHashTable userHashTable){
        dbEntries = new DBEntries(jogadorHashTable,userHashTable);
    }

    public static DBEntries get_instance(){
        return dbEntries;
    }

    public JogadorHashTable getJogadores() {
        return dbEntries.jogadores;
    }

    public void setJogadores(JogadorHashTable jogadores) {
        this.jogadores = jogadores;
    }

    public UserHashTable getUsers() {
        return dbEntries.users;
    }

    public void setUsers(UserHashTable users) {
        this.users = users;
    }
    
}
