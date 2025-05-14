package org.example.services;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.Map.entry;
import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ProductServiceTest {
    private ProductService service;
    @BeforeEach
    void setUp() {
        service = new ProductService();
    }


    @Test
    @Order(1)
    @DisplayName("Product is added.")
    void givenResult_WhenAddProduct_ThenResultIsRight() {
        Map<String,String> hashMapProvider = Map.ofEntries(
                Map.entry("description", "Thisproductstasteisverygreatyoucanbuyitrightnow"),
                Map.entry("title", "Bread"),
                Map.entry("category", "Bakery"),
                Map.entry("typeId", "1"),
                Map.entry("vendorId", "1"),
                Map.entry("groupById", "1"),
                Map.entry("isWeiged", "true"),
                Map.entry("measureUnit", "ml"),
                Map.entry("media", "Багет"),
                Map.entry("barcode", "123"),
                Map.entry("cost", "2.5"),
                Map.entry("margin", "0.5"),
                Map.entry("price", "3.5"));
        assertEquals("Created.", service.add(hashMapProvider));
    }
    @Test
    @Order(2)
    @DisplayName("Product is deleted.")
    void givenResult_WhenDeleteProduct_ThenResultIsRight() {
        Map<String, String> data = new HashMap<>();
        data.put("id", "1");
        assertEquals("Deleted.", service.delete(data));
    }

    @AfterEach
    void tearDown() {
        service = null;
    }
}