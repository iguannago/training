package com.get_in_the_cloud.api.controller.elasticSearchImpl;

import com.get_in_the_cloud.api.domain.evidence.Evidence;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

/**
 * Created by davicres on 02/12/2016.
 */
public class EvidenceResourceUtil {
    public static Resource<Evidence> evidenceToGETResource(Evidence evidence) {
        String evidenceID = evidence.getEvidenceID();
        Link selfLink = linkTo(methodOn(EvidenceSharingElasticSearchController.class).
                getEvidenceById(evidenceID)).slash(evidenceID).withSelfRel();
        return new Resource<>(evidence, selfLink);
    }

    public static Resource<Evidence> evidenceToPOSTResource(Evidence evidence) {
        Link selfLink = linkTo(methodOn(EvidenceSharingElasticSearchController.class).createEvidence(evidence)).
                withSelfRel();
        return new Resource<>(evidence, selfLink);
    }

}
