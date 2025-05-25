package org.server.exceptions;

import java.util.Map;

public class ProductException extends RuntimeException {
    Map<String, String> errors;
    public ProductException(String message, Map<String, String> errors) {
        super(message);
        this.errors = errors;
    }

    public String getErrors(Map<String, String> errors) {
        this.errors = errors;
        StringBuilder sb = new StringBuilder();
        errors.forEach((key, value) -> sb.append(key).append(" : ").append(value).append("\n"));
        return sb.toString();
    }
}
