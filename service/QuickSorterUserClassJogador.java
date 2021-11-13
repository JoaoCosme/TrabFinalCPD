package service;

import model.UserClassJogador;

import java.util.ArrayList;
import java.util.List;

public class QuickSorterUserClassJogador {
    public static void sort(List<UserClassJogador> listaAOrdenar){
        if(listaAOrdenar.isEmpty()){
            return;
        }
        sort(listaAOrdenar,0,listaAOrdenar.size()-1);
    }

    private static void sort(List<UserClassJogador> listaAOrdenar,
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
                           List<UserClassJogador> listaAOrdenar) {
        var indicePivo = getPivo(primeiroIndicie,ultimoIndice,listaAOrdenar);
        swap(listaAOrdenar,indicePivo,ultimoIndice);
        var pivo = listaAOrdenar.get(ultimoIndice);
        int i = primeiroIndicie-1;

        for (int j = primeiroIndicie; j < ultimoIndice; j++) {
            if (listaAOrdenar.get(j).compareTo(pivo) > 0) {
                i++;
                swap(listaAOrdenar,i,j);
            }
        }

        swap(listaAOrdenar,i+1,ultimoIndice);
        return i+1;
    }

    private static void swap(List<UserClassJogador> listaAOrdenar, int primeiroIndicie, int segundoIndice) {
        UserClassJogador temp;
        temp = listaAOrdenar.get(segundoIndice);
        listaAOrdenar.set(segundoIndice,listaAOrdenar.get(primeiroIndicie));
        listaAOrdenar.set(primeiroIndicie,temp);
    }

    private static int getPivo(int primeiroIndicie,
                               int ultimoIndice,
                               List<UserClassJogador> listaAOrdenar) {

        int indiceMeio    = (ultimoIndice-primeiroIndicie)/2;

        var valorMeio = listaAOrdenar.get(indiceMeio);
        var primeiroValor = listaAOrdenar.get(primeiroIndicie);
        var ultimoValor= listaAOrdenar.get(ultimoIndice);

        var listaLocal = new ArrayList<UserClassJogador>();

        listaLocal.add(primeiroValor);
        listaLocal.add(ultimoValor);
        listaLocal.add(valorMeio);

        utils.userClassSort(listaLocal);

        if (listaLocal.get(1)==primeiroValor) {
            return primeiroIndicie;
        }else if (listaLocal.get(1)==valorMeio) {
            return indiceMeio;
        }else{
            return ultimoIndice;
        }
    }
}
