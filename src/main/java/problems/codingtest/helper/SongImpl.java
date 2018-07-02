package problems.codingtest.helper;

import java.util.ArrayList;

/**
 * Created by yarbong on 25/01/2017.
 */
public class SongImpl implements Song {
    static int idPool  = 0;
    private int id;
    private float rating;
    private ArrayList<Song> similarSongs;

    public SongImpl() {
        this(0.0f);
    }

    public SongImpl(float rating) {
        this.id = ++idPool;
        this.rating = rating;
        similarSongs = new ArrayList<Song>();
    }
    public int getId() {
        return this.id;
    }

    public ArrayList<Song> getSimilarSongs() {
        return similarSongs;
    }

    public void addSimilarSongs(Song song) {
        similarSongs.add(song);
    }

    public float getRating() {
        return this.rating;
    }
}
