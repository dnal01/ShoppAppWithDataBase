//package org.server.repositories;
//
//import org.server.dto.ProductDtoRequest;
//import org.server.repository.product.ProductRepository;
//import org.junit.jupiter.api.*;
//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.ValueSource;
//import org.server.repository.product.ProductRepositoryImp;
//
//import java.util.Map;
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//public class ProductRepositoryTest {
//    private ProductRepositoryImp repository;
//    @BeforeEach
//    void setUp() {
//        repository = new ProductRepositoryImp();
//    }
//
//    @AfterEach
//    void tearDown() {
//        repository = null;
//    }
//
//    @ParameterizedTest
//    @DisplayName("Product is added")
//
//    void givenResult_WhenAddProduct_ThenResultIsRight() {
//        Map<String,String> hashMapProvider = Map.ofEntries(
//                Map.entry("description", "ThisIsANewProductFromRESTFullAPI"),
//                Map.entry("title", "Bread"),
//                Map.entry("category", "Bakery"),
//                Map.entry("typeId", "1"),
//                Map.entry("vendorId", "1"),
//                Map.entry("groupById", "1"),
//                Map.entry("isWeiged", "true"),
//                Map.entry("measureUnit", "ml"),
//                Map.entry("media", "Багет"),
//                Map.entry("barcode", "123"),
//                Map.entry("cost", "2.5"),
//                Map.entry("margin", "0.5"),
//                Map.entry("price", "3.5"));
//        assertEquals("Created.", repository.save(new ProductDtoRequest(
//                String description,
//                String title,
//                String category,
//                int typeId,
//                int vendorId,
//                int groupById,
//                boolean isWeiged,
//                String measureUnit,
//                String media,
//                int barcode,
//                double cost,
//                double margin,
//                double price
//        )));
//    }
//
//    void givenResult_WhenReadById_ThenResultIsRight(int value) {
//        assertNotEquals(Optional.empty(), repository.getById(value));
//    }
//}