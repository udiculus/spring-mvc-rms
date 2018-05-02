package com.mitrais.springmvc.service;

import com.mitrais.springmvc.dao.ArticleDao;
import com.mitrais.springmvc.model.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class ArticleServiceImpl implements ArticleService{

    @Autowired
    private ArticleDao articleDao;

    @Transactional
    @Override
    public int save(Article article) {
        return articleDao.save(article);
    }

    @Override
    public Article get(int id) {
        return articleDao.get(id);
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
}
