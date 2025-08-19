package br.com.ForumHub_ONE.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ola")
@SecurityRequirement(name = "bearer-key")
public class HelloController {

    @GetMapping
    public String ola(){
        return "Ola Mundo";
    }
}
