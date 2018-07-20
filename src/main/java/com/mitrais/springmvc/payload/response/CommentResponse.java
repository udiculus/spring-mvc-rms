package com.mitrais.springmvc.payload.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.HashMap;

public class CommentResponse extends ApiResponse{

    @SerializedName("data")
    @Expose
    private Data data;

    @SerializedName("form_error")
    @Expose
    private HashMap<String, String> formError;

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

    public class Data {

        @SerializedName("comment_id")
        @Expose
        private Integer commentId;

        public Integer getCommentId() {
            return commentId;
        }

        public void setCommentId(Integer commentId) {
            this.commentId = commentId;
        }

    }
}