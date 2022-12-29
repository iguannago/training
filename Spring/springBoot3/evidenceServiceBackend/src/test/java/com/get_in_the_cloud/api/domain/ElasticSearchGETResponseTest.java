package com.get_in_the_cloud.api.domain;

import com.get_in_the_cloud.api.domain.elasticSearchAPIResponse.ElasticSearchGETResponse;
import com.get_in_the_cloud.api.domain.evidence.Evidence;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;

/**
 * Created by davicres on 29/11/2016.
 */
public class ElasticSearchGETResponseTest {
    @Test
    public void elasticSearchResponseFieldsTest() {
        List<ElasticSearchGETResponse.Hits.Source> hitList = new ArrayList<>(1);
        hitList.add(new ElasticSearchGETResponse.Hits.Source(new Evidence("id1", "some content")));
        ElasticSearchGETResponse.Hits hits = new ElasticSearchGETResponse.Hits(hitList);
        ElasticSearchGETResponse elasticSearchResponse = new ElasticSearchGETResponse(hits);
        assertNotNull(elasticSearchResponse);
    }
}
