package org.example.entities;

import java.util.Map;

public class VariantMapper {
    public Variant mapVariantData(Map<String, String> productData) {
        Variant variant = new Variant();
        if (productData.containsKey("id")) {
            variant.setId(Integer.parseInt(productData.get("id")));
        }
        variant.setMedia(productData.get("media"));
        variant.setBarcode(Integer.parseInt(productData.get("barcode")));
        variant.setCost(Double.parseDouble(productData.get("cost")));
        variant.setMargin(Double.parseDouble(productData.get("margin")));
        variant.setPrice(Double.parseDouble(productData.get("price")));
        // activate when setting it
//        variant.setOrderLimits(Integer.parseInt(productData.get("orderLimits")));
        // Set product id when from reading the table after it was generated.
//        variant.setProductId(Integer.parseInt(productData.get("productId")));

        return variant;
    }
}
