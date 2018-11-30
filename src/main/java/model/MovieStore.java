package model;

import java.util.LinkedList;
import java.util.List;

public class MovieStore {

    List<Movie> movies = new LinkedList<Movie>();


    public List<Movie> findByPartialTitle(final String partialTitle) {

        Predicate predicate = new Predicate() {

            public boolean matches(Movie movie) {

                return movie.getTitle().toUpperCase().contains(partialTitle.toUpperCase());
            }

        };

        return findBy(predicate);
    }


    public void add(Movie movie) {

        movies.add(movie);
    }


    public List<Movie> findByDirector(final String director) {

        Predicate predicate = new Predicate() {

            public boolean matches(Movie movie) {

                return movie.getDirector().toUpperCase().equals(director.toUpperCase());
            }
        };

        return findBy(predicate);
    }


    public List<Movie> findByReleaseYear(final int from, final int to) {


        Predicate predicate = new Predicate() {

            public boolean matches(Movie movie) {

                return movie.getReleaseYear() > from && movie.getReleaseYear() < to;
            }
        };

        return findBy(predicate);
    }


    private List<Movie> findBy(Predicate predicate) {

        List<Movie> results = new LinkedList<Movie>();
        for (Movie movie : movies) {

            if (predicate.matches(movie)) {
                results.add(movie);
            }
        }
        return results;
    }

}


interface Predicate {

    public boolean matches(Movie movie);
}