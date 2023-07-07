package br.com.isasuto.placeservice.web;

import br.com.isasuto.placeservice.api.PlaceRequest;
import br.com.isasuto.placeservice.api.PlaceResponse;
import br.com.isasuto.placeservice.domain.PlaceService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/places")
public class PlaceController {
    private  PlaceService placeService;

    public PlaceController(PlaceService placeService){
        this.placeService = placeService;
    }


    @PostMapping
    public ResponseEntity<Mono<PlaceResponse>> create(@Valid @RequestBody PlaceRequest request) {
        var placeResponse = placeService.create(request).map(PlaceMapper::toResponse);
        return ResponseEntity.status(HttpStatus.CREATED).body(placeResponse);
    }
    @GetMapping
    public Flux<PlaceResponse> list(@RequestParam(required = false) String name) {
        return placeService.listAll(name).map(PlaceMapper::toResponse);
    }
}
