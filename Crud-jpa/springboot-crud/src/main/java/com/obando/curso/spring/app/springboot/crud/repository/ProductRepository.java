package com.obando.curso.spring.app.springboot.crud.repository;

import com.obando.curso.spring.app.springboot.crud.entities.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
}
