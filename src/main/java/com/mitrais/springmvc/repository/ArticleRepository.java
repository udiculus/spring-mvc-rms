package com.mitrais.springmvc.repository;

import com.mitrais.springmvc.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface ArticleRepository extends JpaRepository<Article, Integer> {

    @Modifying
    @Transactional
    @Query("delete from Article a where a.id = ?1")
    void deleteByArticleId(Integer articleId);
}