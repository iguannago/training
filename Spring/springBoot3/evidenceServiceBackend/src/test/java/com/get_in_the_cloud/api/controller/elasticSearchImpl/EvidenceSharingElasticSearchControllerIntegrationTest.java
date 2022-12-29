package com.get_in_the_cloud.api.controller.elasticSearchImpl;

import com.get_in_the_cloud.api.domain.evidence.Evidence;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.index.IndexRequestBuilder;
import org.elasticsearch.client.Client;
import org.elasticsearch.node.Node;
import org.elasticsearch.node.NodeBuilder;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Created by davicres on 23/11/2016.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class EvidenceSharingElasticSearchControllerIntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;
    private final Node node = new NodeBuilder().local(true).node().start();
    private final Client client = node.client();

    @Test
    public void getEvidenceEndpointTest() throws InterruptedException {
        configureAndCreateIndex();
        ResponseEntity<String> response = restTemplate.getForEntity("/EvidenceSharingAPI/evidences/E001", String.class);
        System.out.println(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    private void configureAndCreateIndex() {
        IndexRequestBuilder indexRequestBuilder = client.prepareIndex("evidences", "evidence", "E001");
        Map<String, Object> source = new HashMap<>(1);
        source.put("evidenceID", "E001");
        source.put("content", "hey you, this works!");
        indexRequestBuilder.setSource(source);
        indexRequestBuilder.setRefresh(true);
        indexRequestBuilder.execute().actionGet();
    }

    @Test
    public void postEvidenceEndpointTest() {
        ResponseEntity<String> response = restTemplate.postForEntity("/EvidenceSharingAPI/evidences",
                new Evidence("E001", "some content"), String.class);
        System.out.println(response);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
    }

    @After
    public void tearDown() throws Exception {
        DeleteIndexRequest indexRequest = new DeleteIndexRequest("evidences");
        client.admin().indices().delete(indexRequest).actionGet();
        client.close();
        node.stop();
    }
}
