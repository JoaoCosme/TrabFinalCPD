package service;

import model.Jogador;

import java.util.*;

public class hashTable {
    protected int hashtablesize;
    private ArrayList<Object> hashTable[];

    public hashTable(){}

    public hashTable(int hashtablesize) {
        this.hashTable = new ArrayList[hashtablesize];
        this.hashtablesize = hashtablesize;

        for (int i = 0; i < hashtablesize; i++) {
            hashTable[i] = new ArrayList<Object>();
        }
    }
    protected int hashValue(String stringToHash) {
        int string2int = 0;
        for (int i = 0; i < stringToHash.length(); i++) {
            string2int = (31 * string2int + stringToHash.charAt(i))%hashtablesize;
        }
        return string2int;
    }

    protected int hashValue(int valueToHash) {
        var hashValue = (31*valueToHash%hashtablesize);
        return (int)hashValue;
    }

    protected void add(Object object,int indexToAdd){
        int indexSecundario = 0;
        boolean isAdded = false;

        while (!isAdded) {
            if(hashTable[indexToAdd].isEmpty() || hashTable[indexToAdd].get(indexSecundario)==null){
                hashTable[indexToAdd].add(indexSecundario, object);
                isAdded = true;
            }else{
                indexSecundario++;
                if (indexSecundario == hashTable[indexToAdd].size()) {
                    hashTable[indexToAdd].add(indexSecundario, object);
                    isAdded = true;
                }
            }
        }
    }

    protected Object getItem(Object itemProcurado, int indexProcurado){
        int indexSecundario = 0;
        Object itemEncontrado = null;
        boolean isFound = false;

        if(!hashTable[indexProcurado].isEmpty()){
            while (!isFound) {
                if(hashTable[indexProcurado].get(indexSecundario).equals(itemProcurado)){
                    itemEncontrado = hashTable[indexProcurado].get(indexSecundario);
                    isFound = true;
                }else{
                    indexSecundario++;
                    if (indexSecundario == hashTable[indexProcurado].size()) {
                        return null;
                    }
                }
            }
        }

        return itemEncontrado;
    }

}