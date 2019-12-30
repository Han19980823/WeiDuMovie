package com.bw.movie.bean;

/**
 * 作者：Han98
 * 创建时间：2019/12/3
 * 描述：TODO
 * 最近修改：2019/12/3 09:25 modify by liujc
 */
public class RegistBean {
    /**
     * message : 注册失败,邮箱已存在
     * status : 1005
     */

    private String message;
    private String status;

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
