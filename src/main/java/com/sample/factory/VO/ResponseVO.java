package com.sample.factory.VO;

public class ResponseVO {

    private int code;
    private String status;
    private String message;
    private Long requestedTime;
    private String executionTime;
    private Object data;

    public ResponseVO() {
        this.requestedTime = System.currentTimeMillis();
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public void setExecutionTime() {
        this.executionTime = System.currentTimeMillis() - this.requestedTime + " ms";
    }
}