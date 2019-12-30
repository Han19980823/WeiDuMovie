package com.bw.movie.bean;

import java.util.List;


public class FilmReviewBean {

    /**
     * result : [{"commentContent":"想看，谁有资源。","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/bwjy.jpg","commentId":379,"commentTime":1566219953000,"commentUserId":13462,"commentUserName":"旭小夜","greatNum":0,"isGreat":0,"replyHeadPic":[],"replyNum":0,"score":10},{"commentContent":"帅气","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/bwjy.jpg","commentId":378,"commentTime":1566219779000,"commentUserId":13462,"commentUserName":"旭小夜","greatNum":0,"isGreat":0,"replyHeadPic":[],"replyNum":0,"score":10},{"commentContent":"依旧那么帅！！！","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/bwjy.jpg","commentId":377,"commentTime":1566219689000,"commentUserId":13462,"commentUserName":"旭小夜","greatNum":0,"isGreat":0,"replyHeadPic":[],"replyNum":0,"score":10},{"commentContent":"是DAU很大声的哈萨伤脑筋","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/bwjy.jpg","commentId":270,"commentTime":1566215006000,"commentUserId":13473,"commentUserName":"精致的猪猪女孩","greatNum":0,"isGreat":0,"replyHeadPic":[],"replyNum":0,"score":4.5},{"commentContent":"好","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/2019-08-16/20190816155937.jpg","commentId":252,"commentTime":1566202506000,"commentUserId":13452,"commentUserName":"37.2°C","greatNum":0,"isGreat":0,"replyHeadPic":[],"replyNum":0,"score":1.5},{"commentContent":"dfsd","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/2019-08-16/20190816101933.jpg","commentId":56,"commentTime":1566006652000,"commentUserId":13437,"commentUserName":"辰峰","greatNum":1,"isGreat":0,"replyHeadPic":[],"replyNum":0,"score":0},{"commentContent":"","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/2019-08-16/20190816101933.jpg","commentId":55,"commentTime":1566006638000,"commentUserId":13437,"commentUserName":"辰峰","greatNum":1,"isGreat":0,"replyHeadPic":[],"replyNum":0,"score":0},{"commentContent":"","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/2019-08-16/20190816101933.jpg","commentId":54,"commentTime":1566006146000,"commentUserId":13437,"commentUserName":"辰峰","greatNum":0,"isGreat":0,"replyHeadPic":[],"replyNum":0,"score":0},{"commentContent":"挺好的","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/2019-08-16/20190816101933.jpg","commentId":49,"commentTime":1565923895000,"commentUserId":13437,"commentUserName":"辰峰","greatNum":2,"isGreat":0,"replyHeadPic":[],"replyNum":0,"score":8.8},{"commentContent":"fdsfdsfjyutyuuuuuuuuuuuuuuuuu","commentHeadPic":"http://172.17.8.100/images/movie/head_pic/2019-08-16/20190816101933.jpg","commentId":47,"commentTime":1565921787000,"commentUserId":13437,"commentUserName":"辰峰","greatNum":2,"isGreat":0,"replyHeadPic":[],"replyNum":0,"score":8}]
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
         * commentContent : 想看，谁有资源。
         * commentHeadPic : http://172.17.8.100/images/movie/head_pic/bwjy.jpg
         * commentId : 379
         * commentTime : 1566219953000
         * commentUserId : 13462
         * commentUserName : 旭小夜
         * greatNum : 0
         * isGreat : 0
         * replyHeadPic : []
         * replyNum : 0
         * score : 10
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
        private float score;
        private List<String> replyHeadPic;

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

        public float getScore() {
            return score;
        }

        public void setScore(int score) {
            this.score = score;
        }

        public List<String> getReplyHeadPic() {
            return replyHeadPic;
        }

        public void setReplyHeadPic(List<String> replyHeadPic) {
            this.replyHeadPic = replyHeadPic;
        }
    }
}
