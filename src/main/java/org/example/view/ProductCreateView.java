package org.example.view;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ProductCreateView {

    public Map<String, String> getData() {
        Scanner sc = new Scanner(System.in);
        Map<String, String> productData = new HashMap<>();
        System.out.println("Enter product description :");
        productData.put("description", sc.nextLine().trim());
        System.out.println("Enter product title :");
        productData.put("title", sc.nextLine().trim());
        System.out.println("Enter product category :");
        productData.put("category", sc.nextLine().trim());
        System.out.println("Enter product typeId :");
        productData.put("typeId", sc.nextLine().trim());
        System.out.println("Enter product vendorId :");
        productData.put("vendorId", sc.nextLine().trim());
        System.out.println("Enter product groupById :");
        productData.put("groupById", sc.nextLine().trim());
        System.out.println("Is product Weiged (true/false) :");
        productData.put("isWeiged", sc.nextLine().trim());
        System.out.println("Enter product measure Unit :");
        productData.put("measureUnit", sc.nextLine().trim());
        System.out.println("Enter variant media :");
        productData.put("media", sc.nextLine().trim());
        System.out.println("Enter variant barcode :");
        productData.put("barcode", sc.nextLine().trim());
        System.out.println("Enter variant cost :");
        productData.put("cost", sc.nextLine().trim());
        System.out.println("Enter variant margin :");
        productData.put("margin", sc.nextLine().trim());
        System.out.println("Enter variant price :");
        productData.put("price", sc.nextLine().trim());
        return productData;

    }
    public void getOutput(String output) {
        System.out.println(output);
    }

}
