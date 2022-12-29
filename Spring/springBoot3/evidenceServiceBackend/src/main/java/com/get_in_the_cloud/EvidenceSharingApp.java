package com.get_in_the_cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by davicres on 22/11/2016.
 */
@SpringBootApplication
@EnableSwagger2
public class EvidenceSharingApp {

    public static void main(String[] args) {
        SpringApplication.run(EvidenceSharingApp.class, args);
    }

}
