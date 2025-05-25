package org.server.utils;

import java.util.HashMap;
import java.util.Map;

public class AppValidator {
    public final static String ID_RGX = "^[1-9]+$";

    public final static String DESCRIPTION_RGX = "^[a-zA-Z0-9-А-ЩЬЮЯҐЄІЇа-щьюяґєії'`’ʼ%/]{12,612}$";
    public final static String TITLE_RGX = "^[a-zA-Z0-9-А-ЩЬЮЯҐЄІЇа-щьюяґєії'`’ʼ%/]{3,64}$";
    public final static String CATEGORY_RGX = "^[a-zA-Z-А-ЩЬЮЯҐЄІЇа-щьюяґєії'`’ʼ%/]{3,64}$";
    public final static String TYPE_ID_RGX = "^[1-9]{1,65535}$";
    public final static String VENDOR_ID_RGX = "^[1-9]{1,65535}$";
    public final static String GROUP_BY_ID_RGX = "^[1-9]{1,65535}$";
    public final static String IS_WEIGED_RGX = "^true|false$";

    public final static String MEASURE_UNIT_RGX = "^[a-zA-Z0-9-А-ЩЬЮЯҐЄІЇа-щьюяґєії'`’ʼ%/]{1,12}$";
//    public final static String MEDIA_RGX = "^[a-zA-Z-А-ЩЬЮЯҐЄІЇа-щьюяґєії'`’ʼ%/]{1,64}$";
    public final static String MEDIA_RGX = "^[a-zA-Z-А-ЩЬЮЯҐЄІЇа-щьюяґєії]{1,64}$";
    public final static String BARCODE_RGX = "^[0-9]{1,255}$";
    public final static String LEFTOVERS_RGX = "^[0-9]{1,255}$";
    public final static String COST_RGX = "^\\d+(?:[.,]\\d+){1,6}$";
    public final static String MARGIN_RGX = "^\\d+(?:[.,]\\d+){1,6}$";
    public final static String PRICE_RGX = "^\\d+(?:[.,]\\d+){1,6}$";
    public final static String ORDER_LIMITS_RGX = "^[0-9]{1,255}$";

    public static boolean isIdValid(String id) {
        if (id != null)
            return id.isEmpty() || !id.matches(ID_RGX);
        return false;
    }

    public static boolean isDescriptionValid(String phone) {
        if (phone != null)
            return phone.isEmpty() || !phone.matches(DESCRIPTION_RGX);
        return false;
    }

    public static boolean isTitleValid(String email) {
        if (email != null)
            return email.isEmpty() || !email.matches(TITLE_RGX);
        return false;
    }

    public static boolean isCategoryValid(String email) {
        if (email != null)
            return email.isEmpty() || !email.matches(CATEGORY_RGX);
        return false;
    }

    public static boolean isTypeIdValid(String email) {
        if (email != null)
            return email.isEmpty() || !email.matches(TYPE_ID_RGX);
        return false;
    }

    public static boolean isVendorIdValid(String email) {
        if (email != null)
            return email.isEmpty() || !email.matches(VENDOR_ID_RGX);
        return false;
    }

    public static boolean isGroupByIdValid(String email) {
        if (email != null)
            return email.isEmpty() || !email.matches(GROUP_BY_ID_RGX);
        return false;
    }

    public static boolean isIsWeigedValid(String email) {
        if (email != null)
            return email.isEmpty() || !email.matches(IS_WEIGED_RGX);
        return false;
    }

    public static boolean isMeasureUnitValid(String email) {
        if (email != null)
            return email.isEmpty() || !email.matches(MEASURE_UNIT_RGX);
        return false;
    }

    public static boolean isMediaValid(String email) {
        if (email != null)
            return email.isEmpty() || !email.matches(MEDIA_RGX);
        return false;
    }

    public static boolean isBarcodeValid(String email) {
        if (email != null)
            return email.isEmpty() || !email.matches(BARCODE_RGX);
        return false;
    }

