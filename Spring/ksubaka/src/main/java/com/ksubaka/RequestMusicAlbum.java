package com.ksubaka;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

/**
 * Created by davicres on 31/03/2016.
 */
public class RequestMusicAlbum{
    private RestOperations restTemplate = new RestTemplate();

    public MusicAlbum call(String title) {
        ResponseEntity<String> albumsByTitleResponse = getHttpResponseForAlbumsByTitle(title);
        ResponseEntity<String> musicAlbumResponse = getHttpResponseForMusicAlbumById(getAlbumId(albumsByTitleResponse));
        return getTitleYearArtistFromReponseAndReturnUpdatedMusicAlbum(musicAlbumResponse);
    }

    private ResponseEntity<String> getHttpResponseForMusicAlbumById(String albumsByTitleResponse) {
        return restTemplate.getForEntity("https://api.spotify.com/v1/albums/" + albumsByTitleResponse, String.class);
    }

    private ResponseEntity<String> getHttpResponseForAlbumsByTitle(String title) {
        return restTemplate.getForEntity(
                "https://api.spotify.com/v1/search?q=" + title + "&type=album&market=US", String.class);
    }

    private MusicAlbum getTitleYearArtistFromReponseAndReturnUpdatedMusicAlbum(ResponseEntity<String> response) {
        JsonNode title = null;
        JsonNode artist = null;
        JsonNode year = null;
        ObjectMapper mapper = new ObjectMapper();
        try {
            JsonNode root = mapper.readTree(response.getBody());
            artist = root.path("artists").get(0).get("name");
            title = root.path("name");
            year = root.path("release_date");

        } catch (IOException e) {
            e.printStackTrace();
        }
        return new MusicAlbum(title.asText(), artist.asText(), year.asText());
    }

    private String getAlbumId(ResponseEntity<String> response) {
        JsonNode id = null;
        ObjectMapper mapper = new ObjectMapper();
        try {
            JsonNode root = mapper.readTree(response.getBody());
            id = root.path("albums").get("items").get(0).get("id");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return id.asText();
    }
}
