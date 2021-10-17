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
            var commands =  commandInput.split(" ");

            switch (commands[0]) {
                case "player":
                    System.out.println("JOao cosme");
                    break;
                
                case "user":
                    System.out.println("User");
                    break;
                
                case "top10":
                    System.out.println("top10");
                    break;
                
                case "tags":
                    System.out.println("tags");
                    break;

                case "q":
                    programRunning = false;
                    commandScanner.close();
                    break;
            
                default:
                    System.out.println("Comando invalido");
                    break;
            }
        }
    }    
}