    public static boolean isLeftoversValid(String email) {
        if (email != null)
            return email.isEmpty() || !email.matches(LEFTOVERS_RGX);
        return false;
    }

    public static boolean isCostValid(String email) {
        if (email != null)
            return email.isEmpty() || !email.matches(COST_RGX);
        return false;
    }

    public static boolean isMarginValid(String email) {
        if (email != null)
            return email.isEmpty() || !email.matches(MARGIN_RGX);
        return false;
    }

    public static boolean isPriceValid(String email) {
        if (email != null)
            return email.isEmpty() || !email.matches(PRICE_RGX);
        return false;
    }

    public static boolean isOrderLimitsValid(String email) {
        if (email != null)
            return email.isEmpty() || !email.matches(ORDER_LIMITS_RGX);
        return false;
    }

    public static Map<String, String> validateProductData(Map<String, String> data) {

        Map<String, String> errors = new HashMap<>();

        if (data.containsKey("id") & AppValidator.isIdValid(data.get("id")))
            errors.put("id", Entry.WRONG_ID_MSG.getMessage());

        if (data.containsKey("description") & AppValidator.isDescriptionValid(data.get("description")))
            errors.put("description", Entry.WRONG_DESCRIPTION_MSG.getMessage());

        if (data.containsKey("title") & AppValidator.isTitleValid(data.get("title")))
            errors.put("title", Entry.WRONG_TITLE_MSG.getMessage());

        if (data.containsKey("category") & AppValidator.isCategoryValid(data.get("category")))
            errors.put("category", Entry.WRONG_CATEGORY_MSG.getMessage());

        if (data.containsKey("typeId") & AppValidator.isTypeIdValid(data.get("typeId")))
            errors.put("typeId", Entry.WRONG_TYPE_ID_MSG.getMessage());

        if (data.containsKey("vendorId") & AppValidator.isVendorIdValid(data.get("vendorId")))
            errors.put("vendorId", Entry.WRONG_VENDOR_ID_MSG.getMessage());

        if (data.containsKey("groupById") & AppValidator.isGroupByIdValid(data.get("groupById")))
            errors.put("groupById", Entry.WRONG_GROUP_BY_ID_MSG.getMessage());

        if (data.containsKey("isWeiged") & AppValidator.isIsWeigedValid(data.get("isWeiged")))
            errors.put("isWeiged", Entry.WRONG_IS_WEIGED_MSG.getMessage());

        if (data.containsKey("measureUnit") & AppValidator.isMeasureUnitValid(data.get("measureUnit")))
            errors.put("measureUnit", Entry.WRONG_MEASURE_UNIT_MSG.getMessage());

        if (data.containsKey("media") & AppValidator.isMediaValid(data.get("media")))
            errors.put("media", Entry.WRONG_MEDIA_MSG.getMessage());

        if (data.containsKey("barcode") & AppValidator.isBarcodeValid(data.get("barcode")))
            errors.put("barcode", Entry.WRONG_BARCODE_MSG.getMessage());

        if (data.containsKey("leftovers") & AppValidator.isLeftoversValid(data.get("leftovers")))
            errors.put("leftovers", Entry.WRONG_LEFTOVERS_MSG.getMessage());

        if (data.containsKey("cost") & AppValidator.isCostValid(data.get("cost")))
            errors.put("cost", Entry.WRONG_COST_MSG.getMessage());

        if (data.containsKey("margin") & AppValidator.isMarginValid(data.get("margin")))
            errors.put("margin", Entry.WRONG_MARGIN_MSG.getMessage());

        if (data.containsKey("price") & AppValidator.isPriceValid(data.get("price")))
            errors.put("price", Entry.WRONG_PRICE_MSG.getMessage());

        if (data.containsKey("orderLimits") & AppValidator.isOrderLimitsValid(data.get("orderLimits")))
            errors.put("orderLimits", Entry.WRONG_ORDER_LIMITS_MSG.getMessage());

        return errors;
    }
}