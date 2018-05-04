package com.mitrais.springmvc.controller;

import com.mitrais.springmvc.model.Article;
import com.mitrais.springmvc.model.Comment;
import com.mitrais.springmvc.service.ArticleService;

import java.util.List;

import com.mitrais.springmvc.validator.ArticleValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @GetMapping("/article")
    public ModelAndView list() {
       List<Article> articles = articleService.list();
       return new ModelAndView("article/index", "listArticle", articles);
    }

    @GetMapping("/article/view/{id}")
    public String view(ModelMap modelMap, @PathVariable("id") int id) {
        Article article = articleService.get(id);
        List<Comment> comments = articleService.getComments();
        modelMap.addAttribute("comments", comments);
        modelMap.addAttribute("article", article);
        return "article/view";
    }

    @GetMapping("/article/edit/{id}")
    public ModelAndView edit(@PathVariable("id") int id) {
        Article article = articleService.get(id);
        return new ModelAndView("article/edit", "article", article);
    }

    @GetMapping("/article/create")
    public ModelAndView create(ModelMap model) {
        return new ModelAndView("article/create", "article", new Article());
    }

    @PostMapping("/article/create")
    public String insertArticle(ModelMap model, @ModelAttribute("article") Article article, BindingResult result) {
        ArticleValidator.Create validator = new ArticleValidator.Create();
        validator.validate(article, result);

        if (!result.hasErrors()) {
            System.out.println(article.getTitle());
            System.out.println(article.getContent());
            articleService.save(article);
            return "redirect:/";
        } else {
            model.addAttribute("title", article.getTitle());
            model.addAttribute("content", article.getContent());
            return "/article/create";
        }
    }

    @PostMapping("/article/edit/{id}")
    public String updateArticle(ModelMap model, @ModelAttribute("article") Article article, BindingResult result) {
        ArticleValidator.Update validator = new ArticleValidator.Update();
        validator.validate(article, result);

        if (!result.hasErrors()) {
            System.out.println(article.getId());
            System.out.println(article.getTitle());
            System.out.println(article.getContent());
            articleService.update(article.getId(), article);
            return "redirect:/";
        } else {
            model.addAttribute("title", article.getTitle());
            model.addAttribute("content", article.getContent());
            return "/article/edit";
        }
    }

    @GetMapping("/article/delete/{id}")
    public String deleteArticle(@PathVariable("id") int id) {
        Article article = articleService.get(id);
        if (article != null) {
            articleService.delete(id);
        }

        return "redirect:/";
    }

}
