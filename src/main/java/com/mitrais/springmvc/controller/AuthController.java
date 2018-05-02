package com.mitrais.springmvc.controller;

import com.mitrais.springmvc.model.Article;
import com.mitrais.springmvc.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class AuthController {

    @Autowired
    private ArticleService articleService;

    @GetMapping("/")
    public ModelAndView list() {
        List<Article> articles = articleService.list();
        return new ModelAndView("article/index", "listArticle", articles);
    }
}
