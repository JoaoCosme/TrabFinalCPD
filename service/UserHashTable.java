package service;

import model.User;

import java.util.ArrayList;

public class UserHashTable extends hashTable{
    private ArrayList<User> hashTable[];


    public UserHashTable(ArrayList<User> hashTabl[], int hashtablesize) {
        this.hashTable = new ArrayList[hashtablesize];
        this.hashtablesize = hashtablesize;
        
        for (ArrayList<User> listaDehashTable : hashTable) {
            listaDehashTable = new ArrayList<User>();
        }
    }

    public void add(User User){
        int indexToAdd = hashValue(User.getId());
        int indexSecundario = 0;
        boolean isAdded = false;
        
        while (!isAdded) {
            if(hashTable[indexToAdd].isEmpty() || hashTable[indexToAdd].get(indexSecundario)==null){
                hashTable[indexToAdd].add(indexSecundario, User);
                isAdded = true;
            }else{
                indexSecundario++;
                if (indexSecundario == hashTable[indexToAdd].size()) {
                    hashTable[indexToAdd].add(indexSecundario, User);
                    isAdded = true;
                }
            }
        }
    }

    public User getUser(int sofifaID){
        int indexProcurado = hashValue(sofifaID);
        int indexSecundario = 0;
        User UserBuscado = null;
        boolean isFound = false;

        if(!hashTable[indexProcurado].isEmpty()){
            while (!isFound) {
                if(hashTable[indexProcurado].get(indexSecundario).getId() == sofifaID){
                    UserBuscado = hashTable[indexProcurado].get(indexProcurado);
                    isFound = true;
                }else{
                    indexSecundario++;
                    if (indexSecundario == hashTable[indexProcurado].size()) {
                        break;
                    }
                }    
            }
        }
        
        return UserBuscado;
    } 
}
