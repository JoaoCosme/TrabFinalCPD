package api;

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
                playerNameSearch.searchPlayer(commands[1]);
                break;

            case "user":
                usersRatesSearch.searchUser(commands[1]);
                break;

            case "top":
                topNSearch.search(Integer.parseInt(commands[1]),commands[2]);
                break;

            case "tags":
                System.out.println("tags");
                break;

            case "q":
                programRunning = false;
                break;

            default:
                System.out.println("Comando invalido");
                break;
        }
        return programRunning;
    }
    }
