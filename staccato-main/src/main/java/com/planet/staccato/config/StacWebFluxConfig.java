package com.planet.staccato.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.config.CorsRegistry;
import org.springframework.web.reactive.config.WebFluxConfigurer;

/**
 * @author joshfix
 * Created on 2/28/19
 */
@Configuration
//@EnableWebFlux
public class StacWebFluxConfig implements WebFluxConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry corsRegistry) {
//
//        corsRegistry.addMapping("/**")
//                .allowedOrigins("http://localhost:1234, http://localhost:8080")
//                .allowedMethods("GET", "POST", "PUT")
//                .maxAge(3600);
//        corsRegistry.addMapping("/stac/**")
//                .allowedOrigins("http://localhost:1234, http://localhost:8080")
//                .allowedMethods("GET", "POST", "PUT")
//                .maxAge(3600);
//
        corsRegistry.addMapping("/**")
                .allowedOrigins("https://stac.geoanalytics.ca", "https://browse.stac.geoanalytics.ca", "http://localhost:1234")
                .allowedMethods("*")
//                .allowedHeaders("*")
//                .exposedHeaders("Access-Control-Allow-Origin",
//                        "Access-Control-Allow-Methods",
//                        "Access-Control-Allow-Headers",
//                        "Access-Control-Max-Age",
//                        "Access-Control-Request-Headers",
//                        "Access-Control-Request-Method")
//                .maxAge(3600);
        ;
    }
}
