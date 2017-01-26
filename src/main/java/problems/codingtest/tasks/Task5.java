package problems.codingtest.tasks;

import problems.codingtest.helper.Song;

import java.util.*;
import java.util.function.Predicate;

/**
 * Created by yarbong on 24/01/2017.
 */
public class Task5 {

    private Set<Song> recommMovies = new LinkedHashSet<>();
    private Song selectedSong = null;

    // N개 이하의 비슷한 영화 중 평점이 높은 것들을 가져오되, 평점 순으로 정렬할 필요는 없음.
    // 가까이 연결되어 있는 것 (즉, 비슷한 것 우선)
    public Set<Song> solveWithTreeSet(Song song, int N) {

        if(null == song) return null;
        if(null == getSelectedSong()) setSelectedSong(song);

        NavigableSet<Song> similarMovies =
                (NavigableSet<Song>) getOrderedSimilarMovies(song.getSimilarMovies());
        Song highRantedSong = similarMovies.pollFirst();

        //선택된 노드가 이미 추천 목록에 들어가 있다면, 첫번째 노드 다음에 오는 두번째 노드도 가져와야함.
        while (getRecommMovies().contains(highRantedSong)) {
            highRantedSong = similarMovies.pollFirst();
        }
        //가져온 노드가 비었으면 메서드 종료
        if(highRantedSong == null)
            return getRecommMovies();

        add(highRantedSong);
        return (getRecommMovies().size() == N? getRecommMovies() : solveWithTreeSet(highRantedSong, N));
    }

    // N개 이하의 비슷한 영화 중 평점이 높은 것들을 가져오되, 평점 순으로 정렬할 필요는 없음.
    // 가까이 연결되어 있는 것 (즉, 비슷한 것 우선)
    public Set<Song> solveWithDeque(Song song, int N) {

        if(null == song) return null;
        if(null == getSelectedSong()) setSelectedSong(song);

        LinkedList<Song> similarMovies =
                getOrderedSimilarMoviesWithQueue(song.getSimilarMovies());
        Song highRantedSong = similarMovies.pollLast();

        //선택된 노드가 이미 추천 목록에 들어가 있다면, 첫번째 노드 다음에 오는 두번째 노드도 가져와야함.
        while (getRecommMovies().contains(highRantedSong)) {
            highRantedSong = similarMovies.pollFirst();
        }
        //가져온 노드가 비었으면 메서드 종료
        if(highRantedSong == null)
            return getRecommMovies();

        add(highRantedSong);
        return (getRecommMovies().size() == N? getRecommMovies() : solveWithTreeSet(highRantedSong, N));
    }

    //Similar Song list Ordering and converting to TreeSet type
    private Set<Song> getOrderedSimilarMovies(ArrayList<Song> aSimilarMovies){

        //Comparator 가 rating value가 되도록
        TreeSet<Song> tSimilarMovies = new TreeSet<>(Comparator.comparing(Song::getRating));
        tSimilarMovies.addAll(aSimilarMovies);
        Predicate<Song> moviePredicate =
                recommMovie -> getSelectedSong().getId() == recommMovie.getId();
        //추천을 요청한 노드와의 중복 제거, 기본 비교자가 Rating 이므로 아이디로 구별하여 제거하도록 Predicate정의
        tSimilarMovies.removeIf(moviePredicate) ;
        return tSimilarMovies.descendingSet();
    }

    //Similar Song list Ordering and converting to Deque type
    private LinkedList<Song> getOrderedSimilarMoviesWithQueue(ArrayList<Song> aSimilarMovies){

        //Comparator 가 rating value가 되도록
        LinkedList<Song> lSimilarMovies = new LinkedList<>(
                new PriorityQueue<Song>(Comparator.comparing(Song::getRating)));

        Predicate<Song> moviePredicate =
                recommMovie -> getSelectedSong().getId() == recommMovie.getId();
        //추천을 요청한 노드와의 중복 제거, 기본 비교자가 Rating 이므로 아이디로 구별하여 제거하도록 Predicate정의
        lSimilarMovies.removeIf(moviePredicate) ;
        return lSimilarMovies;
    }


    private void add(Song song){
        this.recommMovies.add(song);
    }

    private Set<Song> getRecommMovies() {
        return recommMovies;
    }

    private Song getSelectedSong() {
        return selectedSong;
    }

    private void setSelectedSong(Song selectedSong) {
        this.selectedSong = selectedSong;
    }
}

