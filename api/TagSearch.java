package api;

import model.DBEntries;

public class TagSearch {
    private DBEntries dbEntries;
    public TagSearch(){
        dbEntries = DBEntries.get_instance();
    }
}
