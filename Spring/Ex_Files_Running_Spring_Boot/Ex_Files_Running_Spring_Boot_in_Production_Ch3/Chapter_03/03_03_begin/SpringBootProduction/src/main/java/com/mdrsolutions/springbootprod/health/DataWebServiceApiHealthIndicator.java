package com.mdrsolutions.springbootprod.health;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class DataWebServiceApiHealthIndicator implements HealthIndicator {
    private static final String MESSAGE_KEY = "Data Web Service API";
    @Override
    public Health health() {
        if (!isServiceUp()) {
            return Health.down().withDetail(MESSAGE_KEY, "Not Available").build();
        }
        return Health.up().withDetail(MESSAGE_KEY, "Available").build();
    }

    private Boolean isServiceUp(){
        return false;
    }
}
