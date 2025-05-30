package org.server.services.product;

import jakarta.inject.Inject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.server.dto.ProductDtoRequest;
import org.server.entities.Product;
import org.server.repository.product.ProductRepository;

import java.util.List;
import java.util.Objects;

public class ProductServiceImp implements ProductService {
    @Inject
    private ProductRepository repository;

    private static final Logger LOGGER =
            LogManager.getLogger(ProductServiceImp.class);

    @Override
    public Product create(ProductDtoRequest request) {
        Objects.requireNonNull(request,
                "Parameter [request] must not be null!");
        repository.save(request);
        return repository.getLastEntity()
                .orElse(null);
    }

    @Override
    public List<Product> getAll() {
        return repository.getAll()
                .orElse(Collections.emptyList());
    }

    @Override
    public Product getById(Long id) {
        Objects.requireNonNull(id,
                "Parameter [id] must not be null!");
        return repository.getById(id).orElse(null);
    }

    @Override
    public Product update(Long id, ProductDtoRequest request) {
        Objects.requireNonNull(request,
                "Parameter [request] must not be null!");
        if (id == null) {
            throw new IllegalArgumentException("Id must be provided!");
        }
        if (repository.getById(id).isPresent()) {
            repository.update(id, request);
        }
        return repository.getById(id).orElse(null);
    }

    @Override
    public boolean deleteById(Long id) {
        Objects.requireNonNull(id,
                "Parameter [id] must not be null!");
        if (repository.getById(id).isPresent()) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}
