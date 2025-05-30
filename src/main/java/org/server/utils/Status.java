package org.server.utils;

public enum Status {
    DATA_ABSENT_MSG("No data!"),
    DATA_INSERT_MSG("Product and Variant were added."),
    DATA_UPDATE_MSG("Updated."),
    DATA_DELETE_MSG("Deleted."),
    SERVER_START_MSG("Server started and waiting for clients..."),
    CLIENT_CLOSE_MSG("quit"),
    SUCCESS_MESSAGE("User with id %s deleted successfully!"),
    FAILURE_MESSAGE("User with id %s is not deleted!");

    private final String message;

    Status (String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
