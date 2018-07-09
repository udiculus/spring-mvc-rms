package com.mitrais.springmvc.controller.rest;

import com.mitrais.springmvc.model.Article;
import com.mitrais.springmvc.model.Comment;
import com.mitrais.springmvc.model.response.ArticleDetailResponse;
import com.mitrais.springmvc.model.response.ArticleResponse;
import com.mitrais.springmvc.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8081")
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
}
