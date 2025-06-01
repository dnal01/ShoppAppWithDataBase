package org.server.repository.product;


import org.server.dto.ProductDtoRequest;
import org.server.entities.Product;
import org.server.repository.BaseRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends BaseRepository<Product, ProductDtoRequest> {
    // Створення нового запису
    void save(ProductDtoRequest request);
    // Отримання всіх записів
    Optional<List<Product>> getAll();
    // Отримання запису за id
    Optional<Product> getById(Long id);
    // Оновлення запису за id
    void update(Long id, ProductDtoRequest request);
    // Видалення запису за id
    boolean deleteById(Long id);

    Optional<Product> getLastEntity();
}
