import java.util.ArrayList;
import java.util.List;
public class Album implements Comparable<Album> {
    private List<String> artists;
    private int id;
    private String title;
    private int numSongs;

    public Album(int id, List<String> artists, String title, int numSongs) {
        this.id = id;
        this.artists = artists;
        this.title = title;
        this.numSongs = numSongs;
    }

    public int getId() {
        return id;
    }

    public List<String> getArtists() {
        return artists;
    }

    public String getTitle() {
        return title;
    }

    public int getNumSongs() {
        return numSongs;
    }

    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        for (String artist : artists) {
            stringBuilder.append(artist);
            stringBuilder.append(", ");
        }
        if (stringBuilder.length() > 0) {
            stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());
        }
        return String.format("ID: " + id + " - - " + numSongs + " Songs - - [" + stringBuilder.toString() + "]");
    }

    @Override
    public int compareTo(Album other) {
        return this.id - other.id;
    }

}
