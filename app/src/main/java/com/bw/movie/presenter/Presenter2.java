package com.bw.movie.presenter;

import com.bw.movie.base.BasePresenterActivity;
import com.bw.movie.bean.AddaresBean;
import com.bw.movie.bean.BirthBean;
import com.bw.movie.bean.CinemaInfoBean;
import com.bw.movie.bean.CodeBean;
import com.bw.movie.bean.DetailsBean;
import com.bw.movie.bean.LoginBean;
import com.bw.movie.bean.MovieBean;
import com.bw.movie.bean.MovieScheduleBean;
import com.bw.movie.bean.MoviesDateilBean;
import com.bw.movie.bean.PaiQiBean;
import com.bw.movie.bean.PriceBean;
import com.bw.movie.bean.RegionListBean;
import com.bw.movie.bean.RegistBean;
import com.bw.movie.bean.SeatInfoBean;
import com.bw.movie.bean.SelectBean;
import com.bw.movie.bean.ShiJianBean;
import com.bw.movie.bean.ShiJianYingYuanBean;
import com.bw.movie.bean.TouXiangBean;
import com.bw.movie.bean.WeChatBean;
import com.bw.movie.bean.XiaDanBean;
import com.bw.movie.bean.XuanZuoXinXiBean;
import com.bw.movie.bean.YingTingBean;
import com.bw.movie.bean.YongHuBean;
import com.bw.movie.bean.YuYueBean;
import com.bw.movie.bean.ZhiFuBean;
import com.bw.movie.bean.ZhouQI;
import com.bw.movie.bean.ZuoWeiHaoBean;
import com.bw.movie.view.activity.ChooseActivity;
import com.bw.movie.view.activity.CinemaInfoActivity;

import com.bw.movie.view.activity.DetailsActivity;
import com.bw.movie.view.activity.GouPiaoActivity;
import com.bw.movie.view.activity.LoginActivity;
import com.bw.movie.view.activity.MoviesActivity;
import com.bw.movie.view.activity.Personal_Details_Activity;
import com.bw.movie.view.activity.RegistActivity;

import com.bw.movie.view.activity.SelectActivity;
import com.bw.movie.contract.Icontract;
import com.bw.movie.model.Model;
import com.bw.movie.view.activity.YuYueActivity;
import com.bw.movie.view.fragment.YingYuanXqFragment;

import okhttp3.MultipartBody;

/**
 * 作者：Han98
 * 创建时间：2019/12/7
 * 描述：TODO
 * 最近修改：2019/12/7 13:15 modify by liujc
 */
public class Presenter2 extends BasePresenterActivity {
    Model model;

    public Presenter2() {
        model = new Model();

    }
    public void getLogin(String emali,String pwd){

        model.getLogin(emali, pwd, new Icontract.Imodel() {
            @Override
            public void success(Object obj) {
                LoginActivity regsitSctivity = (LoginActivity) v;
                regsitSctivity.success((LoginBean) obj);
            }
        });
    }
    public void getRegist(String name,String pwd,String email,String code){
      model.setRegsit(name, pwd, email, code, new Icontract.Imodel() {
          @Override
          public void success(Object obj) {
             RegistActivity registActivity = (RegistActivity) v;
              registActivity.success((LoginBean) obj);
          }
      });
    }

    public void getMovie1(){
        model.getMovie(new Icontract.Imodel() {
            @Override
            public void success(Object obj) {

                SelectActivity activity = (SelectActivity) v;
                activity.movieSuccess1((MovieBean) obj);
            }
        });
    }

    public void getSelect(String name){
        model.getSelect(name, new Icontract.Imodel() {
            @Override
            public void success(Object obj) {
                SelectActivity activity = (SelectActivity) v;
                activity.Select((SelectBean) obj);
            }
        });
    }
    public void  getDetalis(int mid){
        model.getDetails(mid, new Icontract.Imodel() {
            @Override
            public void success(Object obj) {
                DetailsActivity activity = (DetailsActivity) v;
                activity.deTails((DetailsBean) obj);
            }
        });
    }

    public void getWeChat(String code){
        model.getWeChat(code, new Icontract.Imodel() {
            @Override
            public void success(Object obj) {
                LoginActivity regsitSctivity = (LoginActivity) v;
                regsitSctivity.success((WeChatBean) obj);
            }
        });
    }
    public void getSAdd(int id){
        model.getAdd(id, new Icontract.Imodel() {
            @Override
            public void success(Object obj) {
                CinemaInfoActivity fragment = (CinemaInfoActivity) v;
                fragment.success((AddaresBean) obj);
            }
        });
    }

    public void zhouqi(){
        model.zhouqi(new Icontract.Imodel() {
            @Override
            public void success(Object obj) {
                MoviesActivity activity = (MoviesActivity) v;
                activity.zhou((ZhouQI) obj);
            }
        });
    }

