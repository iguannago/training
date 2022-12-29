package com.getinthecloud.hexagonal.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity.authorizeHttpRequests((req) -> {
                try {
                    req
                        .antMatchers("/home").permitAll()
                        .antMatchers("/book/**").authenticated().and().httpBasic(Customizer.withDefaults());
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        ).build();
    }


}
