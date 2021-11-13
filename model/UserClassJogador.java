package model;

import java.util.Comparator;

public class UserClassJogador implements Comparable{
    private int sofifaId;
    private double rating;
    private Object o;

    public UserClassJogador(int sofifaId, double rating) {
        this.sofifaId = sofifaId;
        this.rating = rating;
    }    

    public int getSofifaId() {
        return this.sofifaId;
    }

    public void setSofifaId(int sofifaId) {
        this.sofifaId = sofifaId;
    }

    public double getRating() {
        return this.rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "UserClassJogador{" +
                "sofifaId=" + sofifaId +
                ", rating=" + rating +
                '}';
    }
    @Override
    public int compareTo(Object o) {
        if(this == o) return 0;
        UserClassJogador jogador = (UserClassJogador) o;
        if (jogador.getRating() < this.getRating()){
            return 1;
        }else{
            return -1;
        }
    }
}