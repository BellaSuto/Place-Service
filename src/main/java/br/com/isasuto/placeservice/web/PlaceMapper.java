package br.com.isasuto.placeservice.web;

import br.com.isasuto.placeservice.api.PlaceRequest;
import br.com.isasuto.placeservice.api.PlaceResponse;
import br.com.isasuto.placeservice.domain.Place;
import org.springframework.util.StringUtils;

public class PlaceMapper {
    public static Place updatePlaceFromDTO(PlaceRequest placeRequest, Place place) {
        final String name = StringUtils.hasText(placeRequest.name()) ? placeRequest.name() : place.name();
        final String city = StringUtils.hasText(placeRequest.city()) ? placeRequest.city() : place.city();
        final String state = StringUtils.hasText(placeRequest.state()) ? placeRequest.state() : place.state();
        return new Place(place.id(), name, place.slug(), city, state, place.createdAt(), place.updatedAt());
    }

    public static PlaceResponse toResponse(Place place) {
        return new PlaceResponse(place.name(), place.slug(),
                place.city(), place.state(), place.createdAt(), place.updatedAt());
    }
}
