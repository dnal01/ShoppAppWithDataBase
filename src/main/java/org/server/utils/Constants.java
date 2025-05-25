package org.server.utils;

public enum Constants {
    BASE_PATH_LOGS_CONFIG("src/main/resources/config/"),
    BASE_PATH_INFO_LOGS("MY_LOGS/"),
    HOST("localhost"),
    PORT("8080");
    private final String value;

    Constants(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
