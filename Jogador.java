import java.lang.reflect.Constructor;
import java.util.List;
//https://stackify.com/optional-parameters-java/
public class Jogador {
    private int sofifaId;
    private String shortName;
    private List<String> playerPositions;
    private double globalRating;
    private int count;
    private List<String> tags;

    public Jogador(int sofifaId, String shortName, List<String> playerPositions, double globalRating, int count, List<String> tags) {
        this.sofifaId = sofifaId;
        this.shortName = shortName;
        this.playerPositions = playerPositions;
        this.globalRating = globalRating;
        this.count = count;
        this.tags = tags;
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
}