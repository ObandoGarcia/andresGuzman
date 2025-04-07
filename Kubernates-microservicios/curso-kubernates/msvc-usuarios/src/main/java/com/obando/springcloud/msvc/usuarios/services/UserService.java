package com.obando.springcloud.msvc.usuarios.services;

import com.obando.springcloud.msvc.usuarios.models.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> findAll();

    Optional<User> findById(Long id);

    User save(User user);

    void deleteById(Long id);
}
