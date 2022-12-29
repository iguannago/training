package com.ksubaka;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by davicres on 31/03/2016.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public final class MovieList {

    @JsonProperty("Search")
    private List<Movie> search = new ArrayList<Movie>();

    public List<Movie> getSearch() {
        return search;
    }

    public void setSearch(List<Movie> search) {
        this.search = search;
    }

    @Override
    public String toString() {
        return "Movies{" +
                "search=" + search +
                '}';
    }
}
