package com.ksubaka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by davicres on 31/03/2016.
 */
public class Application {
    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        if (System.getProperty("api").equals("imdb")) {
            RequestMovie requestMovie = new RequestMovie();
            MovieList movieList = requestMovie.call(System.getProperty("movie"));
            for (Movie movie: movieList.getSearch()) {
                log.info(movie.toString());
            }
        }
        if (System.getProperty("api").equals("spotify")) {
            RequestMusicAlbum requestMusicAlbum = new RequestMusicAlbum();
            MusicAlbum musicAlbum = requestMusicAlbum.call(System.getProperty("album"));
            log.info(musicAlbum.toString());
        }
    }
}
