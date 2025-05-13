package org.example.utils;

public enum ErrorMessage {
    APP_CLOSE_MSG("App closed."),
    INPUT_REQ_MSG("Input required."),
    INCORRECT_VALUE_MSG("Incorrect value! Try again."),
    INCORRECT_OPTION_MSG("Incorrect option! Try again."),
    DATA_ABSENT_MSG("Data is absent.");
    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
