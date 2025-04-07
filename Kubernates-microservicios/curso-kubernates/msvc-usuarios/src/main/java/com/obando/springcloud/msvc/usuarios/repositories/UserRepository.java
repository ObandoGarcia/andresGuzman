package com.obando.springcloud.msvc.usuarios.repositories;

import com.obando.springcloud.msvc.usuarios.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
}
