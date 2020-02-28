package com.planet.staccato.config;

import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;


public class CorsConfig {
    //@Bean
    public CorsWebFilter corsWebFilter() {
        CorsConfiguration config = new CorsConfiguration();

        config.setAllowCredentials(true);
        config.addAllowedOrigin("http://localhost:8080");
        config.addAllowedOrigin("http://localhost:1234");
        config.addAllowedOrigin("https://stac.geoanalytics.ca");
        config.addAllowedOrigin("https://browse.stac.geoanalytics.ca");
        config.addAllowedOrigin("http://dex.geoanalytics.ca:5556");
        config.addAllowedOrigin("https://dex.geoanalytics.ca:5556");
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);

        return new CorsWebFilter(source);
    }
}
