package com.mitrais.springmvc.dao;

import com.mitrais.springmvc.model.Article;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ArticleDaoImpl implements ArticleDao{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public long save(Article article) {
        sessionFactory.getCurrentSession().save(article);
        return article.getId();
    }

    @Override
    public Article get(long id) {
        return sessionFactory.getCurrentSession().get(Article.class, id);
    }

    @Override
    public List<Article> list() {
        Session session = sessionFactory.getCurrentSession();
    }

    @Override
    public void update(Article article) {

    }

    @Override
    public void delete(long id) {

    }
}
