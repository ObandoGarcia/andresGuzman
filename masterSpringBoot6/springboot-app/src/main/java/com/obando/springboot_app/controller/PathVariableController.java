package com.obando.springboot_app.controller;

import com.obando.springboot_app.model.User;
import com.obando.springboot_app.model.dto.ParamDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/var")
public class PathVariableController {

    @Value("${config.username}")
    private String username;

    @Value("${config.message}")
    private String message;

    @Value("${config.listOfValues}")
    private String[] listOfValues;

    @Value("${config.code}")
    private Integer code;

    @GetMapping("/vaz/{message}")
    public ParamDTO bazz(@PathVariable String message){
        ParamDTO paramDTO = new ParamDTO();
        paramDTO.setMessage(message);
        return paramDTO;
    }

    @GetMapping("/mix/{product}/{id}")
    public Map<String, Object> mixPathVariable(
            @PathVariable String product,
            @PathVariable Long id
    ){
        Map<String, Object> json = new HashMap<>();
        json.put("product", product);
        json.put("id", id);

        return json;
    }

    @PostMapping("/create")
    public User createUser(@RequestBody User user){
        return user;
    }

    @GetMapping("/values")
    public Map<String, Object> values(){
        Map<String, Object> json = new HashMap<>();
        json.put("username", username);
        json.put("code", code);
        json.put("list of values", listOfValues);
        json.put("message", message);

        return json;
    }

}
