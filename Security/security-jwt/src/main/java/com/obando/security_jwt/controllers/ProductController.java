package com.obando.security_jwt.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @GetMapping
    public String listarProductos(){
        return "Lista de productos para la venta vacia";
    }
}
