package com.mitrais.springmvc.dao;

import com.mitrais.springmvc.model.Article;

import java.util.List;

public interface ArticleDao {

    long save(Article article);

    Article get(long id);

    List<Article> list();

    void update(Article article);

    void delete(long id);
}
