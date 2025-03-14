package com.obando.curso.springboot.jpa.repositories;

import com.obando.curso.springboot.jpa.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    @Query("select distinct(p.firstname) from Person p")
    List<String> findAllNames();

    List<Person> findByProgrammingLanguage(String programmingLanguage);
    List<Person> findByProgrammingLanguageAndFirstname(String programmingLanguage, String firstname);

}
