import java.util.*;

public class JogadorHashTable extends hashTable {
    private ArrayList<Jogador> hashTable[];


    public JogadorHashTable(ArrayList<Jogador> hashTabl[], int hashtablesize) {
        this.hashTable = new ArrayList[hashtablesize];
        this.hashtablesize = hashtablesize;
        
        for (ArrayList<Jogador> listaDehashTable : hashTable) {
            listaDehashTable = new ArrayList<Jogador>();
        }
    }

    public void add(Jogador jogador){
        int indexToAdd = hashValue(jogador.getSofifaId());
        int indexSecundario = 0;
        boolean isAdded = false;
        
        while (!isAdded) {
            if(hashTable[indexToAdd].isEmpty() || hashTable[indexToAdd].get(indexSecundario)==null){
                hashTable[indexToAdd].add(indexSecundario, jogador);
                isAdded = true;
            }else{
                indexSecundario++;
                if (indexSecundario == hashTable[indexToAdd].size()) {
                    hashTable[indexToAdd].add(indexSecundario, jogador);
                    isAdded = true;
                }
            }
        }
    }

    public Jogador getJogador(int sofifaID){
        int indexProcurado = hashValue(sofifaID);
        int indexSecundario = 0;
        Jogador jogadorBuscado = null;
        boolean isFound = false;

        if(!hashTable[indexProcurado].isEmpty()){
            while (!isFound) {
                if(hashTable[indexProcurado].get(indexSecundario).getSofifaId() == sofifaID){
                    jogadorBuscado = hashTable[indexProcurado].get(indexProcurado);
                    isFound = true;
                }else{
                    indexSecundario++;
                    if (indexSecundario == hashTable[indexProcurado].size()) {
                        break;
                    }
                }    
            }
        }
        
        return jogadorBuscado;
    }   
}