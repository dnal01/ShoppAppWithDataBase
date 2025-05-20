package org.example.utils;

public enum Entry {
    WRONG_ID_MSG("Wrong id input"),
    WRONG_DESCRIPTION_MSG("Wrong description input"),
    WRONG_TITLE_MSG("Wrong title input"),
    WRONG_CATEGORY_MSG("Wrong category input"),
    WRONG_TYPE_ID_MSG("Wrong typeId input"),
    WRONG_VENDOR_ID_MSG("Wrong vendorId input"),
    WRONG_GROUP_BY_ID_MSG("Wrong groupById input"),
    WRONG_IS_WEIGED_MSG("Wrong isWeiged input"),
    WRONG_MEASURE_UNIT_MSG("Wrong measureUnit input"),
    WRONG_MEDIA_MSG("Wrong media input"),
    WRONG_BARCODE_MSG("Wrong barcode input"),
    WRONG_LEFTOVERS_MSG("Wrong leftovers input"),
    WRONG_COST_MSG("Wrong cost input"),
    WRONG_MARGIN_MSG("Wrong margin input"),
    WRONG_PRICE_MSG("Wrong price input"),
    WRONG_ORDER_LIMITS_MSG("Wrong orderLimits input");

    private final String message;

    Entry(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
