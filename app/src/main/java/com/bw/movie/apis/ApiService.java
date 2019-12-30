package com.bw.movie.apis;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import okhttp3.ResponseBody;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.HeaderMap;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

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
import com.bw.movie.bean.SeatBean;
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

/**
 * 作者：Han98
 * 创建时间：2019/12/4
 * 描述：TODO
 * 最近修改：2019/12/4 20:35 modify by liujc
 */
public interface ApiService {
    @GET("movieApi/tool/v2/banner")
    Observable<BannerBean> getBanner();
    @GET("movieApi/movie/v2/findHotMovieList")
    Observable<MovieBean> getMovie1(@Query("page") int page, @Query("count") int count);
    @GET("movieApi/movie/v2/findComingSoonMovieList")
    Observable<JiJiangBean>getMovie2(@Query("page") int page, @Query("count") int count);
    @GET("movieApi/movie/v2/findReleaseMovieList")
    Observable<ZhengZaiBena>getMovie3(@Query("page")int page, @Query("count") int count);

    /**
     * 发送验证码
     * @param enail
     * @return
     */
    @POST("movieApi/user/v2/sendOutEmailCode")
    @FormUrlEncoded
    Observable<CodeBean> code(@Field("email")String enail);
    /**
     * 注册
     */
    @POST("movieApi/user/v2/register")
    @FormUrlEncoded
    Observable<RegistBean> regist(@Field("nickName")String name, @Field("pwd") String pwd, @Field("email")String email, @Field("code")String code);
    /*

    登录
     */
    @POST("movieApi/user/v2/login")
    @FormUrlEncoded
    Observable<LoginBean> login(@Field("email")String email, @Field("pwd")String pwd);
    /*
    搜索
     */
    @GET("movieApi/movie/v2/findMovieByKeyword")
    Observable<SelectBean> select(@Query("keyword")String name, @Query("page")int page, @Query("count")int count);
    //详情
    @GET("movieApi/movie/v2/findMoviesDetail")
    Observable<DetailsBean> detail(@Header("userId") int uid, @Header("sessionId")String sid, @Query("movieId") int Movieid);

    //评论
    @GET("movieApi/movie/v2/findAllMovieComment")
    Observable<PinglunBean> pinglun(@Header("userId") int uid, @Header("sessionId")String sid, @Query("movieId") int Movieid, @Query("page")int page, @Query("count")int count);
    //查询推荐影院信息
    @GET("movieApi/cinema/v1/findRecommendCinemas")
    Observable<RecommendBean> getRecomm(@Header("userId") int uid, @Header("sessionId")String sid, @QueryMap Map<String, Object> map);
    @GET("movieApi/cinema/v1/findNearbyCinemas")
    Observable<NearByMovieBean> home_Coming_Show(@Header("userId") int uid, @Header("sessionId")String sid, @QueryMap Map<String, Object> map);
    //根据区域
    @GET("cinema/v2/findCinemaByRegion")
    Observable<RegionListBean> list (@Query("regionId") int id);
    //查询区域列表
    @GET("movieApi/tool/v2/findRegionList")
    Observable<RegionListBean> region();
    //根据区域查询影院
    @GET("movieApi/cinema/v2/findCinemaByRegion")
    Observable<CinemaByRegionBean> ciByregion(@Query("regionId") int id);
    //微信登录
    @POST("movieApi/user/v1/weChatBindingLogin")
    @FormUrlEncoded
    Observable<WeChatBean> WE_CHAT_BEAN_OBSERVABLE (@Field("code")String code);
    @GET("movieApi/cinema/v1/verify/followCinema")
    Observable<CinemaInfoBean> info(@Header("userId") int uid, @Header("sessionId")String sid,@Query("cinemaId") int cid);
    @GET("movieApi/cinema/v1/findCinemaInfo")
    Observable<AddaresBean> addares(@Header("userId") int uid, @Header("sessionId")String sid,@Query("cinemaId") int cid);
    @GET("movieApi/cinema/v2/findCinemaScheduleList")
    Observable<PaiQiBean> paiqi(@Query("cinemaId") int cid,@Query("page")int page, @Query("count")int count);
    @GET("movieApi/tool/v2/findDateList")
    Observable<ZhouQI> ZHOU_QI_OBSERVABLE();
    @GET("movieApi/movie/v2/findSeatInfo")
    Observable<SeatInfoBean> setinfo(@Query("hallId") int hid);
    @GET("movieApi/movie/v2/findMovieSchedule")
    Observable<MovieScheduleBean> getMoview(@Query("movieId") int mid,@Query("cinemaId") int cid);
    //价格
    //http://172.17.8.100/movieApi/movie/v2/findCinemasInfoByPrice?movieId=22&page=1&count=5
    @GET("movieApi/movie/v2/findCinemasInfoByPrice")
    Observable<PriceBean> getprice(@Query("movieId") int movieId, @Query("page") int page, @Query("count") int count);

