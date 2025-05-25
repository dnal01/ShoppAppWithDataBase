package org.server.data;

public class ResponseData {

    private int intValue;

    public int getIntValue() {
        return intValue;
    }

    public void setIntValue(int intValue) {
        this.intValue = intValue;
    }

    @Override
    public String toString() {
        return "\nResponseData > " +
                "Product cost is EUR " + intValue;
    }
}
