package com.obando.springcloud.msvc.repositories;

import com.obando.springcloud.msvc.entities.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {

}
