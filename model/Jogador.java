package model;

import java.util.List;

public class Jogador implements Comparable {
    private int sofifaId;
    private String shortName;
    private List<String> playerPositions;
    private double globalRating;
    private double totalGlobalRating;
    private int count;

    public Jogador(int sofifaId, String shortName, List<String> playerPositions) {
        this.sofifaId = sofifaId;
        this.shortName = shortName;
        this.playerPositions = playerPositions;
        this.globalRating = 0;
        this.count = 0;
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

    public double getGlobalRating() {
        return this.globalRating;
    }

    public int getCount() {
        return this.count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void addClassificao(double classificacao){
        this.totalGlobalRating += classificacao;
        this.globalRating = totalGlobalRating/count;
    }
    public void incCount(){
        this.count++;
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
        if (jogador.getGlobalRating() < this.globalRating){
            return 1;
        }else{
            return -1;
        }
    }
}