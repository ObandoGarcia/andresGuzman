package com.obando.springcloud.msvc.items.services;

import com.obando.springcloud.msvc.items.clients.ProductFeignClient;
import com.obando.springcloud.msvc.items.models.Items;
import com.obando.springcloud.msvc.items.models.Product;
import feign.FeignException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class ItemServiceFeign implements ItemService{

    private final ProductFeignClient productFeignClient;

    public ItemServiceFeign(ProductFeignClient productFeignClient) {
        this.productFeignClient = productFeignClient;
    }

    @Override
    public List<Items> findAll() {
        return productFeignClient.findAll()
                .stream()
                .map(product -> {
                    Random random = new Random();
                    return new Items(product, random.nextInt(10) + 1);
                }).collect(Collectors.toList());
    }

    @Override
    public Optional<Items> findById(Long id) {
        try{
            Product product = productFeignClient.details(id);
            return Optional.of(new Items(product, new Random().nextInt(10) + 1));
        }catch (FeignException feignException){
            return Optional.empty();
        }
    }
}
