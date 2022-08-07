package com.test.application.util;

import lombok.Data;


public class AppResponse<T> {
    private int status;
    private String message;
    private Object result;
    public AppResponse(int status, String message, Object result) {
        this.status = status;
        this.message = message;
        this.result = result;
    }
}
