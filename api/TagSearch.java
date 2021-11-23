package api;

import model.DBEntries;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.isNull;

public class TagSearch {
    private final DBEntries dbEntries;

    public TagSearch() {
        dbEntries = DBEntries.get_instance();
    }

    public void search(String[] tags) {
        var hashTags = dbEntries.getTagHashTable();
        var hashJogadores = dbEntries.getJogadores();
        var listaIdsConjunto = new ArrayList<Integer>();
        var primeiraIterecao = true;

        var tagsConstruidas = constroiTags(tags);



        for (String tag : tagsConstruidas) {
            var listaIds = hashTags.getTag(tag);

            if (isNull(listaIds)){
                System.out.println("Tag "+tag+" não encontrada!");
                continue;
            }

            if(primeiraIterecao){
                listaIdsConjunto.addAll(listaIds.getSofifaIdList());
                primeiraIterecao = false;
            }else{
                var novaLista = new ArrayList<Integer>();

                for (int id : listaIds.getSofifaIdList()) {
                    if(listaIdsConjunto.contains(id)){
                        novaLista.add(id);
                    }
                }
                listaIdsConjunto = novaLista;
            }
        }

        if (isNull(listaIdsConjunto)){
            System.out.println("Nenhum jogador com todas as tags entradas!");
            return;
        }

        System.out.printf(
                "%8s %40s %20s %12s %5s \n",
                "sofifaID",
                "ShortName",
                "PlayerPositions",
                "GlobalRating",
                "Count"
        );

        for (int id : listaIdsConjunto) {
            var jogador = hashJogadores.getJogador(id);
            System.out.printf(
                    "%8d %40s %20s %12f %5d \n",
                    jogador.getSofifaId(),
                    jogador.getShortName(),
                    jogador.getPlayerPositions().toString(),
                    jogador.getGlobalRating(),
                    jogador.getCount());
        }
    }

    private List<String> constroiTags(String[] tags) {
        var listaDeRetorno = new ArrayList<String>();
        var lendoTag = false;
        var palavraAtual = "";


        for (String tag : tags) {
            tag = tag.toUpperCase();
            if (!lendoTag) {
                if (tag.charAt(0) == '\'') {
                    lendoTag = true;
                    palavraAtual = palavraAtual.concat(tag);
                    if (tag.charAt(tag.length() - 1) == '\'') {
                        palavraAtual = palavraAtual.replace("'","");
                        listaDeRetorno.add(palavraAtual);
                        palavraAtual = "";
                        lendoTag = false;
                    }else{
                        palavraAtual = palavraAtual.concat(" ");
                    }
                }
            } else {
                palavraAtual = palavraAtual.concat(tag);
                if (tag.charAt(tag.length() - 1) == '\'') {
                    palavraAtual = palavraAtual.replace("'","");
                    listaDeRetorno.add(palavraAtual);
                    palavraAtual = "";
                    lendoTag = false;
                }else{
                    palavraAtual = palavraAtual.concat(" ");
                }
            }
        }
        return listaDeRetorno;
    }
}