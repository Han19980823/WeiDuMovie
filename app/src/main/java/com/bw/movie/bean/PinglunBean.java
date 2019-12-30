package com.bw.movie.bean;

import java.util.List;

/**
 * 作者：Han98
 * 创建时间：2019/12/11
 * 描述：TODO
 * 最近修改：2019/12/11 14:05 modify by liujc
 */
public class PinglunBean {
    /**
     * result : [{"commentContent":"电影非常好看","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/2019-12-07/20191207091909.png","commentId":2362,"commentTime":1575972438000,"commentUserId":13865,"commentUserName":"古月","greatNum":0,"isGreat":0,"replyHeadPic":[],"replyNum":0,"score":8.4},{"commentContent":"还行吧","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/bwjy.jpg","commentId":2353,"commentTime":1575964671000,"commentUserId":13901,"commentUserName":"你你你","greatNum":0,"isGreat":0,"replyHeadPic":[],"replyNum":0,"score":4.4},{"commentContent":"真好","commentHeadPic":"http://thirdwx.qlogo.cn/mmopen/vi_32/PR29l5QBkpUthRLkcBuibZIOZeh6hDAAYvOXTKmhqNCCDy9ZxMeLS0982Xk3sAXQnYXaAXolOqm6JhQ4ltFFhyQ/132","commentId":2331,"commentTime":1575460455000,"commentUserId":13860,"commentUserName":"Rain_rGH","greatNum":0,"isGreat":0,"replyHeadPic":[],"replyNum":0,"score":3.5},{"commentContent":"还行吧 不错 也就那样 是哪期","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/bwjy.jpg","commentId":2330,"commentTime":1575455945000,"commentUserId":13779,"commentUserName":"奉天","greatNum":0,"isGreat":0,"replyHeadPic":[],"replyNum":0,"score":7},{"commentContent":"一般","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/2019-12-06/20191206203209.png","commentId":2320,"commentTime":1575427976000,"commentUserId":13790,"commentUserName":"记得双击么么哒","greatNum":1,"isGreat":0,"replyHeadPic":["http://172.17.8.100/images/movie/head_pic/bwjy.jpg","http://172.17.8.100/images/movie/head_pic/bwjy.jpg","http://172.17.8.100/images/movie/head_pic/bwjy.jpg","http://172.17.8.100/images/movie/head_pic/bwjy.jpg","http://172.17.8.100/images/movie/head_pic/bwjy.jpg"],"replyNum":29,"score":4},{"commentContent":"就这样","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/2019-12-05/20191205203719.jpg","commentId":2315,"commentTime":1575361010000,"commentUserId":13752,"commentUserName":"茶叶_N1i","greatNum":0,"isGreat":0,"replyHeadPic":[],"replyNum":0,"score":3},{"commentContent":"嗯\n","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/bwjy.jpg","commentId":2313,"commentTime":1575359105000,"commentUserId":13796,"commentUserName":"崔瑞鹏","greatNum":0,"isGreat":0,"replyHeadPic":[],"replyNum":0,"score":8.9},{"commentContent":"123","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/2019-12-06/20191206221534.jpg","commentId":2298,"commentTime":1575289768000,"commentUserId":13801,"commentUserName":"王小二","greatNum":0,"isGreat":0,"replyHeadPic":[],"replyNum":0,"score":5.5},{"commentContent":"好看呦","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/2019-12-05/20191205192246.jpg","commentId":2272,"commentTime":1575268348000,"commentUserId":13792,"commentUserName":"你的益达747","greatNum":1,"isGreat":0,"replyHeadPic":[],"replyNum":0,"score":8.9},{"commentContent":"","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/2019-12-06/20191206161727.jpg","commentId":2250,"commentTime":1575100585000,"commentUserId":13791,"commentUserName":"你的益达77","greatNum":0,"isGreat":0,"replyHeadPic":[],"replyNum":0,"score":4.5}]
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
         * commentContent : 电影非常好看
         * commentHeadPic : http://172.17.8.100/images/movie/head_pic/2019-12-07/20191207091909.png
         * commentId : 2362
         * commentTime : 1575972438000
         * commentUserId : 13865
         * commentUserName : 古月
         * greatNum : 0
         * isGreat : 0
         * replyHeadPic : []
         * replyNum : 0
         * score : 8.4
         */

        private String commentContent;
        private String commentHeadPic;
        private int commentId;
        private long commentTime;
        private int commentUserId;
        private String commentUserName;
        private int greatNum;
        private int isGreat;
        private int replyNum;
        private double score;
        private List<?> replyHeadPic;

        public String getCommentContent() {
            return commentContent;
        }

        public void setCommentContent(String commentContent) {
            this.commentContent = commentContent;
        }

        public String getCommentHeadPic() {
            return commentHeadPic;
        }

        public void setCommentHeadPic(String commentHeadPic) {
            this.commentHeadPic = commentHeadPic;
        }

        public int getCommentId() {
            return commentId;
        }

        public void setCommentId(int commentId) {
            this.commentId = commentId;
        }

        public long getCommentTime() {
            return commentTime;
        }

        public void setCommentTime(long commentTime) {
            this.commentTime = commentTime;
        }

        public int getCommentUserId() {
            return commentUserId;
        }

        public void setCommentUserId(int commentUserId) {
            this.commentUserId = commentUserId;
        }

        public String getCommentUserName() {
            return commentUserName;
        }

        public void setCommentUserName(String commentUserName) {
            this.commentUserName = commentUserName;
        }

        public int getGreatNum() {
            return greatNum;
        }

        public void setGreatNum(int greatNum) {
            this.greatNum = greatNum;
        }

        public int getIsGreat() {
            return isGreat;
        }

        public void setIsGreat(int isGreat) {
            this.isGreat = isGreat;
        }

        public int getReplyNum() {
            return replyNum;
        }

        public void setReplyNum(int replyNum) {
            this.replyNum = replyNum;
        }

        public double getScore() {
            return score;
        }

        public void setScore(double score) {
            this.score = score;
        }

        public List<?> getReplyHeadPic() {
            return replyHeadPic;
        }

        public void setReplyHeadPic(List<?> replyHeadPic) {
            this.replyHeadPic = replyHeadPic;
        }
    }
}
