package com.obando.springboot_app.controller;

import com.obando.springboot_app.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.Arrays;
import java.util.List;

@Controller
public class UserController {

    @GetMapping("/details")
    public String details(Model model){
        User user = new User("Anna", "Hernandez", "anna@gmail.com");
        user.setEmail("anna@gmail.com");
        model.addAttribute("title", "Hola mundo desde Spring");
        model.addAttribute("user", user);
        return "details";
    }

    @GetMapping("/list")
    public String list(ModelMap modelMap){
        modelMap.addAttribute("title", "Listado de Usuarios");

        return "list";
    }

    @ModelAttribute("users")
    public List<User> userModel(){
        return Arrays.asList(
                new User("Jose", "Obando","jose@@gmail.com"),
                new User("Anna", "Hernandez","anna@gmail.com"),
                new User("Andres", "Guzman", "andres@gmail.com")
        );
    }
}