    //时间
    //http://172.17.8.100/movieApi/tool/v2/findDateList
    @GET("movieApi/tool/v2/findDateList")
    Observable<ShiJianBean> getshijian();
    //时间查询影院信息

    //http://172.17.8.100/movieApi/movie/v2/findCinemasInfoByDate?movieId=22&date=11-20&page=1&count=5
    @GET("movieApi/movie/v2/findCinemasInfoByDate")
    Observable<ShiJianYingYuanBean> getshijianyingyuan(@Query("movieId") int movieId, @Query("date") String date, @Query("page") int page, @Query("count") int count);
    //yi影院信息
    //http://172.17.8.100/movieApi/movie/v2/findCinemasInfoByRegion?movieId=22&regionId=1&page=1&count=10
    @GET("movieApi/movie/v2/findCinemasInfoByRegion")
    Observable<XuanZuoXinXiBean> getxinxi(@Query("movieId") int movieId, @Query("regionId") int regionId, @Query("page") int page, @Query("count") int count);
    //下单
    //http://172.17.8.100/movieApi/movie/v2/verify/buyMovieTickets
    @FormUrlEncoded
    @POST("movieApi/movie/v2/verify/buyMovieTickets")
    Observable<XiaDanBean> getxiadan(@Header("userId") int userId, @Header("sessionId") String sessionId, @Field("scheduleId") int scheduleId, @Field("seat") String seat, @Field("sign") String sign);
 //z支付
    //http://172.17.8.100/movieApi/movie/v2/verify/pay
    @FormUrlEncoded
    @POST("movieApi/movie/v2/verify/pay")
    Observable<ZhiFuBean> getzhifu(@Header("userId") int userId, @Header("sessionId") String sessionId, @Field("payType") int payType, @Field("orderId") String orderId);
    //chaxun查询影厅
    //http://172.17.8.100/movieApi/movie/v2/findMovieSchedule?movieId=22&cinemaId=1
    @GET("movieApi/movie/v2/findMovieSchedule")
    Observable<YingTingBean> getyingting(@Query("movieId") int movieId, @Query("cinemaId") int cinemaId);
    //选座
    //http://172.17.8.100/movieApi/movie/v2/findSeatInfo?hallId=3
    @GET("movieApi/movie/v2/findSeatInfo")
    Observable<ZuoWeiHaoBean> getzuowei(@Query("hallId") int hallId);
    //上传头像
    //http://172.17.8.100/movieApi/user/v1/verify/uploadHeadPic
    @FormUrlEncoded
    @POST("movieApi/user/v1/verify/uploadHeadPic")
    Observable<TouXiangBean> gettouxiang(@Header("userId") int userId, @Header("sessionId") String sessionId, @Field("image") MultipartBody.Part image);
    //用户信息
    //http://172.17.8.100/movieApi/user/v1/verify/getUserInfoByUserId
    @GET("movieApi/user/v1/verify/getUserInfoByUserId")
    Observable<YongHuBean> getyonghu(@Header("userId") int userId, @Header("sessionId") String sessionId);
    //http://172.17.8.100/movieApi/user/v2/verify/updateUserBirthday修改生日
    @FormUrlEncoded
    @POST("movieApi/user/v2/verify/updateUserBirthday")
    Observable<BirthBean> getBirth(@Header("userId") int userId, @Header("sessionId") String sessionId, @Field("birthday") String birthday);
    //预约
    @FormUrlEncoded
     @POST("movieApi/movie/v2/verify/reserve")
    Observable<YuYueEmnety> yuyues(@Header("userId") int userId, @Header("sessionId") String sessionId,@Field("movieId") int mid);


    //查询预约
    @GET("movieApi/user/v2/verify/findUserReserve")
    Observable<YuYueBean> yuyue (@Header("userId") int userId, @Header("sessionId") String sessionId);

}