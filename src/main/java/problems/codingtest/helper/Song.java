package problems.codingtest.helper;

import java.util.ArrayList;

/**
 * Created by yarbong on 24/01/2017.
 */
public interface Song {

    int getId();
    ArrayList<Song> getSimilarMovies();
    void addSimilarMovies(Song song);
    float getRating();

}
