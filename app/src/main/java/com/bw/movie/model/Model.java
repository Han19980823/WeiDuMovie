package com.bw.movie.model;

import android.graphics.drawable.Icon;

import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MultipartBody;

import com.bw.movie.apis.Api;
import com.bw.movie.apis.ApiService;
import com.bw.movie.bean.AddaresBean;
import com.bw.movie.bean.BannerBean;
import com.bw.movie.bean.BirthBean;
import com.bw.movie.bean.CinemaByRegionBean;
import com.bw.movie.bean.CinemaInfoBean;
import com.bw.movie.bean.CodeBean;
import com.bw.movie.bean.DetailsBean;
import com.bw.movie.bean.JiJiangBean;
import com.bw.movie.bean.LoginBean;
import com.bw.movie.bean.MovieBean;
import com.bw.movie.bean.MovieScheduleBean;
import com.bw.movie.bean.NearByMovieBean;
import com.bw.movie.bean.PaiQiBean;
import com.bw.movie.bean.PinglunBean;
import com.bw.movie.bean.PriceBean;
import com.bw.movie.bean.RecommendBean;
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
import com.bw.movie.bean.YuYueEmnety;
import com.bw.movie.bean.ZhengZaiBena;
import com.bw.movie.bean.ZhiFuBean;
import com.bw.movie.bean.ZhouQI;
import com.bw.movie.bean.ZuoWeiHaoBean;
import com.bw.movie.contract.Icontract;
import com.bw.movie.utils.NetUtils;

/**
 * 作者：Han98
 * 创建时间：2019/12/4
 * 描述：TODO
 * 最近修改：2019/12/4 20:39 modify by liujc
 */
public class Model {

    public void getUtils(Icontract.Imodel imodel) {
        NetUtils.getInstance().getData(ApiService.class)
                .getBanner()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<BannerBean>() {
                    @Override
                    public void accept(BannerBean bannerBean) throws Exception {
                        imodel.success(bannerBean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                    }
                });
    }

