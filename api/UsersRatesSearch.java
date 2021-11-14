package api;

import model.DBEntries;
import model.User;
import service.QuickSorterUserClassJogador;

public class UsersRatesSearch {
    private final DBEntries dbEntries;

    public UsersRatesSearch(){
        this.dbEntries = DBEntries.get_instance();
    }

    public void searchUser(String userCode){
        var userDB = dbEntries.getUsers();
        var playerDB = dbEntries.getJogadores();

        User user = userDB.getUser(Integer.parseInt(userCode));

        if (user == null){
            System.out.println("Usuario nao encontrado!");
            return;
        }

        var listaDeAvaliados = user.getJogadoresClassificados();
        QuickSorterUserClassJogador.sort(listaDeAvaliados);

        System.out.printf(
                "%8s %40s %12s %5s %11s \n",
                "sofifaID",
                "ShortName",
                "GlobalRating",
                "Count",
                "UserRating"
        );

        listaDeAvaliados.stream().limit(20).forEach(
                jogadorAvaliado -> {
                    var jogador = playerDB.getJogador(jogadorAvaliado.getSofifaId());
                    System.out.printf(
                            "%8d %40s %12f %5d %9.2f \n",
                            jogador.getSofifaId(),
                            jogador.getShortName(),
                            jogador.getGlobalRating(),
                            jogador.getCount(),
                            jogadorAvaliado.getRating()
                    );
                }
        );
    }
}