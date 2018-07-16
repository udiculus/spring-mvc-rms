package com.mitrais.springmvc.repository;

import com.mitrais.springmvc.model.Article;
import com.mitrais.springmvc.model.Comment;

import java.util.List;

public interface ArticleRepository {

	int save(Article article);

    Article get(int id);

    List<Article> list();

    void update(int id, Article article);

    void delete(int id);

    int postComment(Comment comment);
}
