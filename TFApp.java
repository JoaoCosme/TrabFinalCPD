import service.SearchOrchestratorAssembler;

import java.util.Scanner;

class TFApp {
    public static void main(String[] args) {
        var commandScanner = new Scanner(System.in);

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