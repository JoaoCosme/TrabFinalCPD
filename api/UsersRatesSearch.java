package api;

import model.DBEntries;

public class UsersRatesSearch {
    public void searchUser(String userCode, DBEntries dbEntries){
        var userDB = dbEntries.get_instance().getUsers();
        var playerDB = DBEntries.get_instance().getJogadores();

        var user = userDB.getUser(Integer.parseInt(userCode));
        var listaDeAvaliados = user.getJogadoresClassificados();

        listaDeAvaliados.stream().forEach(
                jogadorAvaliado -> {
                    var jogador = playerDB.getJogador(jogadorAvaliado.getSofifaId());
                    System.out.println(
                            jogador.getSofifaId() + "," +
                            jogador.getShortName() + "," +
                            jogador.getGlobalRating() + "," +
                            jogador.getCount() + "," +
                            jogadorAvaliado.getRating()
                    );
                }
        );

    }
}
