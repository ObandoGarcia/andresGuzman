package com.obando.curso.spring.app.springboot.crud.services;

import com.obando.curso.spring.app.springboot.crud.entities.Product;
import com.obando.curso.spring.app.springboot.crud.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Product> findAll() {
        return (List<Product>) productRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    @Transactional
    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Transactional
    @Override
    public Optional<Product> update(Long id, Product product) {
        Optional<Product> productDb = productRepository.findById(id);
        if(productDb.isPresent()){
            Product prod = productDb.orElseThrow();

            prod.setName(product.getName());
            prod.setDescription(product.getDescription());
            prod.setPrice(product.getPrice());
            return Optional.of(productRepository.save(prod));
        }

        return productDb;
    }

    @Transactional
    @Override
    public Optional<Product> delete(Long id) {
        Optional<Product> productDb = productRepository.findById(id);
        productDb.ifPresent(prod -> {
            productRepository.delete(productDb.orElseThrow());
        });

        return productDb;
    }
}
