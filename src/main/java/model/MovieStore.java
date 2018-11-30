package model;

import java.util.LinkedList;
import java.util.List;

public class MovieStore {

    List<Movie> movies = new LinkedList<Movie>();


    public List<Movie> findByPartialTitle(final String partialTitle) {

        List<Movie> results = new LinkedList<Movie>();
        for (Movie movie : movies) {
            if (movie.getTitle().toUpperCase().contains(partialTitle.toUpperCase())) {
                results.add(movie);
            }
        }
        return results;
    }


    public void add(Movie movie) {

        movies.add(movie);
    }


    public List<Movie> findByDirector(final String director) {

        List<Movie> results = new LinkedList<Movie>();
        for (Movie movie : movies) {
            if (movie.getDirector().toUpperCase().equals(director.toUpperCase())) {
                results.add(movie);
            }
        }
        return results;
    }


    public List<Movie> findByReleaseYear(final int from, final int to) {

        List<Movie> results = new LinkedList<Movie>();

        for (Movie movie : movies) {
            if (movie.getReleaseYear() > from && movie.getReleaseYear() < to) {
                results.add(movie);
            }
        }
        return results;
    }

}
