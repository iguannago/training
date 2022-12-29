package com.ksubaka;

import org.junit.Test;

/**
 * Created by davicres on 01/04/2016.
 */
public class ApplicationTest {
    @Test
    public void testingMovieAndApiSystemProperties() {
        System.setProperty("api", "imdb");
        String api = System.getProperty("api");
        System.setProperty("movie", "Indiana Jones");
        String movie = System.getProperty("movie");
        System.out.println("api: " + api);
        System.out.println("movie: " + movie);
        Application.main(null);
    }

    @Test
    public void testingAlbumAndApiSystemProperties() {
        System.setProperty("api", "spotify");
        String api = System.getProperty("api");
        System.setProperty("album", "Back to Black");
        String album = System.getProperty("album");
        System.out.println("api: " + api);
        System.out.println("album: " + album);
        Application.main(null);
    }
}
