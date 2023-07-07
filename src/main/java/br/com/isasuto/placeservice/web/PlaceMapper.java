package br.com.isasuto.placeservice.web;

import br.com.isasuto.placeservice.api.PlaceResponse;
import br.com.isasuto.placeservice.domain.Place;

public class PlaceMapper {
    public static PlaceResponse fromPlaceToResponse(Place place){
        return new PlaceResponse(place.name(), place.slug(), place.state(), place.createdAt(),place.updatedAt());
    }
}
