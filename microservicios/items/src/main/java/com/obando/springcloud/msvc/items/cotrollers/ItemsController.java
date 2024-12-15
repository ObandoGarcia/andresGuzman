package com.obando.springcloud.msvc.items.cotrollers;

import com.obando.springcloud.msvc.items.models.Items;
import com.obando.springcloud.msvc.items.services.ItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
public class ItemsController {
    private final ItemService itemService;

    public ItemsController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping
    public List<Items> listItem(){
        return itemService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> details(@PathVariable Long id) {
        Optional itemOptinal = itemService.findById(id);
        if (itemOptinal.isPresent()) {
            return ResponseEntity.ok(itemOptinal.get());
        }

        return ResponseEntity.status(404).body(Collections.singletonMap("message", "No existe el producto el microservicio products"));
    }
}
