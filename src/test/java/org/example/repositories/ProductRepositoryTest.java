package org.example.repositories;

import org.example.repository.impl.ProductRepository;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class ProductRepositoryTest {
    private ProductRepository repository;
    @BeforeEach
    void setUp() {
        repository = new ProductRepository();
    }

    @AfterEach
    void tearDown() {
        repository = null;
    }

    @ParameterizedTest
    @DisplayName("Product is read by Id")
    @ValueSource(ints = {1, 2, 3, 13, 14})
    void givenResult_WhenReadById_ThenResultIsRight(int value) {
        assertNotEquals(Optional.empty(), repository.readById(value));
    }
}