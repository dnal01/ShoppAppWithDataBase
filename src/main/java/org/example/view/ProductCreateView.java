package org.example.view;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ProductCreateView {

    public Map<String, String> getData() {
        Scanner sc = new Scanner(System.in);
        Map<String, String> productData = new HashMap<>();
        System.out.println("Enter product description (min 12 chars):");
        productData.put("description", sc.nextLine().trim());
        System.out.println("Enter product title (min 3 chars):");
        productData.put("title", sc.nextLine().trim());
        System.out.println("Enter product category (min 3 chars):");
        productData.put("category", sc.nextLine().trim());
        System.out.println("Enter product typeId (1 for natural 2 for artificial):");
        productData.put("typeId", sc.nextLine().trim());
        System.out.println("Enter product vendorId (1 for A 2 for B:");
        productData.put("vendorId", sc.nextLine().trim());
        System.out.println("Enter product groupById (1 for Bread 2 for others):");
        productData.put("groupById", sc.nextLine().trim());
        System.out.println("Is product Weiged (true/false) :");
        productData.put("isWeiged", sc.nextLine().trim());
        System.out.println("Enter product measure Unit (ml, g, etc.):");
        productData.put("measureUnit", sc.nextLine().trim());
        System.out.println("Enter variant media (picture name):");
        productData.put("media", sc.nextLine().trim());
        System.out.println("Enter variant barcode :");
        productData.put("barcode", sc.nextLine().trim());
        System.out.println("Enter variant cost (in decimal format):");
        productData.put("cost", sc.nextLine().trim());
        System.out.println("Enter variant margin (in decimal format):");
        productData.put("margin", sc.nextLine().trim());
        System.out.println("Enter variant price (in decimal format):");
        productData.put("price", sc.nextLine().trim());
        return productData;

    }
    public void getOutput(String output) {
        System.out.println(output);
    }

}
