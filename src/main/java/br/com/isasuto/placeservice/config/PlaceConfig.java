package br.com.isasuto.placeservice.config;

import br.com.isasuto.placeservice.domain.PlaceRepository;
import br.com.isasuto.placeservice.domain.PlaceService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PlaceConfig {

    @Bean
    PlaceService placeService(PlaceRepository placeRepository){
        return new PlaceService(placeRepository);
    }
}
