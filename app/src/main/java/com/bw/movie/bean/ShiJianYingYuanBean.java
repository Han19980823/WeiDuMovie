package com.bw.movie.bean;


/*
 *@auther:胡明明
 *@Date: 2019/11/20
 *@Time:18:53
 *@Description:${DESCRIPTION}
 **/

import java.util.List;

public class ShiJianYingYuanBean {

    /**
     * result : [{"address":"十八里店西直河商业中心东融国际影城","cinemaId":21,"logo":"http://172.17.8.100/images/movie/logo/drgjyc.jpg","name":"东融国际影城西直河店","price":0},{"address":"黄平路19号院龙旗购物中心3层","cinemaId":17,"logo":"http://172.17.8.100/images/movie/logo/blgj.jpg","name":"保利国际影城北京龙旗广场店","price":0},{"address":"育知东路30号华联商厦4层","cinemaId":20,"logo":"http://172.17.8.100/images/movie/logo/wmyc.jpg","name":"北京沃美影城","price":0},{"address":"崇文门外大街18号国瑞城首层、地下二层","cinemaId":9,"logo":"http://172.17.8.100/images/movie/logo/blh.jpg","name":"北京百老汇影城国瑞购物中心店","price":0},{"address":"复兴路69号五棵松卓展时代百货五层东侧","cinemaId":13,"logo":"http://172.17.8.100/images/movie/logo/bjalclgj.jpg","name":"北京耀莱成龙国际影城","price":0}]
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
         * address : 十八里店西直河商业中心东融国际影城
         * cinemaId : 21
         * logo : http://172.17.8.100/images/movie/logo/drgjyc.jpg
         * name : 东融国际影城西直河店
         * price : 0
         */

        private String address;
        private int cinemaId;
        private String logo;
        private String name;
        private int price;

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public int getCinemaId() {
            return cinemaId;
        }

        public void setCinemaId(int cinemaId) {
            this.cinemaId = cinemaId;
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

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }
    }
}
