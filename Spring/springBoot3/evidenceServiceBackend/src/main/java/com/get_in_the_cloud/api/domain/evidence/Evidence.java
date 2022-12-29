package com.get_in_the_cloud.api.domain.evidence;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by davicres on 22/11/2016.
 */
public class Evidence {
    private final String evidenceID;
    private final String content;

    @JsonCreator
    public Evidence(@JsonProperty("evidenceID") String evidenceID, @JsonProperty("content") String content) {
        this.evidenceID = evidenceID;
        this.content = content;
    }

    public String getEvidenceID() {
        return evidenceID;
    }

    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        return "Evidence{" +
                "evidenceID='" + evidenceID + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
