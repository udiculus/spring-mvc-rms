package com.mitrais.springmvc.model.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.mitrais.springmvc.model.Comment;

import java.util.HashMap;
import java.util.List;

public class ArticleDetailResponse {

    public ArticleDetailResponse() {
    }

    @SerializedName("errorcode")
    @Expose
    private int errorcode;

    @SerializedName("message")
    @Expose
    private String message;

    @SerializedName("data")
    @Expose
    private Data data;

    @SerializedName("form_error")
    @Expose
    private HashMap<String, String> formError;

    public int getErrorcode() {
        return errorcode;
    }

    public void setErrorcode(int errorcode) {
        this.errorcode = errorcode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HashMap<String, String> getFormError() {
        return formError;
    }

    public void setFormError(HashMap<String, String> formError) {
        this.formError = formError;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public static class Data {

        public Data() {
        }

        @SerializedName("id")
        @Expose
        private Integer id;

        @SerializedName("title")
        @Expose
        private String title;

        @SerializedName("body")
        @Expose
        private String content;

        @SerializedName("comments")
        @Expose
        private List<Comments> comments;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public List<Comments> getComments() {
            return comments;
        }

        public void setComments(List<Comments> comments) {
            this.comments = comments;
        }
    }

    public static class Comments {

        public Comments() {
        }

        @SerializedName("id")
        @Expose
        private Integer id;

        @SerializedName("comment")
        @Expose
        private String comment;

        @SerializedName("created_at")
        @Expose
        private String cretedAt;

        @SerializedName("username")
        @Expose
        private String username;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getComment() {
            return comment;
        }

        public void setComment(String comment) {
            this.comment = comment;
        }

        public String getCretedAt() {
            return cretedAt;
        }

        public void setCretedAt(String cretedAt) {
            this.cretedAt = cretedAt;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }
    }
}
