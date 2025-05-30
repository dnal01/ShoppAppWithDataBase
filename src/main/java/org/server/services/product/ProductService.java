package org.server.services.product;

import org.server.dto.ProductDtoRequest;
import org.server.entities.Product;
import org.server.services.BaseService;

import java.util.List;

public interface ProductService extends BaseService<Product, ProductDtoRequest> {
    // Створення нового запису
    Product create(ProductDtoRequest request);
    // Отримання всіх записів
    List<Product> getAll();
    // Отримання запису за id
    Product getById(Long id);
    // Оновлення запису за id
    Product update(Long id, ProductDtoRequest request);
    // Видалення запису за id
    boolean deleteById(Long id);
}
