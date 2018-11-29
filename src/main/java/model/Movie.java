package model;

public class Movie {


    private final String director;
    private final String title;
    private final int releaseYear;


    public String getDirector() {

        return director;
    }


    public Movie(String title, String director, int releaseYear) {
        this.title=title;
        this.director = director;
        this.releaseYear = releaseYear;
    }


    public String getTitle() {

        return title;
    }


    public int getReleaseYear() {

        return releaseYear;
    }
}
