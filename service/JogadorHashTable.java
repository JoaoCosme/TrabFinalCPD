package service;

import model.Jogador;

import java.util.*;

public class JogadorHashTable extends hashTable {

    public JogadorHashTable(int hashTableSize){
        super(hashTableSize);
    }

    public void add(Jogador jogador){
        int indexToAdd = hashValue(jogador.getSofifaId());
        super.add(jogador,indexToAdd);
    }

    public Jogador getJogador(int sofifaID){
        int indexProcurado = hashValue(sofifaID);
        return (Jogador) super.getItem(new Jogador(sofifaID),indexProcurado);
        }
    }   
