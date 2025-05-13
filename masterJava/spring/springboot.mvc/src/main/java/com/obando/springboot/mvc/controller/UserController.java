package com.obando.springboot.mvc.controller;

import com.obando.springboot.mvc.enity.User;
import com.obando.springboot.mvc.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/users")
@SessionAttributes("user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    /* @GetMapping("/view")
    public String details(Model model){

        model.addAttribute("message", "Hola mundo desde Spring Boot 3!");
        model.addAttribute("user", new User(
                1L,
                "Jose Manuel",
                "Obando Garcia",
                "obandogarcia10635@gmail.com",
                "obando310"));
        return "view";
    }*/

    @GetMapping
    public String list(Model model){

        model.addAttribute("title", "Listado de usuarios");
        model.addAttribute("users", userService.findAll());
        return "list";
    }

    @GetMapping("/form")
    public String form(Model model){

        model.addAttribute("title", "Formulario de usuario");
        model.addAttribute("user", new User());
        return "form";
    }

    @GetMapping("/form/{id}")
    public String form(@PathVariable Long id, Model model, RedirectAttributes redirectAttributes){

        Optional<User> optionalUser = userService.findById(id);
        if (optionalUser.isPresent()){
            model.addAttribute("user", optionalUser.get());
            model.addAttribute("title", "Editar usuario");
            return "form";
        } else {
            redirectAttributes.addFlashAttribute("error", "El usuario con el id: "
                    + id +" no existe!");
            return "redirect:/users";
        }
    }

    @PostMapping
    public String form(User user, BindingResult bindingResult,
                       Model model, RedirectAttributes redirectAttributes,
                       SessionStatus sessionStatus){

        if (bindingResult.hasErrors()){
            model.addAttribute("title", "Validacion de formulario");
            return "form";
        }

        String message = (user.getId() != null && user.getId() > 0) ? "El usuario"
                + user.getName() + " se ha actualizado correctamente" : "El usuario"
                + user.getName() + " se ha creado correctamente";

        userService.save(user);
        sessionStatus.setComplete();
        redirectAttributes.addFlashAttribute("success", message);

        return "redirect:/users";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id, RedirectAttributes redirectAttributes){

        Optional<User> optionalUser = userService.findById(id);
        if (optionalUser.isPresent()) {
            redirectAttributes.addFlashAttribute("success", "El usuario"
                    + optionalUser.get().getName() +
                    " se ha eliminado correctamente");
            userService.delete(id);
            return "redirect:/users";
        }

        redirectAttributes.addFlashAttribute("error", "El usuario con el id: "
                + id +
                " no existe en el sistema");
        return "redirect:/users";
    }
}
