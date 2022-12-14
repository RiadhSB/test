package com.test.application.util;




public class AppResponse<T> {
    private int status;
    private String message;
    private Object result;
    public AppResponse(int status, String message, Object result) {
        this.status = status;
        this.message = message;
        this.result = result;
    }
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }


}
