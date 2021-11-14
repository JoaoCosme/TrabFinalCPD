package service;

import com.sun.jdi.Value;
import model.Jogador;
import model.PlayerTag;
import model.ValueSofifaIDDTO;

import java.util.ArrayList;
/*--Classe que mapeia VALUE para um SOFIFAID--*/
public class tagHashTable extends hashTable {
    private ArrayList<ValueSofifaIDDTO> hashTable[];

    public tagHashTable(int hashTableSize){
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
