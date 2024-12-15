package com.obando.springcloud.msvc.items.services;

import com.obando.springcloud.msvc.items.models.Items;

import java.util.List;
import java.util.Optional;

public interface ItemService {

    List<Items> findAll();
    Optional<Items> findById(Long id);
}
