package com.obando.springboot.mvc.repository;

import com.obando.springboot.mvc.enity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
}
