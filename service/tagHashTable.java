package service;

import model.PlayerTag;
import model.ValueSofifaIDDTO;

import java.util.ArrayList;
public class TagHashTable extends hashTable {
    public TagHashTable(int hashTableSize){
        super(hashTableSize);
    }

    public void add(PlayerTag playerTag){
        int indexToAdd = hashValue(playerTag.getTag());
        super.add(playerTag,indexToAdd);
    }

    public PlayerTag getTag(String tag){
        int indexProcurado = hashValue(tag);
        return (PlayerTag) super.getItem(new PlayerTag(tag),indexProcurado);
        }
    }   
