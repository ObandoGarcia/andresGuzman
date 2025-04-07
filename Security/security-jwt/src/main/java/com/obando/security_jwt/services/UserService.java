package com.obando.security_jwt.services;

import com.obando.security_jwt.entities.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {

    List<User> findAll();
    User save(User user);
}
