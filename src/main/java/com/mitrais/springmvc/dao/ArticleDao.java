package com.mitrais.springmvc.dao;

import com.mitrais.springmvc.model.Article;
import com.mitrais.springmvc.model.Comment;

import java.util.List;

public interface ArticleDao {

	int save(Article article);

    Article get(int id);

    List<Comment> getWithComments(int id);

    List<Article> list();

    void update(int id, Article article);

    void delete(int id);
}
