package com.obando.springcloud.msvc.services;

import com.obando.springcloud.msvc.entities.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    List<Product> findAll();
    Optional<Product> findById(Long id);
}
