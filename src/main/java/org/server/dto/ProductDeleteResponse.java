package org.server.dto;

import org.server.utils.Status;

import java.util.UUID;

public record ProductDeleteResponse(String message, boolean isProductDeleted) {
    public static ProductDeleteResponse of(UUID id, boolean isProductDeleted) {
        String message = Status.FAILURE_MESSAGE.getMessage().formatted(id);
        if (isProductDeleted) {
            message = Status.SUCCESS_MESSAGE.getMessage().formatted(id);
        }
        return new ProductDeleteResponse(message, isProductDeleted);
    }
}
