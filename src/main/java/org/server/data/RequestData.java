package org.server.data;

public class RequestData {

    private int intValue;
    private String stringValue;

    public int getIntValue() {
        return intValue;
    }

    public void setIntValue(int intValue) {
        this.intValue = intValue;
    }

    public String getStringValue() {
        return stringValue;
    }

    public void setStringValue(String stringValue) {
        this.stringValue = stringValue;
    }

    @Override
    public String toString() {
        return "Client1 added > Product quota: " +
                intValue + ", name: " + stringValue;
    }
}
