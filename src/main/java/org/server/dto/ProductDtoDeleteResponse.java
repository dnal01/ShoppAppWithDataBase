package org.server.dto;

import org.server.utils.Status;

public record ProductDtoDeleteResponse(String message, boolean isProductDeleted) {
    public static ProductDtoDeleteResponse of(Long id, boolean isProductDeleted) {
        String message = Status.FAILURE_MESSAGE.getMessage().formatted(id);
        if (isProductDeleted) {
            message = Status.SUCCESS_MESSAGE.getMessage().formatted(id);
        }
        return new ProductDtoDeleteResponse(message, isProductDeleted);
    }
}
