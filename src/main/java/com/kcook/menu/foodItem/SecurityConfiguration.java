package com.kcook.menu.foodItem;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfigurationSource;

import java.util.Collections;

import static org.springframework.security.config.Customizer.withDefaults;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration {
        @Bean
        public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
            http.cors(corsConfigurer -> corsConfigurer.configurationSource(corsConfiguration()))
                    .csrf(AbstractHttpConfigurer::disable);
            http.authorizeHttpRequests(authorizeRequests-> authorizeRequests
                    .requestMatchers(HttpMethod.GET).permitAll().anyRequest().authenticated()).
                    httpBasic(withDefaults());

            return http.build();
        }
    @Bean
    public CorsConfigurationSource corsConfiguration() {
        return request -> {
            org.springframework.web.cors.CorsConfiguration config =
                    new org.springframework.web.cors.CorsConfiguration();
            config.setAllowedHeaders(Collections.singletonList("*"));
            config.setAllowedMethods(Collections.singletonList("*"));
            config.setAllowedOriginPatterns(Collections.singletonList("*"));
            config.addAllowedMethod( HttpMethod.DELETE );
            config.setAllowCredentials(true);
            return config;
        };
    }
}
