package com.obando.spring.mvc.controller;

import com.obando.spring.mvc.models.User;
import com.obando.spring.mvc.models.UserDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/api")
public class UserRestController {

    @GetMapping("/user-details")
    public Map<String, Object> userDetails(){
        Map<String, Object> body = new HashMap<>();

        body.put("title", "Hola mundo desde Spring Boot");
        body.put("name", "Jose Manuel");
        body.put("lastname", "Obando Garcia");

        return body;
    }

    @GetMapping("/user-details-model")
    public User userDetailsModels(){
        User user = new User();
        user.setName("Jose Manuel");
        user.setLastname("Obando Garcia");

        return user;
    }

    @GetMapping("/user-dto-details-model")
    public UserDto userDetailsDto(){
        UserDto userDto = new UserDto();
        User user = new User("Anna", "Gutierrez");
        userDto.setUser(user);
        userDto.setTitle("Hola mundo desde la clase Dto");

        return userDto;
    }

    @GetMapping("/list")
    public List<User> list(){
        User anna = new User("Anna", "Gutierrez");
        User jose = new User("Jose", "Obando");
        User lisa = new User("Lisa", "Doe");

        /* List<User> users = new ArrayList<>();
        users.add(anna);
        users.add(jose);
        users.add(lisa); */

        List<User> users = Arrays.asList(anna, jose, lisa);

        return users;
    }
}
