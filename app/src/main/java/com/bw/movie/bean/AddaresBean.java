package com.bw.movie.bean;

/**
 * 作者：Han98
 * 创建时间：2019/12/15
 * 描述：TODO
 * 最近修改：2019/12/15 19:46 modify by liujc
 */
public class AddaresBean {
    /**
     * result : {"address":"中关村大街28号","businessHoursContent":"星期一 至 星期日   早09:00:00 - 晚22:00:00","commentTotal":0,"distance":0,"followCinema":1,"id":16,"label":"儿童优惠,4K厅","logo":"http://172.17.8.100/images/movie/logo/hdjy.jpg","name":"海淀剧院","phone":"010-82533588","vehicleRoute":"332、320、307、355、365、716、717、718、732、特4、特6、运通105、运通106、运通205\u2014\u2014海淀黄庄下车"}
     * message : 查询成功
     * status : 0000
     */

    private ResultBean result;
    private String message;
    private String status;

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
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

    public static class ResultBean {
        /**
         * address : 中关村大街28号
         * businessHoursContent : 星期一 至 星期日   早09:00:00 - 晚22:00:00
         * commentTotal : 0
         * distance : 0
         * followCinema : 1
         * id : 16
         * label : 儿童优惠,4K厅
         * logo : http://172.17.8.100/images/movie/logo/hdjy.jpg
         * name : 海淀剧院
         * phone : 010-82533588
         * vehicleRoute : 332、320、307、355、365、716、717、718、732、特4、特6、运通105、运通106、运通205——海淀黄庄下车
         */

        private String address;
        private String businessHoursContent;
        private int commentTotal;
        private int distance;
        private int followCinema;
        private int id;
        private String label;
        private String logo;
        private String name;
        private String phone;
        private String vehicleRoute;

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getBusinessHoursContent() {
            return businessHoursContent;
        }

        public void setBusinessHoursContent(String businessHoursContent) {
            this.businessHoursContent = businessHoursContent;
        }

        public int getCommentTotal() {
            return commentTotal;
        }

        public void setCommentTotal(int commentTotal) {
            this.commentTotal = commentTotal;
        }

        public int getDistance() {
            return distance;
        }

        public void setDistance(int distance) {
            this.distance = distance;
        }

        public int getFollowCinema() {
            return followCinema;
        }

        public void setFollowCinema(int followCinema) {
            this.followCinema = followCinema;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getLabel() {
            return label;
        }

        public void setLabel(String label) {
            this.label = label;
        }

        public String getLogo() {
            return logo;
        }

        public void setLogo(String logo) {
            this.logo = logo;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getVehicleRoute() {
            return vehicleRoute;
        }

        public void setVehicleRoute(String vehicleRoute) {
            this.vehicleRoute = vehicleRoute;
        }
    }
}
