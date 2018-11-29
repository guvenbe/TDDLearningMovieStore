package model;


import org.junit.Before;
import org.junit.Test;

import java.util.List;


import static org.hamcrest.CoreMatchers.is;


import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.assertThat;

/*
 * Copyright 2018 GM Global Technology Operations LLC
 * All Rights Reserved.
 * This software is proprietary to GM Global Technology Operations LLC
 * and is protected by intellectual property laws and international
 * intellectual property treaties. Your access to this software is governed
 * by the terms of your license agreement with GM Global Technology Operations LLC.
 * Any other use of the software is strictly prohibited.
 */public class MovieStoreTest {


    private final Movie harryPotter = new Movie("Harry Potter", "Rowling", 2000);
    private final Movie starWars = new Movie("StAR Wars", "Shwimmer", 1999);
    private final Movie starTrek = new Movie("Star Trek", "Shwimmer", 2002);
    private final Movie shawshankRedemption = new Movie("Shawshank Redemption", "Bob", 2001);
    private final Movie takeThat = new Movie("Take That", "Shwimmer", 2010);
    private final MovieStore movieStore = new MovieStore();


    @Before
    public void setUp() throws Exception {
        movieStore.add(harryPotter);
        movieStore.add(starWars);
        movieStore.add(starTrek);
        movieStore.add(shawshankRedemption);
        movieStore.add(takeThat);
    }

    @Test
     public void returnNoResultsWhenNoTitelesPartiallyMatchSearch() throws Exception{

        List<Movie> results= movieStore.findByPartialTitle("abc");
        assertThat(results.size(), is(0));
     }


    @Test
    public void findsMovieWhenTitleIsPartiallyMatchedCaseInsensitive() throws Exception{

        List<Movie> results= movieStore.findByPartialTitle("Star");
        assertThat(results.size(), is(2));
        assertThat(results, containsInAnyOrder(starTrek, starWars));
    }

    @Test
    public void findsMovieWhenDirectorExactlyMatches() throws Exception{

        List<Movie> results= movieStore.findByDirector("Shwimmer");
        assertThat(results.size(), is(3));
        assertThat(results, containsInAnyOrder(starTrek, starWars, takeThat));
    }
    @Test
    public void findsMovieWhenReleaseYearIsBetweenTwoValues() throws Exception{

        List<Movie> results= movieStore.findByReleaseYear(1999, 2002);
        assertThat(results.size(), is(2));
        assertThat(results, containsInAnyOrder(harryPotter,shawshankRedemption));
    }
}