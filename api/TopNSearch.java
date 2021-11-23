package api;

import model.DBEntries;

import static java.util.Objects.isNull;

public class TopNSearch {
    private final DBEntries dbEntries;

    public TopNSearch() {
        this.dbEntries = DBEntries.get_instance();
    }
    
    public void search(Integer maxJogadores, String posicao) {
        var posCopia = posicao.toUpperCase();
        posCopia = posCopia.replace("'","");

        var listaPosicao = dbEntries.getPositionHashTable().getTag(posCopia);
        if (isNull(listaPosicao)){
            System.out.println("Posicao não existe!");
            return;
        }
        var listaIdJogadores = listaPosicao.getPlayerList();
        var listaJogadores = dbEntries.getJogadores();
        var jogadoresImpressos = 0;

        System.out.printf(
                "%8s %40s %20s %12s %5s \n",
                "sofifaID",
                "ShortName",
                "PlayerPositions",
                "GlobalRating",
                "Count"
        );

        for (Integer id : listaIdJogadores) {
            var jogador = listaJogadores.getJogador(id);
            if (jogador.getCount() >= 100) {
                System.out.printf(
                        "%8d %40s %20s %12f %5d \n",
                        jogador.getSofifaId(),
                        jogador.getShortName(),
                        jogador.getPlayerPositions().toString(),
                        jogador.getGlobalRating(),
                        jogador.getCount());
                jogadoresImpressos += 1;

                if (jogadoresImpressos >= maxJogadores) {
                    break;
                }
            }

        }
    }
}

