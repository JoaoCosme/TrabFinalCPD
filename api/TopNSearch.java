package api;

import model.DBEntries;

public class TopNSearch {
    private  DBEntries dbEntries;

    public TopNSearch() {
        this.dbEntries = DBEntries.get_instance();
    }

}

