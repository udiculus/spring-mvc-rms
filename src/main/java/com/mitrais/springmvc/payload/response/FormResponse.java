package com.mitrais.springmvc.payload.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.HashMap;

public class FormResponse extends ApiResponse {

    @SerializedName("form_error")
    @Expose
    private HashMap<String, String> formError;

    public HashMap<String, String> getFormError() {
        return formError;
    }

    public void setFormError(HashMap<String, String> formError) {
        this.formError = formError;
    }
}