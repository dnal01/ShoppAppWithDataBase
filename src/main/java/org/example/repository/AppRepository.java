package org.example.repository;

import org.example.entities.Product;
import org.example.entities.Variant;

import java.util.List;
import java.util.Optional;

public interface AppRepository<T> {


    String add(Product product, Variant variant);

    Optional<List<T>> read();
    Optional<T> readById(int id);
    String update(T obj);
    String delete(int id);
}
