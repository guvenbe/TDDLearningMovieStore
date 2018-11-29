package model;

import java.util.LinkedList;
import java.util.List;

import static java.util.Arrays.asList;

public class MovieStore {
    List<Movie> movies = new LinkedList<Movie>();

    public List<Movie> findByPartialTitle(final String partialTitle) {

        List<Movie> results = new LinkedList<Movie>();
        return findBy(movie -> movie.getTitle().toUpperCase().contains(partialTitle.toUpperCase()), results);
    }


    public void add(Movie movie) {
        movies.add(movie);
    }


    public List<Movie> findByDirector(final String director) {

        List<Movie> results = new LinkedList<Movie>();
        return findBy(movie -> movie.getDirector().equals(director), results);
    }





    public List<Movie> findByReleaseYear(final int from, final int to) {

        List<Movie> results = new LinkedList<Movie>();
        return findBy(movie -> movie.getReleaseYear() > from && movie.getReleaseYear()<to, results);
    }

    interface Predicate{
        boolean matches(Movie movie);
    }
    public List<Movie> findBy(Predicate predicate, List<Movie> results) {

        for (Movie movie : movies){
            if(predicate.matches(movie)){
                results.add(movie);
            }
        }
        return results;
    }
}
