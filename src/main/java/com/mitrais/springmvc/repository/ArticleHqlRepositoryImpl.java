package com.mitrais.springmvc.repository;

import com.mitrais.springmvc.model.Article;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ArticleHqlRepositoryImpl implements ArticleHqlRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public int save(Article article) {
        sessionFactory.getCurrentSession().save(article);
        return article.getId();
    }

    @Override
    public Article get(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Article where id = :id");
        System.out.println(id);
        query.setInteger("id", id);

        return (Article) query.uniqueResult();
    }

    @Override
    public List<Article> list() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Article");

        return (List<Article>) query.getResultList();
    }

    @Override
    public void update(int id, Article article) {
        Session session = sessionFactory.getCurrentSession();
        Article article2 = session.byId(Article.class).load(id);
        article2.setTitle(article.getTitle());
        article2.setContent(article.getContent());
        session.flush();
    }

    @Override
    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("delete from Article where id = :id");
        query.setInteger("id", id);
        query.executeUpdate();
    }
}
