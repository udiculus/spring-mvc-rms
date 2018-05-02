package com.mitrais.springmvc.dao;

import com.mitrais.springmvc.model.Article;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class ArticleDaoImpl implements ArticleDao{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public int save(Article article) {
        sessionFactory.getCurrentSession().save(article);
        return article.getId();
    }

    @Override
    public Article get(int id) {
        return sessionFactory.getCurrentSession().get(Article.class, id);
    }

    @Override
    public List<Article> list() {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Article> cq = cb.createQuery(Article.class);
        Root<Article> root = cq.from(Article.class);
        cq.select(root);
        Query<Article> query = session.createQuery(cq);
        return query.getResultList();
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
        Article article = session.byId(Article.class).load(id);
        session.delete(article);
    }
}
