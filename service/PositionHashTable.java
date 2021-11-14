package service;

import model.PositionPlayerList;

public class PositionHashTable extends hashTable {
    public PositionHashTable(int hashTableSize){
        super(hashTableSize);
    }

    public void add(PositionPlayerList positionPlayerList){
        int indexToAdd = hashValue(positionPlayerList.getPosition());
        super.add(positionPlayerList,indexToAdd);
    }

    public PositionPlayerList getTag(String tag){
        int indexProcurado = hashValue(tag);
        return (PositionPlayerList) super.getItem(new PositionPlayerList(tag),indexProcurado);
        }
    }   
