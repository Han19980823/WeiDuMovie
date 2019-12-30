package com.bw.movie.contract;

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
import com.bw.movie.bean.MoviesDateilBean;
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

/**
 * 作者：Han98
 * 创建时间：2019/12/4
 * 描述：TODO
 * 最近修改：2019/12/4 20:41 modify by liujc
 */
public interface Icontract {
    interface Imodel{
        void success(Object obj);
    }
    interface Iview{
        void success(BannerBean bannerBean);
        void movieSuccess1(MovieBean movieBean);
        void zhengzai1(JiJiangBean zhengZaiBena);
        void zhengzai2(ZhengZaiBena zhengZaiBena);
        void yuyues(YuYueEmnety yuYueEmnety);

    }
    interface Iview1{
        void success(LoginBean loginBean);
        void code(CodeBean codeBean);
        void regist(RegistBean registBean);

    }

    interface  Iselect{
        void Select(SelectBean selectBean);
        void movieSuccess1(MovieBean movieBean);
    }

    interface IDetail{
        void deTails(DetailsBean detailsBean);
    }
    interface  still{
        void  Still(DetailsBean detailsBean);
    }
    interface film{
        void fils(PinglunBean pinglunBean);
    }
    interface IMovie{
        void success(RecommendBean recommendBean);

    }
    interface  INear{
        void successe(NearByMovieBean nearByMovieBean);
    }

    interface  Iloca{
        void success(RegionListBean regionListBean);
        void Bysuccess(CinemaByRegionBean cinemaByRegionBean);
    }

    interface IWeChat{
        void success(WeChatBean weChatBean);
    }
    interface IInfo{
        void success(AddaresBean addaresBean);
    }
    interface Iaddpre{
        void success(AddaresBean addaresBean);
    }
    interface paiqi{
        void pai(PaiQiBean paiQiBean);

    }
    interface IZho{
        void zhou(ZhouQI zhouQI);
    }

    interface Iviews{
        void success(MovieBean movieBean);
    }
    interface  IInfos{
        void success(SeatInfoBean seatInfoBean);

        void successes(MoviesDateilBean moviesDateilBean);
        void successDe(DetailsBean detailsBean);
        void price(PriceBean priceBean);
        void shijian(ShiJianBean shiJianBean);
        void shijianyingyuan(ShiJianYingYuanBean shiJianYingYuanBean);
        void Regis(RegionListBean regionListBean);
        void xuanzuo(XuanZuoXinXiBean xuanZuoXinXiBean);

    }
    interface Xiadan{
        void success(XiaDanBean xiaDanBean);
        void zhifu(ZhiFuBean zhiFuBean);
        void xianfgqing(DetailsBean detailsBean);
        void yingting(YingTingBean yingTingBean);
        void zuozuo(ZuoWeiHaoBean zuoWeiHaoBean);
    }

    interface  IToux{
        void Touxaing(TouXiangBean touXiangBean);
        void yh(YongHuBean yongHuBean);
        void bir(BirthBean birthBean);
    }
    interface IFragm1{
        void success(MovieBean movieBean);
        void yuyues(YuYueEmnety yuYueEmnety);
    }
    interface IFragm2{
        void success(JiJiangBean jiJiangBean);
        void yuyues(YuYueEmnety yuYueEmnety);
    }
    interface IFragm3{
        void success(ZhengZaiBena zhengZaiBena);
        void yuyues(YuYueEmnety yuYueEmnety);
    }
    interface  chaYuYue{
        void success(YuYueBean yuYueBean);
    }


}
