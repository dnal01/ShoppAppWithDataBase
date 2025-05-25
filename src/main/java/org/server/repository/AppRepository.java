package org.server.repository;

import java.util.List;
import java.util.Optional;

public interface AppRepository<T, S> {


    String add(T product, S variant);

    Optional<List<T>> read();
    Optional<T> readById(int id);
    String update(T obj);
    String delete(int id);
}
