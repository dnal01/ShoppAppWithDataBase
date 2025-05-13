package org.example.entities;

import java.util.Map;

public class ProductMapper {
    public Product mapProductData(Map<String, String> productData) {
        Product product = new Product();

        product.setDescription(productData.get("description"));
        product.setTitle(productData.get("title"));
        product.setCategory(productData.get("category"));
        product.setTypeId(Integer.parseInt(productData.get("typeId")));
        product.setVendorId(Integer.parseInt(productData.get("vendorId")));
        product.setGroupById(Integer.parseInt(productData.get("groupById")));
        product.setIsWeiged(Boolean.parseBoolean(productData.get("isWeiged")));
        product.setMeasureUnit(productData.get("measureUnit"));

        return product;
    }
}
