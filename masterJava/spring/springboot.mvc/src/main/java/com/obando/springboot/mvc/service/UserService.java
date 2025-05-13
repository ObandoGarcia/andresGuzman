package com.obando.springboot.mvc.service;

import com.obando.springboot.mvc.enity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> findAll();

    Optional<User> findById(Long id);

    User save(User user);

    void delete(Long id);
}
