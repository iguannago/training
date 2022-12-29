package com.get_in_the_cloud.api.controller.elasticSearchImpl;

import com.get_in_the_cloud.api.EvidenceSharingRESTfulAPI;
import com.get_in_the_cloud.api.domain.elasticSearchAPIResponse.ElasticSearchGETResponse;
import com.get_in_the_cloud.api.domain.evidence.Evidence;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping(value = "/EvidenceSharingAPI/evidences", produces = "application/hal+json")
@Api(value = "/evidences", description = "Evidences REST API")
public class EvidenceSharingElasticSearchController implements EvidenceSharingRESTfulAPI {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/{evidenceId}")
    @ApiOperation(value = "Get an Evidence", notes = "Get an Evidence given an ID")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = Evidence.class)
    })
    public Resource<Evidence> getEvidenceById(@PathVariable(required = true) String evidenceId) {
        Evidence evidence = restTemplate.getForObject(getUriForRequest(evidenceId).toUri(),
                ElasticSearchGETResponse.class).getHits().getHits().get(0).get_source();
        Resource<Evidence> evidenceResource = EvidenceResourceUtil.evidenceToGETResource(evidence);
        if (logger.isDebugEnabled()) {
            logger.debug("GET evidence request: " + evidenceResource);
        }
        return evidenceResource;
    }

    private UriComponents getUriForRequest(String evidenceId) {
        String queryDSL = getQueryDSLToSearchByID(evidenceId);
        return UriComponentsBuilder.fromUriString(
                "http://localhost:9200/evidences/evidence/_search").queryParam("source", queryDSL).build().encode();
    }

    private String getQueryDSLToSearchByID(String evidenceId) {
        return "{\n" +
                "    \"query\": {\n" +
                "        \"match\" : {\n" +
                "            \"evidenceID\" : \"" + evidenceId + "\"\n" +
                "        }\n" +
                "    }\n" +
                "}";
    }

    @PostMapping()
    @ApiOperation(value = "Post an Evidence", notes = "Create an Evidence from the JSON payload in the post request")
    @ApiResponses(value = {@ApiResponse(code = 201, message = "Created", response = Evidence.class)
    })
    public ResponseEntity<Resource<Evidence>> createEvidence(@RequestBody Evidence evidence) {
        ResponseEntity<String> response = restTemplate.postForEntity("http://localhost:9200/evidences/evidence",
                evidence, String.class);
        Resource<Evidence> evidenceResource = EvidenceResourceUtil.evidenceToPOSTResource(evidence);
        if (logger.isDebugEnabled()) {
            logger.debug("POST evidence request: " + evidenceResource);
        }
        return new ResponseEntity<>(evidenceResource, response.getStatusCode());
    }

}
