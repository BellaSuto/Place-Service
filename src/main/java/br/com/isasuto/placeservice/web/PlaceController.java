package br.com.isasuto.placeservice.web;

import br.com.isasuto.placeservice.domain.Place;
import br.com.isasuto.placeservice.domain.PlaceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/places")
public class PlaceController {
    private  PlaceService placeService;

    public PlaceController(PlaceService placeService){
        this.placeService = placeService;
    }


    @PostMapping
    public ResponseEntity<Mono<Place>> create (@RequestBody Place place){
        var createdPlace = placeService.create(place);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPlace);
    }
}
