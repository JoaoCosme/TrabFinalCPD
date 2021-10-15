import java.util.Scanner;

import javax.sql.RowSetInternal;

class main {
    public static void main(String[] args) {
        var commandScanner = new Scanner(System.in);

        // Rotina de inicialização
        var playerNameSearch = new PlayerNameSearch();
        var userRatesSearch  = new UsersRatesSearch();
        var top10Search = new Top10Search();
        var tagsSearch  = new TagSearch();


        while (true) {
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
                    commandScanner.close();
                    return;
            
                default:
                    System.out.println("Comando invalido");
                    break;
            }
        }
    }    
}