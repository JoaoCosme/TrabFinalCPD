package model;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;
//https://stackify.com/optional-parameters-java/
public class Jogador implements Comparable {
    private int sofifaId;
    private String shortName;
    private List<String> playerPositions;
    private double globalRating;
    private double totalGlobalRating;
    private int count;
    private List<String> tags;

    public Jogador(int sofifaId, String shortName, List<String> playerPositions) {
        this.sofifaId = sofifaId;
        this.shortName = shortName;
        this.playerPositions = playerPositions;
        this.globalRating = 0;
        this.count = 0;
        this.tags = new ArrayList<String>();
    }

    public Jogador(int sofifaId){
        this.sofifaId = sofifaId;
    }

    @Override
    public String toString() {
        return "{" +
            " sofifaId='" + getSofifaId() + "'" +
            ", shortName='" + getShortName() + "'" +
            ", playerPositions='" + getPlayerPositions() + "'" +
            ", globalRating='" + getGlobalRating() + "'" +
            ", count='" + getCount() + "'" +
            ", tags='" + getTags() + "'" +
            "}";
    }

    public int getSofifaId() {
        return this.sofifaId;
    }

    public void setSofifaId(int sofifaId) {
        this.sofifaId = sofifaId;
    }

    public String getShortName() {
        return this.shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public List<String> getPlayerPositions() {
        return this.playerPositions;
    }

    public void setPlayerPositions(List<String> playerPositions) {
        this.playerPositions = playerPositions;
    }

    public double getGlobalRating() {
        return this.globalRating;
    }

    public void setGlobalRating(double globalRating) {
        this.globalRating = globalRating;
    }

    public int getCount() {
        return this.count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<String> getTags() {
        return this.tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public void addClassificao(double classificacao){
        this.totalGlobalRating += classificacao;
        this.globalRating = totalGlobalRating/count;
    }
    public void incCount(){
        this.count++;
    }

    public void addTag(String tag){
        this.tags.add(tag);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Jogador jogador = (Jogador) o;

        return sofifaId == jogador.sofifaId;
    }

    @Override
    public int compareTo(Object o) {
        if(this == o) return 0;
        Jogador jogador = (Jogador) o;
        if (jogador.getGlobalRating() > this.globalRating){
            return 1;
        }else{
            return -1;
        }
    }
}