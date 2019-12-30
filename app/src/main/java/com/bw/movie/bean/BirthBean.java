package com.bw.movie.bean;



public class BirthBean {
    /**
     * message : 修改成功
     * status : 0000
     */

    private String message;
    private String status;

    @Override
    public String toString() {
        return "BirthBean{" +
                "message='" + message + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
