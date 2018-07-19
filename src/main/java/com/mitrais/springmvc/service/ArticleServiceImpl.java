package com.mitrais.springmvc.service;

import com.mitrais.springmvc.repository.ArticleRepository;
import com.mitrais.springmvc.model.Article;
import com.mitrais.springmvc.model.Comment;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class ArticleServiceImpl implements ArticleService{

    private List<Comment> comments;

    @Autowired
    private ArticleRepository articleRepository;

    @Transactional
    @Override
    public Article save(Article article) {
        return articleRepository.save(article);
    }

    @Transactional
    @Override
    public Article get(int id) {
        Optional<Article> article = articleRepository.findById(id);
        if (article.isPresent()){
            Hibernate.initialize(article.get().getComments());
            return article.get();
        } else {
            return null;
        }
    }

    @Override
    public List<Comment> getComments() {
        return this.comments;
    }

    @Override
    public List<Article> list() {
        return articleRepository.findAll();
    }

    @Transactional
    public void update(Article article) {
        articleRepository.save(article);
    }

    @Transactional
    public void delete(int id) {
        articleRepository.deleteById(id);
    }

}