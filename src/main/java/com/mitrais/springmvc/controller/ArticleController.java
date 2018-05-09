package com.mitrais.springmvc.controller;

import com.google.gson.Gson;
import com.mitrais.springmvc.model.Article;
import com.mitrais.springmvc.model.Comment;
import com.mitrais.springmvc.model.response.CommentResponse;
import com.mitrais.springmvc.service.ArticleService;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;

import com.mitrais.springmvc.validator.ArticleValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @GetMapping("/article")
    public ModelAndView list(ModelMap model, Principal principal) {
        model.addAttribute("message", "You are logged in as " + principal.getName());
        List<Article> articles = articleService.list();
        return new ModelAndView("article/index", "listArticle", articles);
    }

    @GetMapping("/article/view/{id}")
    public String view(ModelMap modelMap, @PathVariable("id") int id, @ModelAttribute("comment") Comment comment) {
        Article article = articleService.get(id);
        List<Comment> comments = article.getComments();
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
    @PreAuthorize("hasRole('ROLE_AUTHOR')")
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

    @ResponseBody
    @RequestMapping(value = "/article/comment", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public String insertComment(@ModelAttribute("comment") Comment comment, BindingResult result) {
        ArticleValidator.PostComment validator = new ArticleValidator.PostComment();
        validator.validate(comment, result);
        CommentResponse commentResponse = new CommentResponse();
        Gson gson = new Gson();

        if (!result.hasErrors()) {
            commentResponse.setErrorcode(0);
            commentResponse.setMessage("Comment has been saved");
            comment.setUserId(1);
            articleService.postComment(comment);

            String json = gson.toJson(commentResponse);
            return json;
        } else {
            commentResponse.setErrorcode(1000);
            commentResponse.setMessage("Error saving user's comment");

            List<FieldError> errors = result.getFieldErrors();
            HashMap<String, String> formError = new HashMap<String, String>();
            for (FieldError error : errors ) {
                formError.put(error.getObjectName(), error.getDefaultMessage());
            }
            commentResponse.setFormError(formError);

            String json = gson.toJson(commentResponse);
            return json;
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
