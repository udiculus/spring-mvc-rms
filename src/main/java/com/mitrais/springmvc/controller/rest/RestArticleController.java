package com.mitrais.springmvc.controller.rest;

import com.mitrais.springmvc.model.Article;
import com.mitrais.springmvc.model.Comment;
import com.mitrais.springmvc.model.ResponseStatus;
import com.mitrais.springmvc.payload.response.ArticleDetailResponse;
import com.mitrais.springmvc.payload.response.ArticleResponse;
import com.mitrais.springmvc.payload.response.FormResponse;
import com.mitrais.springmvc.security.CurrentUser;
import com.mitrais.springmvc.security.UserPrincipal;
import com.mitrais.springmvc.service.ArticleService;
import com.mitrais.springmvc.validator.ArticleValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
public class RestArticleController {

    @Autowired
    private ArticleService articleService;

    @GetMapping("/api/article")
    public ArticleResponse list() {
        List<Article> articles = articleService.list();
        List<ArticleResponse.Data> articlesData = new ArrayList<>();
        for (Article article : articles) {
            ArticleResponse.Data data = new ArticleResponse.Data();
            data.setId(article.getId());
            data.setTitle(article.getTitle());
            data.setContent(article.getContent());
            articlesData.add(data);
        }

        ArticleResponse response = new ArticleResponse();
        response.setData(articlesData);
        response.setMessage("Ok");
        return response;
    }

    @GetMapping("/api/article/{id}")
    public ArticleDetailResponse view(@PathVariable("id") int id) {
        Article article = articleService.get(id);
        ArticleDetailResponse.Data data = new ArticleDetailResponse.Data();
        data.setId(article.getId());
        data.setTitle(article.getTitle());
        data.setContent(article.getContent());

        List<ArticleDetailResponse.Comments> comments = new ArrayList<>();
        for (Comment comment : article.getComments()) {
            ArticleDetailResponse.Comments commentData = new ArticleDetailResponse.Comments();
            commentData.setId(comment.getId());
            commentData.setComment(comment.getComment());
            commentData.setCretedAt(comment.getCreatedAt().toString());
            commentData.setUsername(comment.getUser().getUsername());
            comments.add(commentData);
        }
        data.setComments(comments);

        ArticleDetailResponse response = new ArticleDetailResponse();
        response.setData(data);
        response.setMessage("Ok");

        return response;
    }

    @RequestMapping(value = "/api/article/create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public FormResponse create(@ModelAttribute("article") Article article, @CurrentUser UserPrincipal currentUser, BindingResult result) {
        FormResponse response = new FormResponse();
        ArticleValidator.Create validator = new ArticleValidator.Create();
        validator.validate(article, result);

        if (!result.hasErrors()) {
            article.setUserId(currentUser.getId());
            articleService.save(article);
            response.setStatus(ResponseStatus.SUCCESS);
            response.setMessage("Ok");
            System.out.println("Successfully created the article");
        } else {
            HashMap<String, String> formError = new HashMap<String, String>();
            for (FieldError errors : result.getFieldErrors()) {
                formError.put(errors.getField(), errors.getDefaultMessage());
            }
            response.setMessage("Failed to create the article");
            response.setStatus(ResponseStatus.FORM_ERROR);
            response.setFormError(formError);
        }

        return response;
    }

    @RequestMapping(value = "/api/article/update", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public FormResponse update(@ModelAttribute("article") Article article, @CurrentUser UserPrincipal currentUser, BindingResult result) {
        FormResponse response = new FormResponse();
        ArticleValidator.Update validator = new ArticleValidator.Update();
        validator.validate(article, result);
        article.setId(article.getId());

        if (!result.hasErrors()) {
            articleService.update(article);
            response.setMessage("Successfully update the article");
        } else {
            HashMap<String, String> formError = new HashMap<String, String>();
            System.out.println("Failed to update the article");
            for (FieldError errors : result.getFieldErrors()) {
                formError.put(errors.getField(), errors.getDefaultMessage());
            }
            response.setMessage("Please check again your input");
            response.setStatus(ResponseStatus.FORM_ERROR);
            response.setFormError(formError);
        }

        return response;
    }

    @RequestMapping(value = "/api/article/delete/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public FormResponse delete(@PathVariable("id") int id) {
        FormResponse response = new FormResponse();
        Article article = articleService.get(id);
        if (article != null) {
            System.out.println("Selected Article ID : " +  id);
            articleService.delete(id);
            response.setMessage("Article has been deleted");
        } else {
            response.setMessage("Article not found or already deleted");
            response.setStatus(ResponseStatus.FAILED);
        }

        return response;
    }
}