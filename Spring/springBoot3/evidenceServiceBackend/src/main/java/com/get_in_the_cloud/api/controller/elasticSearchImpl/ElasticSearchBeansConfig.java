package com.get_in_the_cloud.api.controller.elasticSearchImpl;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Created by davicres on 01/12/2016.
 */
@Configuration
public class ElasticSearchBeansConfig {
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
