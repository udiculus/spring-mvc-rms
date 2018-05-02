package com.mitrais.springmvc.controller;

import com.mitrais.springmvc.model.Article;
import com.mitrais.springmvc.service.ArticleService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@RestController
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @GetMapping("/article")
    public ModelAndView list() {
       List<Article> articles = articleService.list();
       return new ModelAndView("article/index", "listArticle", articles);
    }

    @GetMapping("/article/view/{id}")
    public ModelAndView view(@PathVariable("id") int id) {
        Article article = articleService.get(id);
        return new ModelAndView("article/view", "article", article);
    }

    @GetMapping("/article/edit/{id}")
    public ModelAndView edit(@PathVariable("id") int id) {
        Article article = articleService.get(id);
        return new ModelAndView("article/edit", "article", article);
    }

    @GetMapping("/article/create")
    public ModelAndView create() {
        return new ModelAndView("article/create");
    }

    @PostMapping("/article/create")
    public ModelAndView insertArticle(@ModelAttribute("article") Article article) {
        if (article.getTitle() != null) {
            System.out.println(article.getTitle());
            System.out.println(article.getContent());
            articleService.save(article);
        }
        return new ModelAndView("article/create");
    }

    @PostMapping("/article/edit/{id}")
    public ModelAndView updateArticle(@ModelAttribute("article") Article article, @PathVariable("id") int id) {
        if (article.getId() > 0) {
            System.out.println(article.getTitle());
            System.out.println(article.getContent());
            articleService.update(article.getId(), article);
            return new ModelAndView("article/edit", "article", article);
        } else {
            return new ModelAndView("redirect:/");
        }
    }

}
