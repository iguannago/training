package com.ksubaka;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 * Created by davicres on 31/03/2016.
 */
public class RequestMusicAlbumTest {
    private RequestMusicAlbum requestMusicAlbum = new RequestMusicAlbum();

    @Test
    public void httpRequestForMusicAlbumRetrieveTitleYearAndArtistData() {
        MusicAlbum musicAlbum = null;
        musicAlbum = requestMusicAlbum.call("Back to Black");
        System.out.println("response: " + musicAlbum);
        assertNotNull(musicAlbum.getTitle());
        assertNotNull(musicAlbum.getYear());
        assertNotNull(musicAlbum.getArtist());
    }
}
