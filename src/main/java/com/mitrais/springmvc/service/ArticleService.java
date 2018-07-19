package com.mitrais.springmvc.service;

import com.mitrais.springmvc.model.Article;
import com.mitrais.springmvc.model.Comment;

import java.util.List;

public interface ArticleService {

    Article save(Article article);

    Article get(int id);

    List<Comment> getComments();

    List<Article> list();

    void update(Article article);

    void delete(int id);

}
