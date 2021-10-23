import service.SearchOrchestratorAssembler;

import java.util.Scanner;

class TFApp {
    public static void main(String[] args) {
        var commandScanner = new Scanner(System.in);
//
//        //Proximo passo: Consumir csvs
//
//        // Rotina de inicialização
//        var playerNameSearch = new PlayerNameSearch();
//        var userRatesSearch  = new UsersRatesSearch();
//        var top10Search = new Top10Search();
//        var tagsSearch  = new TagSearch();

        var searchOrchestrator = SearchOrchestratorAssembler.create();

        boolean programRunning = true;

        while (programRunning) {
            System.out.print("Enter command: ");

            var commandInput = commandScanner.nextLine();
            var commands = commandInput.split(" ");

            assert searchOrchestrator != null;
            programRunning = searchOrchestrator.search(commands);
        }
        commandScanner.close();
    }
}