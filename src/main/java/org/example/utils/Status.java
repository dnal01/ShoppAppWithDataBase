package org.example.utils;

public enum Status {
    DATA_ABSENT_MSG("No data!"),
    DATA_INSERT_MSG("Product and Variant were added."),
    DATA_UPDATE_MSG("Updated."),
    DATA_DELETE_MSG("Deleted.");

    private final String message;

    Status (String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
