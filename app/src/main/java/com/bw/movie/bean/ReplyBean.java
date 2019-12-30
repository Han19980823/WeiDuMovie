package com.bw.movie.bean;

import java.util.List;

/**
 * auto：王飞 on 2019/8/21 11:57
 * function：
 */
public class ReplyBean {

    /**
     * result : [{"replyContent":"真的还算不错","replyHeadPic":"http://172.17.8.100/images/movie/head_pic/2019-08-16/20190816101933.jpg","replyTime":1565946308000,"replyUserId":13437,"replyUserName":"辰峰"}]
     * message : 查询成功
     * status : 0000
     */

    private String message;
    private String status;
    private List<ResultBean> result;

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

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * replyContent : 真的还算不错
         * replyHeadPic : http://172.17.8.100/images/movie/head_pic/2019-08-16/20190816101933.jpg
         * replyTime : 1565946308000
         * replyUserId : 13437
         * replyUserName : 辰峰
         */

        private String replyContent;
        private String replyHeadPic;
        private long replyTime;
        private int replyUserId;
        private String replyUserName;

        public String getReplyContent() {
            return replyContent;
        }

        public void setReplyContent(String replyContent) {
            this.replyContent = replyContent;
        }

        public String getReplyHeadPic() {
            return replyHeadPic;
        }

        public void setReplyHeadPic(String replyHeadPic) {
            this.replyHeadPic = replyHeadPic;
        }

        public long getReplyTime() {
            return replyTime;
        }

        public void setReplyTime(long replyTime) {
            this.replyTime = replyTime;
        }

        public int getReplyUserId() {
            return replyUserId;
        }

        public void setReplyUserId(int replyUserId) {
            this.replyUserId = replyUserId;
        }

        public String getReplyUserName() {
            return replyUserName;
        }

        public void setReplyUserName(String replyUserName) {
            this.replyUserName = replyUserName;
        }
    }
}
