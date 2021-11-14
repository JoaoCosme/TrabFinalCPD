package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PositionPlayerList {
    private final String position;
    private final List<Integer> playerList = new ArrayList<>();

    public PositionPlayerList(String position, int sofifaID){
        this.position = position;
        playerList.add(sofifaID);
    }

    public PositionPlayerList(String position){
        this.position = position;

    }

    public void addPlayer(int sofifaID){
        playerList.add(sofifaID);
    }
    
    public List<Integer> getPlayerList(){
        return playerList;
    }

    public String getPosition(){return position;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PositionPlayerList positionTag = (PositionPlayerList) o;

        return Objects.equals(this.getPosition(), positionTag.getPosition());
    }

}
