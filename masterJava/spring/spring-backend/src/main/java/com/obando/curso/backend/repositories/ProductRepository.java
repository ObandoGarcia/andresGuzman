package com.obando.curso.backend.repositories;

import com.obando.curso.backend.entities.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
}
