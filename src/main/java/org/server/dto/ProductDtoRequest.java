package org.server.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.UUID;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ProductDtoRequest(
        String description,
        String title,
        String category,
        int typeId,
        int vendorId,
        int groupById,
        boolean isWeiged,
        String measureUnit,
        String media,
        String barcode,
        double cost,
        double margin,
        double price
) {
}
