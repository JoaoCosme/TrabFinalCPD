package service;

import model.DBEntries;
import model.Jogador;

import java.util.ArrayList;
import java.util.List;

public class QuickSorterId {
    static JogadorHashTable dadosJogadores = DBEntries.get_instance().getJogadores();

    public static void sort(List<Integer> listaAOrdenar){
        if(listaAOrdenar.isEmpty()){
            return;
        }
        sort(listaAOrdenar,0,listaAOrdenar.size()-1);
    }

    private static void sort(List<Integer> listaAOrdenar,
                             int primeiroIndicie,
                             int ultimoIndice) {
        if (primeiroIndicie < ultimoIndice) {
            var q = particione(primeiroIndicie, ultimoIndice, listaAOrdenar);
            sort(listaAOrdenar, primeiroIndicie, q - 1);
            sort(listaAOrdenar, q + 1, ultimoIndice);
        }
    }
    private static int particione(int primeiroIndicie,
                                  int ultimoIndice,
                                  List<Integer> listaAOrdenar) {
        var indicePivo = getPivo(primeiroIndicie,ultimoIndice,listaAOrdenar);
        swap(listaAOrdenar,indicePivo,ultimoIndice);
        var pivo = dadosJogadores.getJogador(listaAOrdenar.get(ultimoIndice));
        int i = primeiroIndicie-1;

        for (int j = primeiroIndicie; j < ultimoIndice; j++) {
            if (dadosJogadores.getJogador(listaAOrdenar.get(j)).compareTo(pivo) > 0) {
                i++;
                swap(listaAOrdenar,i,j);
            }
        }

        swap(listaAOrdenar,i+1,ultimoIndice);
        return i+1;
    }

    private static void swap(List<Integer> listaAOrdenar, int primeiroIndicie, int segundoIndice) {
        Integer temp;
        temp = listaAOrdenar.get(segundoIndice);
        listaAOrdenar.set(segundoIndice,listaAOrdenar.get(primeiroIndicie));
        listaAOrdenar.set(primeiroIndicie,temp);
    }

    private static int getPivo(int primeiroIndicie,
                               int ultimoIndice,
                               List<Integer> listaAOrdenar) {

        int indiceMeio    = (ultimoIndice-primeiroIndicie)/2;

        var idMeio = listaAOrdenar.get(indiceMeio);
        var primeiroId = listaAOrdenar.get(primeiroIndicie);
        var ultimoId= listaAOrdenar.get(ultimoIndice);

        var listaLocal = new ArrayList<Jogador>();

        listaLocal.add(dadosJogadores.getJogador(primeiroId));
        listaLocal.add(dadosJogadores.getJogador(idMeio));
        listaLocal.add(dadosJogadores.getJogador(ultimoId));

        utils.jogadorSort(listaLocal);

        if (listaLocal.get(1).getSofifaId()==primeiroId) {
            return primeiroIndicie;
        }else if (listaLocal.get(1).getSofifaId()==idMeio) {
            return indiceMeio;
        }else{
            return ultimoIndice;
        }
    }
}
