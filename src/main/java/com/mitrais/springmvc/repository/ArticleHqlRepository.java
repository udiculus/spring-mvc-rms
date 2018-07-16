package com.mitrais.springmvc.repository;

import com.mitrais.springmvc.model.Article;

import java.util.List;

public interface ArticleHqlRepository {

    int save(Article article);

    Article get(int id);

    List<Article> list();

    void update(int id, Article article);

    void delete(int id);
}
