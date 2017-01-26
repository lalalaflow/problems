package problems.codingtest.tasks;

import problems.codingtest.helper.Movie;

import java.util.*;
import java.util.function.Predicate;

/**
 * Created by yarbong on 24/01/2017.
 */
public class Task5 {

    private Set<Movie> recommMovies = new LinkedHashSet<>();
    private Movie selectedMovie = null;

    // N개 이하의 비슷한 영화 중 평점이 높은 것들을 가져오되, 평점 순으로 정렬할 필요는 없음.
    // 가까이 연결되어 있는 것 (즉, 비슷한 것 우선)
    public Set<Movie> solveWithTreeSet(Movie movie, int N) {

        if(null == movie) return null;
        if(null == getSelectedMovie()) setSelectedMovie(movie);

        NavigableSet<Movie> similarMovies =
                (NavigableSet) getOrderedSimilarMovies(movie.getSimilarMovies());
        Movie highRantedMovie = similarMovies.pollFirst();

        //선택된 노드가 이미 추천 목록에 들어가 있다면, 첫번째 노드 다음에 오는 두번째 노드도 가져와야함.
        while (getRecommMovies().contains(highRantedMovie)) {
            highRantedMovie = similarMovies.pollFirst();
        }
        //가져온 노드가 비었으면 메서드 종료
        if(highRantedMovie == null)
            return getRecommMovies();

        add(highRantedMovie);
        return (getRecommMovies().size() == N? getRecommMovies() : solveWithTreeSet(highRantedMovie, N));
    }

    // N개 이하의 비슷한 영화 중 평점이 높은 것들을 가져오되, 평점 순으로 정렬할 필요는 없음.
    // 가까이 연결되어 있는 것 (즉, 비슷한 것 우선)
    public Set<Movie> solveWithDeque(Movie movie, int N) {

        if(null == movie) return null;
        if(null == getSelectedMovie()) setSelectedMovie(movie);

        LinkedList<Movie> similarMovies =
                getOrderedSimilarMoviesWithQueue(movie.getSimilarMovies());
        Movie highRantedMovie = similarMovies.pollLast();

        //선택된 노드가 이미 추천 목록에 들어가 있다면, 첫번째 노드 다음에 오는 두번째 노드도 가져와야함.
        while (getRecommMovies().contains(highRantedMovie)) {
            highRantedMovie = similarMovies.pollFirst();
        }
        //가져온 노드가 비었으면 메서드 종료
        if(highRantedMovie == null)
            return getRecommMovies();

        add(highRantedMovie);
        return (getRecommMovies().size() == N? getRecommMovies() : solveWithTreeSet(highRantedMovie, N));
    }

    //Similar Movie list Ordering and converting to TreeSet type
    private Set<Movie> getOrderedSimilarMovies(ArrayList<Movie> aSimilarMovies){

        //Comparator 가 rating value가 되도록
        TreeSet<Movie> tSimilarMovies = new TreeSet<>(Comparator.comparing(Movie::getRating));
        tSimilarMovies.addAll(aSimilarMovies);
        Predicate<Movie> moviePredicate =
                recommMovie -> getSelectedMovie().getId() == recommMovie.getId();
        //추천을 요청한 노드와의 중복 제거, 기본 비교자가 Rating 이므로 아이디로 구별하여 제거하도록 Predicate정의
        tSimilarMovies.removeIf(moviePredicate) ;
        return tSimilarMovies.descendingSet();
    }

    //Similar Movie list Ordering and converting to Deque type
    private LinkedList<Movie> getOrderedSimilarMoviesWithQueue(ArrayList<Movie> aSimilarMovies){

        //Comparator 가 rating value가 되도록
        PriorityQueue<Movie> qSimilarMovies = new PriorityQueue<Movie>(Comparator.comparing(Movie::getRating));
        LinkedList<Movie> lSimilarMovies = new LinkedList<>(qSimilarMovies);

        Predicate<Movie> moviePredicate =
                recommMovie -> getSelectedMovie().getId() == recommMovie.getId();
        //추천을 요청한 노드와의 중복 제거, 기본 비교자가 Rating 이므로 아이디로 구별하여 제거하도록 Predicate정의
        lSimilarMovies.removeIf(moviePredicate) ;
        return lSimilarMovies;
    }


    public void add(Movie movie){
        this.recommMovies.add(movie);
    }

    public Set<Movie> getRecommMovies() {
        return recommMovies;
    }

    private Movie getSelectedMovie() {
        return selectedMovie;
    }

    private void setSelectedMovie(Movie selectedMovie) {
        this.selectedMovie = selectedMovie;
    }
}

