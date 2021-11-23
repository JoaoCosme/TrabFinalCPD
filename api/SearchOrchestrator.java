package api;

import java.util.Arrays;

public class SearchOrchestrator {
    private PlayerNameSearch playerNameSearch;
    private TagSearch tagSearch;
    private TopNSearch topNSearch;
    private  UsersRatesSearch usersRatesSearch;

    public SearchOrchestrator(PlayerNameSearch playerNameSearch, TagSearch tagSearch, TopNSearch topNSearch, UsersRatesSearch usersRatesSearch) {
        this.playerNameSearch = playerNameSearch;
        this.tagSearch = tagSearch;
        this.topNSearch = topNSearch;
        this.usersRatesSearch = usersRatesSearch;
    }

    public boolean search(String commands[]){
        var programRunning = true;

        switch (commands[0]) {
            case "player":
                playerNameSearch.searchPlayer(Arrays.copyOfRange(commands,1,commands.length));
                break;

            case "user":
                usersRatesSearch.searchUser(commands[1]);
                break;

            case "top":
                topNSearch.search(Integer.parseInt(commands[1]),commands[2]);
                break;

            case "tags":
                tagSearch.search(Arrays.copyOfRange(commands,1,commands.length));
                break;

            case "q":
                programRunning = false;
                break;

            default:
                if (commands[0].charAt(0) == 't' &&
                        commands[0].charAt(1) == 'o' &&
                        commands[0].charAt(2) == 'p' ){
                    commands[0] = commands[0].replaceAll("\\D+","");
                    topNSearch.search(Integer.parseInt(commands[0]),commands[1]);
                }else {
                    System.out.println("Comando invalido");
                }
                break;
        }
        return programRunning;
    }
    }
