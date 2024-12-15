package com.obando.springcloud.msvc.items.clients;

import com.obando.springcloud.msvc.items.models.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(url = "localhost:8080", name = "Products")
public interface ProductFeignClient {

    @GetMapping("api/products")
    List<Product> findAll();

    @GetMapping("api/products/{id}")
    Product details(@PathVariable Long id);
}
