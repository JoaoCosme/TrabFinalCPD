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
}
