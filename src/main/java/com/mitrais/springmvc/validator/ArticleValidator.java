package com.mitrais.springmvc.validator;

import com.mitrais.springmvc.model.Article;
import com.mitrais.springmvc.model.Comment;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class ArticleValidator {

    public static class Create implements Validator {
        @Override
        public boolean supports(Class<?> clazz) {
            return false;
        }

        @Override
        public void validate(Object target, Errors errors) {
            Article article = (Article) target;

            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "required", "Title field is required");
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "content", "required", "Content field is required");

            if (article.getTitle().length() <= 5) {
                errors.rejectValue("title", "title.max5");
            }
        }
    }

    public static class Update implements Validator {

        @Override
        public boolean supports(Class<?> clazz) {
            return false;
        }

        @Override
        public void validate(Object target, Errors errors) {
            Article article = (Article) target;

            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "required", "Title field is required");
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "content", "required", "Content field is required");

            if (article.getTitle().length() <= 10) {
                errors.rejectValue("title", "title.max10");
            }
        }
    }

    public static class PostComment implements Validator {
        @Override
        public boolean supports(Class<?> clazz) {
            return false;
        }

        @Override
        public void validate(Object target, Errors errors) {
            Comment comment = (Comment) target;

            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "articleId", "required", "Article ID must not empty");
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "comment", "required", "Comment field is required");
        }
    }

}
