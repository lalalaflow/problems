package problems.codingtest.helper;

import java.util.ArrayList;

/**
 * Created by yarbong on 25/01/2017.
 */
public class SongImpl implements Song {
    static int idPool  = 0;
    private int id;
    private float rating;
    private ArrayList<Song> similarMovies;

    public SongImpl() {
        this(0.0f);
    }

    public SongImpl(float rating) {
        this.id = ++idPool;
        this.rating = rating;
        similarMovies = new ArrayList<>();
    }
    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public ArrayList<Song> getSimilarMovies() {
        return similarMovies;
    }

    @Override
    public void addSimilarMovies(Song song) {
        similarMovies.add(song);
    }

    @Override
    public float getRating() {
        return this.rating;
    }
}
