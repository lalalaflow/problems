package problems.codingtest.helper;

import java.util.ArrayList;

/**
 * Created by yarbong on 24/01/2017.
 */
public interface Movie {

    int getId();
    ArrayList<Movie> getSimilarMovies();
    void addSimilarMovies(Movie movie);
    float getRating();

}
