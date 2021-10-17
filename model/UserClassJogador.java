public class UserClassJogador {
    private int sofifaId;
    private int rating;

    public UserClassJogador(int sofifaId, int rating) {
        this.sofifaId = sofifaId;
        this.rating = rating;
    }    

    public int getSofifaId() {
        return this.sofifaId;
    }

    public void setSofifaId(int sofifaId) {
        this.sofifaId = sofifaId;
    }

    public int getRating() {
        return this.rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}