    public void seatInfo(int hid){
        model.setatInfo(hid, new Icontract.Imodel() {
            @Override
            public void success(Object obj) {
                ChooseActivity activity = (ChooseActivity) v;
                activity.success((SeatInfoBean) obj);
            }
        });
    }
    public void seatInfos(int id,int sid){
         model.getMoview(id, sid, new Icontract.Imodel() {
             @Override
             public void success(Object obj) {
                 ChooseActivity activity  = (ChooseActivity) v;
                 activity.successes((MoviesDateilBean) obj);
             }
         });
    }
    public void getPrice(int movieId,int page,int count){
        model.getPrice(movieId, page, count, new Icontract.Imodel() {
            @Override
            public void success(Object obj) {
                ChooseActivity activity  = (ChooseActivity) v;
                activity.price((PriceBean) obj);
            }
        });
    }
    public void getshijian(){
        model.getSHijian( new Icontract.Imodel() {
            @Override
            public void success(Object obj) {
                ChooseActivity activity  = (ChooseActivity) v;
                activity.shijian((ShiJianBean) obj);
            }
        });
    }

    public void shijianyingyuan(int id,String s,int page,int count){
        model.getShijianyingyuan(id, s, page, count, new Icontract.Imodel() {
            @Override
            public void success(Object obj) {
                ChooseActivity activity  = (ChooseActivity) v;
                activity.shijianyingyuan((ShiJianYingYuanBean) obj);
            }
        });
    }
    public void  chooser(int mid){
        model.getDetails(mid, new Icontract.Imodel() {
            @Override
            public void success(Object obj) {
                ChooseActivity activity = (ChooseActivity) v;
                activity.successDe((DetailsBean) obj);
            }
        });
    }

    public void  xuanzuoxinxi(int movieId,int sid,int page,int count){
        model.getXinxi(movieId,sid ,page,count,new Icontract.Imodel() {
            @Override
            public void success(Object obj) {
                ChooseActivity activity = (ChooseActivity) v;
                activity.xuanzuo((XuanZuoXinXiBean) obj);
            }
        });
    }

    public void getRegion(){
        model.getRegion(new Icontract.Imodel() {
            @Override
            public void success(Object obj) {
                ChooseActivity activity = (ChooseActivity) v;
                activity.Regis((RegionListBean) obj);
            }
        });
    }

    public void getXIdan( int uid,String sid,int scheduleId, String seat, String sign){
            model.getPrices( uid,sid,scheduleId, seat, sign, new Icontract.Imodel() {
                @Override
                public void success(Object obj) {
                    GouPiaoActivity activity = (GouPiaoActivity) v;
                    activity.success((XiaDanBean) obj);
                }
            });
    }
    public void getzhifu(int uid,String sid, int payType, String orderId){
        model.getZhifu( uid,sid,payType, orderId, new Icontract.Imodel() {
            @Override
            public void success(Object obj) {
                GouPiaoActivity activity = (GouPiaoActivity) v;
                activity.zhifu((ZhiFuBean) obj);
            }
        });
    }
    public void getXIngqing(int mid){
        model.getDetails(mid, new Icontract.Imodel() {
            @Override
            public void success(Object obj) {
                GouPiaoActivity activity = (GouPiaoActivity) v;
                activity.xianfgqing((DetailsBean) obj);
            }
        });
    }

    public void getYingT(int movieId, int cid){
        model.getYingTing(movieId, cid, new Icontract.Imodel() {
            @Override
            public void success(Object obj) {
                GouPiaoActivity activity = (GouPiaoActivity) v;
                activity.yingting((YingTingBean) obj);
            }
        });
    }
    public void zuowei(int hid){
        model.xuanzuo(hid, new Icontract.Imodel() {
            @Override
            public void success(Object obj) {
                GouPiaoActivity activity = (GouPiaoActivity) v;
                activity.zuozuo((ZuoWeiHaoBean) obj);
            }
        });
    }

    public void getTou(int uid,String sid, MultipartBody.Part image){
        model.settou(uid, sid, image, new Icontract.Imodel() {
            @Override
            public void success(Object obj) {
                Personal_Details_Activity activity = (Personal_Details_Activity) v;
                activity.Touxaing((TouXiangBean) obj);
            }
        });
    }
    public void getYonghu(int uid,String sid){
        model.getYonghu(uid, sid,  new Icontract.Imodel() {
            @Override
            public void success(Object obj) {
                Personal_Details_Activity activity = (Personal_Details_Activity) v;
                activity.yh((YongHuBean) obj);
            }
        });
    }
    public void getData(int uid,String sid,String bir){
        model.getDate(uid, sid,bir,  new Icontract.Imodel() {
            @Override
            public void success(Object obj) {
                Personal_Details_Activity activity = (Personal_Details_Activity) v;
                activity.bir((BirthBean) obj);
            }
        });
    }
    public void getYuYue(int uid,String sid){
        model.ChaYuYue(uid, sid, new Icontract.Imodel() {
            @Override
            public void success(Object obj) {
                YuYueActivity yuYueActivity = (YuYueActivity) v;
                yuYueActivity.success((YuYueBean) obj);
            }
        });
    }
}
