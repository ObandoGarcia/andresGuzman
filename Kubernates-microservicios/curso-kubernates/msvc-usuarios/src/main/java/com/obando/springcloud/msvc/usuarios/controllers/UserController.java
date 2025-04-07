package com.obando.springcloud.msvc.usuarios.controllers;

import com.obando.springcloud.msvc.usuarios.models.User;
import com.obando.springcloud.msvc.usuarios.services.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> listUsers(){
        return userService.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<User> userDetails(@PathVariable Long id){
        Optional<User> userOptional = userService.findById(id);

        return userOptional
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity
                        .notFound()
                        .build());
    }

    @PostMapping
    //@ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> createUser(@Valid @RequestBody User user, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            Map<String, String> errors = new HashMap<>();

            bindingResult.getFieldErrors().forEach(error -> {
                errors.put(error.getField(), "El campo: " + error.getField() + " " + error.getDefaultMessage());
            });

            return ResponseEntity.badRequest().body(errors);
        }

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(userService.save(user));
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> editUser(@RequestBody User user, @PathVariable Long id){
        Optional<User> userOptional = userService.findById(id);

        if (userOptional.isPresent()){
            User userDb = userOptional.get();
            userDb.setName(user.getName());
            userDb.setEmail(user.getEmail());
            userDb.setPassword(user.getPassword());

            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(userService.save(userDb));
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<User> deleteUserById(@PathVariable Long id){
        Optional<User> userOptional = userService.findById(id);

        if (userOptional.isPresent()){
            userService.deleteById(id);

            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }
}