package api;

import model.DBEntries;
import model.User;

public class UsersRatesSearch {
    private DBEntries dbEntries;

    public UsersRatesSearch(final DBEntries dbEntries){
        this.dbEntries = dbEntries;
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

        var usersShownCounter = new Object() {
            int usersShown = 0;
        };
        listaDeAvaliados.forEach(
                jogadorAvaliado -> {
                    var jogador = playerDB.getJogador(jogadorAvaliado.getSofifaId());
                    System.out.println(
                            jogador.getSofifaId() + "," +
                            jogador.getShortName() + "," +
                            jogador.getGlobalRating() + "," +
                            jogador.getCount() + "," +
                            jogadorAvaliado.getRating()
                    );
                    usersShownCounter.usersShown +=1;
                    if (usersShownCounter.usersShown >20){

                    }
                }
        );

    }
}
