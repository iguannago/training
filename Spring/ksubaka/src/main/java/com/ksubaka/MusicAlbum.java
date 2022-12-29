package com.ksubaka;

/**
 * Created by davicres on 31/03/2016.
 */
public final class MusicAlbum {
    private String title;
    private String year;
    private String artist;

    public MusicAlbum(String title, String artist, String year) {
        this.title = title;
        this.year = year;
        this.artist = artist;
    }


    public String getTitle() {
        return title;
    }

    public String getYear() {
        return year;
    }

    public String getArtist() {
        return artist;
    }

    @Override
    public String toString() {
        return "MusicAlbum{" +
                "title='" + title + '\'' +
                ", year='" + year + '\'' +
                ", artist='" + artist + '\'' +
                '}';
    }
}
