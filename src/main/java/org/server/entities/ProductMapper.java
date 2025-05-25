package org.server.entities;

import java.util.Map;

public class ProductMapper {
    public Product mapProductData(Map<String, String> productData) {
        Product product = new Product();
        if (productData.containsKey("id"))
            product.setId(Integer.parseInt(productData.get("id")));

        if (productData.containsKey("description"))
            product.setDescription(productData.get("description"));

        if (productData.containsKey("title"))
            product.setTitle(productData.get("title"));

        if (productData.containsKey("category"))
            product.setCategory(productData.get("category"));

        if (productData.containsKey("typeId"))
            product.setTypeId(Integer.parseInt(productData.get("typeId")));

        if (productData.containsKey("vendorId"))
            product.setVendorId(Integer.parseInt(productData.get("vendorId")));

        if (productData.containsKey("groupById"))
            product.setGroupById(Integer.parseInt(productData.get("groupById")));

        if (productData.containsKey("isWeiged"))
            product.setIsWeiged(Boolean.parseBoolean(productData.get("isWeiged")));

        if (productData.containsKey("measureUnit"))
            product.setMeasureUnit(productData.get("measureUnit"));

        return product;
    }
}
