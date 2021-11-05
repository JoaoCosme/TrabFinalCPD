package service;

import com.sun.jdi.Value;
import model.Jogador;
import model.ValueSofifaIDDTO;

import java.util.ArrayList;
/*--Classe que mapeia VALUE para um SOFIFAID--*/
public class ValueHashTable extends hashTable {
    private ArrayList<ValueSofifaIDDTO> hashTable[];

    public ValueHashTable(int hashTableSize){
        super(hashTableSize);
    }

    public void add(Value value, int sofifaID){
        var valueSofifaId = new ValueSofifaIDDTO(value,sofifaID);
        int indexToAdd = hashValue(valueSofifaId.value.toString());
        super.add(valueSofifaId,indexToAdd);
    }

    public int getJogador(Value value){
        int indexProcurado = hashValue(value.toString());
        return ((ValueSofifaIDDTO) super.getItem(new ValueSofifaIDDTO(value),indexProcurado)).sofifaId;
        }
    }   
