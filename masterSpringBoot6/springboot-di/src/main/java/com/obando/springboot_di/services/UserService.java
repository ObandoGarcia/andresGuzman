package com.obando.springboot_di.services;

import com.obando.springboot_di.models.User;

import java.util.List;

public interface UserService {

    List<User> findAll();

    User save(User user);
}
