package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PlayerTag {
    private final String tag;
    private final List<Integer> playerList = new ArrayList<>();

    public PlayerTag(String tag, int sofifaID){
        this.tag = tag;
        playerList.add(sofifaID);
    }

    public PlayerTag(String tag){
        this.tag = tag;
    }
    
    public void addSoFifaId(int sofiaId){
        playerList.add(sofiaId);
    }

    public List<Integer> getSofifaIdList(){
        return playerList;
    }

    public String getTag() {
        return tag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PlayerTag playerTag = (PlayerTag) o;

       return Objects.equals(getTag(), playerTag.getTag());
    }
}
