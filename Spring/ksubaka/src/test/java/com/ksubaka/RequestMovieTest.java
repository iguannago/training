package com.ksubaka;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by davicres on 31/03/2016.
 */
public class RequestMovieTest {
    private RequestMovie requestMovie = new RequestMovie();
    private MovieList movieList = null;

    @Test
    public void httpRequestRetrieveData() {
        RequestMovie requestMovie = new RequestMovie();
        assertNull(movieList);
        movieList = requestMovie.call("Indiana Jones");
        System.out.println("movies: " + movieList.toString());
        assertNotNull(movieList);
    }

    @Test
    public void httpRequestRetrieveTitleYearAndDirectorData() {
        movieList = requestMovie.call("Indiana Jones");
        String director = movieList.getSearch().get(0).getDirector();
        assertNotNull(director);
        assertNotEquals("", director);
    }
}
