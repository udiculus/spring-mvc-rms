package com.mitrais.springmvc.payload.response;

import com.mitrais.springmvc.model.ResponseStatus;

public class ApiResponse {
    private ResponseStatus status;
    private String message;

    public ApiResponse(ResponseStatus errorcode, String message) {
        this.status = errorcode;
        this.message = message;
    }

    public ResponseStatus getErrorcode() {
        return status;
    }

    public void setErrorcode(ResponseStatus errorcode) {
        this.status = errorcode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
