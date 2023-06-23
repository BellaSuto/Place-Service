package br.com.isasuto.placeservice.domain;

import java.time.LocalDateTime;

public record Place(
        Long id, String name, String slug, String satate, LocalDateTime createdAt, LocalDateTime updateAt
        
) {
}
