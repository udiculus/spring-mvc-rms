package com.mitrais.springmvc.model.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.HashMap;

public class FormResponse {

    @SerializedName("errorcode")
    @Expose
    private int errorcode;

    @SerializedName("message")
    @Expose
    private String message;

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
}
