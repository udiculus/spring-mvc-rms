package com.mitrais.springmvc.controller;

import com.mitrais.springmvc.model.Article;
import com.mitrais.springmvc.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.Collection;
import java.util.List;

@Controller
public class AuthController {

    @Autowired
    private ArticleService articleService;

    @GetMapping("/")
    public ModelAndView list(ModelMap model, Principal principal) {
        if (principal != null) {
            model.addAttribute("message", "You are logged in as " + principal.getName());
            System.out.println(principal.getName());
        }
        Collection<SimpleGrantedAuthority> authorities = (Collection<SimpleGrantedAuthority>) SecurityContextHolder.getContext().getAuthentication().getAuthorities();
        System.out.println(authorities);
        // Generate password
        System.out.println(new BCryptPasswordEncoder().encode("author123"));
        List<Article> articles = articleService.list();
        return new ModelAndView("article/index", "listArticle", articles);
    }
}
