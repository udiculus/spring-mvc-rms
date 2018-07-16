package com.mitrais.springmvc.service;

import com.mitrais.springmvc.repository.ArticleRepository;
import com.mitrais.springmvc.model.Article;
import com.mitrais.springmvc.model.Comment;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class ArticleServiceImpl implements ArticleService{

    private List<Comment> comments;

    @Autowired
    private ArticleRepository articleDao;

    @Transactional
    @Override
    public int save(Article article) {
        return articleDao.save(article);
    }

    @Transactional
    @Override
    public Article get(int id) {
        Article article = articleDao.get(id);
        Hibernate.initialize(article.getComments());
        return article;
    }

    @Override
    public List<Comment> getComments() {
        return this.comments;
    }

    @Override
    public List<Article> list() {
        return articleDao.list();
    }

    @Transactional
    @Override
    public void update(int id, Article article) {
        articleDao.update(id, article);
    }

    @Transactional
    @Override
    public void delete(int id) {
        articleDao.delete(id);
    }

    @Transactional
    @Override
    public int postComment(Comment comment) {
        return articleDao.postComment(comment);
    }

}
