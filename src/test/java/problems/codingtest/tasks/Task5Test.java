package problems.codingtest.tasks;

import org.junit.Before;
import org.junit.Test;
import problems.codingtest.helper.Movie;
import problems.codingtest.helper.MovieImpl;

import java.util.*;

import static org.junit.Assert.*;

/**
 * Created by yarbong on 24/01/2017.
 */
public class Task5Test {
    private Task5 task5;
    private int N;

    @Before
    public void setUp() throws Exception {
        task5 = new Task5();
        N = 5;
    }

    @Test
    public void testSolveA() throws Exception{
        Movie movie1 = new MovieImpl(3.2f);
        Movie movie2 = new MovieImpl(3.6f);
        Movie movie3 = new MovieImpl(2.8f);
        Movie movie4 = new MovieImpl(4.0f);

        movie1.addSimilarMovies(movie2);
        movie1.addSimilarMovies(movie3);
        movie2.addSimilarMovies(movie1);
        movie2.addSimilarMovies(movie4);
        movie3.addSimilarMovies(movie1);
        movie3.addSimilarMovies(movie4);
        movie4.addSimilarMovies(movie3);
        movie4.addSimilarMovies(movie2);

        Set<Movie> expectedResult = new LinkedHashSet<>();
        expectedResult.add(movie2);
        expectedResult.add(movie4);
        expectedResult.add(movie3);

        assertEquals("It's TreeSet failed",
                Arrays.toString(expectedResult.toArray())
                , Arrays.toString(task5.solveWithTreeSet(movie1,N).toArray()));

        assertEquals("It's Deque failed",
                Arrays.toString(expectedResult.toArray())
                , Arrays.toString(task5.solveWithDeque(movie1,N).toArray()));

    }
    @Test
    public void testSolveB() throws Exception{
        Movie movie1 = new MovieImpl(4.0f);
        Movie movie2 = new MovieImpl(3.6f);
        Movie movie3 = new MovieImpl(2.8f);
        Movie movie4 = new MovieImpl(3.2f);

        movie1.addSimilarMovies(movie2);
        movie1.addSimilarMovies(movie3);
        movie2.addSimilarMovies(movie1);
        movie2.addSimilarMovies(movie4);
        movie3.addSimilarMovies(movie1);
        movie3.addSimilarMovies(movie4);
        movie4.addSimilarMovies(movie3);
        movie4.addSimilarMovies(movie2);

        Set<Movie> expectedResult = new LinkedHashSet<>();
        expectedResult.add(movie2);
        expectedResult.add(movie4);
        expectedResult.add(movie3);

        assertEquals("It's TreeSet failed",
                Arrays.toString(expectedResult.toArray())
                , Arrays.toString(task5.solveWithTreeSet(movie1,N).toArray()));

        assertEquals("It's Deque failed",
                Arrays.toString(expectedResult.toArray())
                , Arrays.toString(task5.solveWithDeque(movie1,N).toArray()));

    }

    @Test
    public void testSolveC() throws Exception{
        Movie movie1 = new MovieImpl(3.6f);
        Movie movie2 = new MovieImpl(3.6f);
        Movie movie3 = new MovieImpl(2.8f);
        Movie movie4 = new MovieImpl(4.0f);

        movie1.addSimilarMovies(movie2);
        movie1.addSimilarMovies(movie3);
        movie2.addSimilarMovies(movie1);
        movie2.addSimilarMovies(movie4);
        movie3.addSimilarMovies(movie1);
        movie3.addSimilarMovies(movie4);
        movie4.addSimilarMovies(movie3);
        movie4.addSimilarMovies(movie2);

        Set<Movie> expectedResult = new LinkedHashSet<>();
        expectedResult.add(movie2);
        expectedResult.add(movie4);
        expectedResult.add(movie3);

        assertEquals("It's TreeSet failed",
                Arrays.toString(expectedResult.toArray())
        , Arrays.toString(task5.solveWithTreeSet(movie1,N).toArray()));

        assertEquals("It's Deque failed",
                Arrays.toString(expectedResult.toArray())
        , Arrays.toString(task5.solveWithDeque(movie1,N).toArray()));

    }


    @Test
    public void testSolveWithNull() throws Exception {
        assertNull(task5.solveWithTreeSet(null, 0));
    }



}