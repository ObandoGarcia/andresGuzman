package com.obando.springboot_di.repositories;

import com.obando.springboot_di.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
