package com.mitrais.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class AuthController {

    @GetMapping("/")
    public String index(Model model, Principal principal) {
        model.addAttribute("message", "logged in as " + principal.getName());

        return "index";
    }
}
