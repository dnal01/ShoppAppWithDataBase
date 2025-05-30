package org.server.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.UUID;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ProductDtoRequest(
        UUID id, String productName, String email
) {
}
