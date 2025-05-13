package com.obando.curso.backend.controllers;

import com.obando.curso.backend.entities.Product;
import com.obando.curso.backend.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<Product>> list(){
        return ResponseEntity.ok(productService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> details(@PathVariable Long id){

        Optional<Product> optionalProduct = productService.findById(id);
        if (optionalProduct.isPresent()){
            return ResponseEntity.ok(optionalProduct.orElseThrow());
        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Product> create(@RequestBody Product product){

        return ResponseEntity.status(HttpStatus.CREATED).body(productService.save(product));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> update(@RequestBody Product product, @PathVariable Long id){

        Optional<Product> optionalProduct = productService.findById(id);
        if (optionalProduct.isPresent()){
            Product productDb = optionalProduct.orElseThrow();
            productDb.setDescription(product.getDescription());
            productDb.setName(product.getName());
            productDb.setPrice(product.getPrice());

            return  ResponseEntity.status(HttpStatus.CREATED).body(productService.save(productDb));
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Product> delete(@PathVariable Long id){

        Optional<Product> optionalProduct = productService.deleteById(id);
        if (optionalProduct.isPresent()){
            Product productDeleted = optionalProduct.orElseThrow();
            return ResponseEntity.status(HttpStatus.OK).body(productDeleted);
        }

        return ResponseEntity.notFound().build();
    }

}
