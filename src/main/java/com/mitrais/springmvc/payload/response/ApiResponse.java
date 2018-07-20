package com.mitrais.springmvc.payload.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.mitrais.springmvc.model.ResponseStatus;

public class ApiResponse {

    @SerializedName("status")
    @Expose
    protected ResponseStatus status;

    @SerializedName("message")
    @Expose
    protected String message;

    public ApiResponse() {
        this.status = ResponseStatus.SUCCESS;
    }

    public ApiResponse(ResponseStatus errorcode, String message) {
        this.status = errorcode;
        this.message = message;
    }

    public ResponseStatus getStatus() {
        return status;
    }

    public void setStatus(ResponseStatus status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
