package com.mitrais.springmvc.model;

import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "comments")
public class Comment {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;

    @Column(name = "article_id")
    protected int articleId;

    @Column(name = "user_id")
    protected int userId;

    @Column(name = "comment", length = 65535, columnDefinition="TEXT")
    protected String comment;

    @Column(name = "created_at")
    @UpdateTimestamp
    protected LocalDateTime createdAt;

    @ManyToOne(cascade = CascadeType.ALL, targetEntity = Article.class)
    @JoinColumn(name = "article_id", referencedColumnName = "id", insertable = false, updatable = false)
    protected Article articles;

    @ManyToOne(cascade = CascadeType.ALL, targetEntity = User.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", referencedColumnName = "id", insertable = false, updatable = false)
    protected User user;

    public Comment(int articleId, int userId, String comment) {
        this.articleId = articleId;
        this.userId = userId;
        this.comment = comment;
    }

    public Comment() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}