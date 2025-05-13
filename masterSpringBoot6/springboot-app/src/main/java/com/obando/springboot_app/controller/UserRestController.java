package com.obando.springboot_app.controller;

import com.obando.springboot_app.model.User;
import com.obando.springboot_app.model.dto.UserDTO;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/mvc")
public class UserRestController {

    @GetMapping("/details-rest")
    public UserDTO details(Model model){

        User user = new User("Anna", "Hernandez", "anna@gmail.com");

        UserDTO userDTO = new UserDTO();
        userDTO.setTitle("Hola mundo desde Spring");
        userDTO.setUser(user);

        /*Map<String, Object> body = new HashMap<>();

        body.put("title", "Hola mundo desde Spring");
        body.put("user", user);*/

        return userDTO;
    }

    @GetMapping("/list")
    public List<User> userList(){
        User user = new User("Andres", "Guzman","jose@@gmail.com");
        User user2 = new User("Jose", "Obando", "anna@gmail.com");
        User user3 = new User("Jhon", "Doe", "andres@gmail.com");

        List<User> users = new ArrayList<>();
        users.add(user);
        users.add(user2);
        users.add(user3);

        return users;
    }
}