    //正在上映
    public void getMovie(Icontract.Imodel imodel) {
        NetUtils.getInstance().getData(ApiService.class)
                .getMovie1(1, 10)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<MovieBean>() {
                    @Override
                    public void accept(MovieBean movieBean) throws Exception {
                        imodel.success(movieBean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                    }
                });
    }
    public void getMovie1(Icontract.Imodel imodel){
        NetUtils.getInstance().getData(ApiService.class)
                .getMovie2(1,2)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<JiJiangBean>() {
                    @Override
                    public void accept(JiJiangBean zhengZaiBena) throws Exception {
                        imodel.success(zhengZaiBena);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                    }
                });
    }

    public void getMovie2(Icontract.Imodel imodel){
        NetUtils.getInstance().getData(ApiService.class)
                .getMovie3(1,10)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ZhengZaiBena>() {
                    @Override
                    public void accept(ZhengZaiBena zhengZaiBena) throws Exception {
                        imodel.success(zhengZaiBena);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                    }
                });
    }

    public void getLogin(String email, String pwd, Icontract.Imodel imodel){
        NetUtils.getInstance().getData(ApiService.class)
                .login(email,pwd)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<LoginBean>() {
                    @Override
                    public void accept(LoginBean loginBean) throws Exception {
                        imodel.success(loginBean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                    }
                });
    }

    public void setRegsit(String name,String pwd,String email,String code,Icontract.Imodel imodel){
        NetUtils.getInstance().getData(ApiService.class)
                .regist(name,pwd,email,code)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<RegistBean>() {
                    @Override
                    public void accept(RegistBean registBean) throws Exception {
                        imodel.success(registBean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                    }
                });
    }
    public void getCode(String emali,Icontract.Imodel iCode){
        NetUtils.getInstance().getData(ApiService.class)
                .code(emali)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<CodeBean>() {
                    @Override
                    public void accept(CodeBean codeBean) throws Exception {
                        iCode.success(codeBean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                    }
                });
    }

    public void getSelect(String name,Icontract.Imodel imodel) {
        NetUtils.getInstance().getData(ApiService.class).select(name,1,10)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<SelectBean>() {
                    @Override
                    public void accept(SelectBean selectBean) throws Exception {
                        imodel.success(selectBean);
                    }
                });
    }

    public void getDetails(int mid, Icontract.Imodel imodel){
        NetUtils.getInstance().getData(ApiService.class)
                .detail(13847,"157658635204113847",mid)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<DetailsBean>() {
                    @Override
                    public void accept(DetailsBean detailsBean) throws Exception {
                        imodel.success(detailsBean);
                    }
                });
    }

    public void getPinglun(int mid,Icontract.Imodel imodel){
        NetUtils.getInstance().getData(ApiService.class)
                .pinglun(13847,"157658635204113847",mid,1,5)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<PinglunBean>() {
                    @Override
                    public void accept(PinglunBean pinglunBean) throws Exception {
                        imodel.success(pinglunBean);
                    }
                });
    }
    public void getRecomm(Icontract.Imodel imodel, Map<String,Object> map){
        NetUtils.getInstance().getData(ApiService.class)
                .getRecomm(13847,"157658635204113847",map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<RecommendBean>() {
                    @Override
                    public void accept(RecommendBean recommendBean) throws Exception {
                        imodel.success(recommendBean);
                    }
                });
    }
    public void home_Coming_Show(Icontract.Imodel imodel,Map<String,Object> map){
        NetUtils.getInstance().getData(ApiService.class)
                .home_Coming_Show(13847,"157658635204113847",map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<NearByMovieBean>() {
                    @Override
                    public void accept(NearByMovieBean nearByMovieBean) throws Exception {
                        imodel.success(nearByMovieBean);
                    }
                });
    }

    public void getRegion(Icontract.Imodel imodel){
        NetUtils.getInstance().getData(ApiService.class)
                .region()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<RegionListBean>() {
                    @Override
                    public void accept(RegionListBean regionListBean) throws Exception {
                        imodel.success(regionListBean);
                    }
                });
    }
    public void getByRegion(int id,Icontract.Imodel imodel){
        NetUtils.getInstance().getData(ApiService.class)
                .ciByregion(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<CinemaByRegionBean>() {
                    @Override
                    public void accept(CinemaByRegionBean cinemaByRegionBean) throws Exception {
                        imodel.success(cinemaByRegionBean);
                    }
                });
    }
    public void getWeChat(String code,Icontract.Imodel imodel){
        NetUtils.getInstance().getData(ApiService.class)
                .WE_CHAT_BEAN_OBSERVABLE(code)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<WeChatBean>() {
                    @Override
                    public void accept(WeChatBean weChatBean) throws Exception {
                        imodel.success(weChatBean);
                    }
                });
    }

    public void getInfo(int cid,Icontract.Imodel imodel){
        NetUtils.getInstance().getData(ApiService.class)
                .info(13847,"157658635204113847",cid)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<CinemaInfoBean>() {
                    @Override
                    public void accept(CinemaInfoBean cinemaInfoBean) throws Exception {
                        imodel.success(cinemaInfoBean);
                    }
                });
    }
    public void getAdd(int cid,Icontract.Imodel imodel){
        NetUtils.getInstance().getData(ApiService.class)
                .addares(13847,"157658635204113847",cid)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<AddaresBean>() {
                    @Override
                    public void accept(AddaresBean addaresBean) throws Exception {
                        imodel.success(addaresBean);
                    }
                });
    }
    public void getPaiqi(int cid,Icontract.Imodel imodel){
        NetUtils.getInstance().getData(ApiService.class)
                .paiqi(cid,1,5)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<PaiQiBean>() {
                    @Override
                    public void accept(PaiQiBean paiQiBean) throws Exception {
                        imodel.success(paiQiBean);
                    }
                });
    }
    public void zhouqi(Icontract.Imodel imodel){
        NetUtils.getInstance().getData(ApiService.class)
                .ZHOU_QI_OBSERVABLE()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ZhouQI>() {
                    @Override
                    public void accept(ZhouQI zhouQI) throws Exception {
                        imodel.success(zhouQI);
                    }
                });
    }
    public void setatInfo(int hid,Icontract.Imodel imodel){
        NetUtils.getInstance().getData(ApiService.class)
                .setinfo(hid)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<SeatInfoBean>() {
                    @Override
                    public void accept(SeatInfoBean seatInfoBean) throws Exception {
                        imodel.success(seatInfoBean);
                    }
                });
    }
    public void getMoview(int mid,int sid,Icontract.Imodel imodel){
        NetUtils.getInstance().getData(ApiService.class)
                .getMoview(mid,sid)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<MovieScheduleBean>() {
                    @Override
                    public void accept(MovieScheduleBean movieScheduleBean) throws Exception {
                        imodel.success(movieScheduleBean);
                    }
                });
    }
    public void getPrice(int movieId, int page, int count,Icontract.Imodel imodel){
        NetUtils.getInstance().getData(ApiService.class)
                .getprice(movieId,page,count)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<PriceBean>() {
                    @Override
                    public void accept(PriceBean priceBean) throws Exception {
                        imodel.success(priceBean);
                    }
                });
    }
    public void getSHijian(Icontract.Imodel imodel){
        NetUtils.getInstance().getData(ApiService.class)
                .getshijian()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ShiJianBean>() {
                    @Override
                    public void accept(ShiJianBean shiJianBean) throws Exception {
                        imodel.success(shiJianBean);
                    }
                });
    }
    public void getShijianyingyuan(int id,String s,int page,int count,Icontract.Imodel imodel){
        NetUtils.getInstance().getData(ApiService.class)
                .getshijianyingyuan(id,s,page,count)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ShiJianYingYuanBean>() {
                    @Override
                    public void accept(ShiJianYingYuanBean shiJianYingYuanBean) throws Exception {
                        imodel.success(shiJianYingYuanBean);
                    }
                });
    }

    public void getXinxi(int movieId,int sid,int page,int count,Icontract.Imodel imodel){
        NetUtils.getInstance().getData(ApiService.class)
                .getxinxi(movieId,sid,page,count)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<XuanZuoXinXiBean>() {
                    @Override
                    public void accept(XuanZuoXinXiBean xuanZuoXinXiBean) throws Exception {
                        imodel.success(xuanZuoXinXiBean);
                    }
                });
    }
    public void getPrices( int uid,String sid,int scheduleId, String seat, String sign,Icontract.Imodel imodel){
        NetUtils.getInstance().getData(ApiService.class)
                .getxiadan(uid,sid,scheduleId,seat,sign)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<XiaDanBean>() {
                    @Override
                    public void accept(XiaDanBean xiaDanBean) throws Exception {
                        imodel.success(xiaDanBean);
                    }
                });
    }
    public void getZhifu( int uid,String sid,int payType, String orderId,Icontract.Imodel imodel){
        NetUtils.getInstance().getData(ApiService.class)
                .getzhifu(uid,sid,payType,orderId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ZhiFuBean>() {
                    @Override
                    public void accept(ZhiFuBean zhiFuBean) throws Exception {
                        imodel.success(zhiFuBean);
                    }
                });
    }

    public void getYingTing(int movieId, int cid, Icontract.Imodel imodel){
        NetUtils.getInstance().getData(ApiService.class)
                .getyingting(movieId,cid)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<YingTingBean>() {
                    @Override
                    public void accept(YingTingBean yingTingBean) throws Exception {
                        imodel.success(yingTingBean);
                    }
                });
    }
    public void xuanzuo(int hid,Icontract.Imodel imodel){
        NetUtils.getInstance().getData(ApiService.class)
                .getzuowei(hid)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ZuoWeiHaoBean>() {
                    @Override
                    public void accept(ZuoWeiHaoBean zuoWeiHaoBean) throws Exception {
                        imodel.success(zuoWeiHaoBean);
                    }
                });
    }

    public void settou(int uid, String sid, MultipartBody.Part image,Icontract.Imodel iToux) {
        NetUtils.getInstance().getData(ApiService.class)
                .gettouxiang(uid, sid, image)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<TouXiangBean>() {
                    @Override
                    public void accept(TouXiangBean touXiangBean) throws Exception {
                        iToux.success(touXiangBean);
                    }
                });
    }

    public void getYonghu(int uid, String sid,Icontract.Imodel  imodel){
        NetUtils.getInstance().getData(ApiService.class)
                .getyonghu(uid,sid)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<YongHuBean>() {
                    @Override
                    public void accept(YongHuBean yongHuBean) throws Exception {
                        imodel.success(yongHuBean);
                    }
                });
    }
    public void getDate(int uid, String sid,String date,Icontract.Imodel  imodel){
        NetUtils.getInstance().getData(ApiService.class)
                .getBirth(uid,sid,date)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<BirthBean>() {
                    @Override
                    public void accept(BirthBean birthBean) throws Exception {
                        imodel.success(birthBean);
                    }
                });
    }
    public void YuYue(int uid, String sid,int mid,Icontract.Imodel imodel){
        NetUtils.getInstance().getData(ApiService.class)
                .yuyues(uid,sid,mid)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<YuYueEmnety>() {
                    @Override
                    public void accept(YuYueEmnety yuYueEmnety) throws Exception {
                        imodel.success(yuYueEmnety);
                    }
                });
    }
    public void ChaYuYue(int uid, String sid,Icontract.Imodel imodel){
        NetUtils.getInstance().getData(ApiService.class)
                .yuyue(uid,sid)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<YuYueBean>() {
                    @Override
                    public void accept(YuYueBean yuYueBean) throws Exception {
                        imodel.success(yuYueBean);
                    }
                });
    }

}