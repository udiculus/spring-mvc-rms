package com.mitrais.springmvc.repository;

import com.mitrais.springmvc.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Integer> {

}