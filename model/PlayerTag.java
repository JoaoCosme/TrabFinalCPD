package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PlayerTag {
    private String tag;
    private final List<Integer> sofifaIdList = new ArrayList<>();

    public PlayerTag(String tag, int sofifaID){
        this.tag = tag;
        sofifaIdList.add(sofifaID);
    }

    public PlayerTag(String tag){
        this.tag = tag;
    }
    
    public void addSoFifaId(int sofiaId){
        sofifaIdList.add(sofiaId);
    }

    public List<Integer> getSofifaIdList(){
        return sofifaIdList;
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
