package com.obando.springboot_app.controller;

import com.obando.springboot_app.model.dto.ParamDTO;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/params")
public class RequestParamsController {

    @GetMapping("/foo")
    public ParamDTO foo(@RequestParam(required = false, defaultValue = "Mensaje por defecto") String message){
        ParamDTO paramDTO = new ParamDTO();
        paramDTO.setMessage(message);
        return paramDTO;
    }

    @GetMapping("/bar")
    public ParamDTO bar(@RequestParam String text, @RequestParam Integer code){
        ParamDTO paramDTO = new ParamDTO();
        paramDTO.setMessage(text);
        paramDTO.setCode(code);
        return paramDTO;
    }

    @GetMapping("/request")
    public ParamDTO request(HttpServletRequest httpServletRequest){
        ParamDTO paramDTO = new ParamDTO();
        paramDTO.setCode(Integer.parseInt(httpServletRequest.getParameter("code")));
        paramDTO.setMessage(httpServletRequest.getParameter("message"));
        return paramDTO;
    }
}
