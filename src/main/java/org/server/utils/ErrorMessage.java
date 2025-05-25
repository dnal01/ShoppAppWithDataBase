package org.server.utils;

public enum ErrorMessage {
    APP_CLOSE_MSG("App closed."),
    INPUT_REQ_MSG("Input required."),
    INCORRECT_VALUE_MSG("Incorrect value! Try again."),
    INCORRECT_OPTION_MSG("Incorrect option! Try again."),
    DATA_ABSENT_MSG("Data is absent."),
    LOG_DATA_INPTS_WRONG_MSG("Data inputs incorrect."),
    LOG_DATA_ABSENT_MSG("Data is absent."),
    LOG_DB_ERROR_MSG("DB manipulations error."),
    DB_ABSENT_MSG("Database is absent."),
    LOG_CLIENT_ERROR_MSG("Client error."),
    LOG_SERVER_ERROR_MSG("Server error.");
    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
