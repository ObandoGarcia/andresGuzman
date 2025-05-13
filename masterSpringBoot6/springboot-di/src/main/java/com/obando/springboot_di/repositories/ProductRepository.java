package com.obando.springboot_di.repositories;

import com.obando.springboot_di.models.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
}
