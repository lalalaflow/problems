package problems.codingtest.helper;

import java.util.ArrayList;

/**
 * Created by yarbong on 25/01/2017.
 */
public class MovieImpl implements Movie {
    static int idPool  = 0;
    private int id;
    private float rating;
    private ArrayList<Movie> similarMovies;

    public MovieImpl() {
        this(0.0f);
    }

    public MovieImpl(float rating) {
        this.id = ++idPool;
        this.rating = rating;
        similarMovies = new ArrayList<>();
    }
    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public ArrayList<Movie> getSimilarMovies() {
        return similarMovies;
    }

    @Override
    public void addSimilarMovies(Movie movie) {
        similarMovies.add(movie);
    }

    @Override
    public float getRating() {
        return this.rating;
    }
}
