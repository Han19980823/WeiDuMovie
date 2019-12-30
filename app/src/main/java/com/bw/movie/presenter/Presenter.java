package com.bw.movie.presenter;

import android.widget.Toast;

import java.util.Map;

import com.bw.movie.base.mvp.BasePresenter;
import com.bw.movie.bean.AddaresBean;
import com.bw.movie.bean.BannerBean;
import com.bw.movie.bean.CinemaByRegionBean;
import com.bw.movie.bean.DetailsBean;
import com.bw.movie.bean.JiJiangBean;
import com.bw.movie.bean.MovieBean;
import com.bw.movie.bean.NearByMovieBean;
import com.bw.movie.bean.PinglunBean;
import com.bw.movie.bean.RecommendBean;
import com.bw.movie.bean.RegionListBean;
import com.bw.movie.bean.YuYueBean;
import com.bw.movie.bean.YuYueEmnety;
import com.bw.movie.bean.ZhengZaiBena;
import com.bw.movie.green.bean.FenLei1;
import com.bw.movie.green.dao.DaoSession;
import com.bw.movie.view.activity.App;
import com.bw.movie.view.fragment.CinemaScheduleFragment;
import com.bw.movie.view.fragment.FilmFragment;
import com.bw.movie.view.fragment.Fragment1;
import com.bw.movie.view.fragment.Fragment2;
import com.bw.movie.view.fragment.Fragment3;
import com.bw.movie.view.fragment.HaidianFragment;
import com.bw.movie.view.fragment.HomeFragment;
import com.bw.movie.view.fragment.IntroduceFragment;
import com.bw.movie.view.fragment.LocationSearch_Fragment;
import com.bw.movie.view.fragment.RecommendMovie_Fragment;
import com.bw.movie.view.fragment.StillFragment;
import com.bw.movie.view.fragment.TrailerFragment;
import com.bw.movie.contract.Icontract;
import com.bw.movie.model.Model;
import com.bw.movie.view.fragment.NearbyMovie_Fragment;
import com.bw.movie.view.fragment.YingYuanXqFragment;

/**
 * 作者：Han98
 * 创建时间：2019/12/4
 * 描述：TODO
 * 最近修改：2019/12/4 20:42 modify by liujc
 */
public class Presenter extends BasePresenter {
    Model model;
    private DaoSession daoSession;
    public Presenter() {
        model = new Model();

    }

    public void getBanner(){
      model.getUtils(new Icontract.Imodel() {
          @Override
          public void success(Object obj) {
              HomeFragment fragment = (HomeFragment) v;
              fragment.success((BannerBean) obj);
          }
      });
    }

    public void getMovie1(){
        model.getMovie(new Icontract.Imodel() {
            @Override
            public void success(Object obj) {

                HomeFragment fragment = (HomeFragment) v;
                fragment.movieSuccess1((MovieBean) obj);
            }
        });
    }

    public void getMovie2(){
        model.getMovie1(new Icontract.Imodel() {
            @Override
            public void success(Object obj) {
                HomeFragment fragment = (HomeFragment) v;
                fragment.zhengzai1((JiJiangBean) obj);

            }
        });
    }

    public void getMovie3(){
        model.getMovie2(new Icontract.Imodel() {
            @Override
            public void success(Object obj) {
                HomeFragment fragment = (HomeFragment) v;
                fragment.zhengzai2((ZhengZaiBena) obj);
            }
        });
    }
    public void  getDetalis(int mid){
        model.getDetails(mid, new Icontract.Imodel() {
            @Override
            public void success(Object obj) {
                IntroduceFragment fragment = (IntroduceFragment) v;

                fragment.deTails((DetailsBean) obj);


            }
        });
    }
    public void  getDetalis1(int mid){
        model.getDetails(mid, new Icontract.Imodel() {
            @Override
            public void success(Object obj) {
                TrailerFragment fragment1 = (TrailerFragment) v;
                fragment1.deTails((DetailsBean) obj);

            }
        });
    }
    public void  getDetalis2(int mid){
        model.getDetails(mid, new Icontract.Imodel() {
            @Override
            public void success(Object obj) {
                StillFragment fragment1 = (StillFragment) v;
                fragment1.Still((DetailsBean) obj);

            }
        });
    }

    public void getPinglun(int mid){
        model.getPinglun(mid, new Icontract.Imodel() {
            @Override
            public void success(Object obj) {
                FilmFragment filmFragment = (FilmFragment) v;
                filmFragment.fils((PinglunBean) obj);
            }
        });
    }

    public void getRecomm(Map<String,Object> map){
        model.getRecomm(new Icontract.Imodel() {
            @Override
            public void success(Object obj) {
                RecommendMovie_Fragment fragment = (RecommendMovie_Fragment) v;
                fragment.success((RecommendBean) obj);
            }
        },map);
    }
    public void home_Coming_Show(Map<String,Object> map){
        model.home_Coming_Show(new Icontract.Imodel() {
            @Override
            public void success(Object obj) {
                NearbyMovie_Fragment fragment = (NearbyMovie_Fragment) v;
                fragment.successe((NearByMovieBean) obj);
            }
        },map);
    }


    public void getRegion(){
        model.getRegion(new Icontract.Imodel() {
            @Override
            public void success(Object obj) {
                LocationSearch_Fragment fragment = (LocationSearch_Fragment) v;
                fragment.success((RegionListBean) obj);

            }
        });
    }

    public void getByRegion(int id){
            model.getByRegion(id, new Icontract.Imodel() {
                @Override
                public void success(Object obj) {
                    LocationSearch_Fragment fragment = (LocationSearch_Fragment) v;
                    fragment.Bysuccess((CinemaByRegionBean) obj);

                }
            });
    }
    public void getRegions(){
        model.getRegion(new Icontract.Imodel() {
            @Override
            public void success(Object obj) {

                HaidianFragment fragment1= (HaidianFragment) v;
                fragment1.success((RegionListBean) obj);

            }
        });
    }
    public void getByRegions(int id){
        model.getByRegion(id, new Icontract.Imodel() {
            @Override
            public void success(Object obj) {

                HaidianFragment fragment1= (HaidianFragment) v;
                fragment1.Bysuccess((CinemaByRegionBean) obj);
            }
        });
    }
    public void getSAdd(int id){
        model.getAdd(id, new Icontract.Imodel() {
            @Override
            public void success(Object obj) {
                YingYuanXqFragment fragment = (YingYuanXqFragment) v;
                fragment.success((AddaresBean) obj);
            }
        });
    }

    public void getMoview(){
        model.getMovie(new Icontract.Imodel() {
            @Override
            public void success(Object obj) {
                CinemaScheduleFragment fragment = (CinemaScheduleFragment) v;
                fragment.success((MovieBean) obj);
            }
        });
    }
    public void More1(){
        model.getMovie(new Icontract.Imodel() {
            @Override
            public void success(Object obj) {
                Fragment1 fragment1 = (Fragment1) v;
                fragment1.success((MovieBean) obj);
            }
        });
    }
    public void More2(){
        model.getMovie1(new Icontract.Imodel() {
            @Override
            public void success(Object obj) {
                Fragment2 fragment2= (Fragment2) v;
                fragment2.success((JiJiangBean) obj);
            }
        });
    }
    public void More3(){
        model.getMovie2(new Icontract.Imodel() {
            @Override
            public void success(Object obj) {
                Fragment3 fragment3= (Fragment3) v;
                fragment3.success((ZhengZaiBena) obj);
            }
        });
    }

    public void getYuyue(int uid,String sid,int mid){
        model.YuYue(uid, sid,mid, new Icontract.Imodel() {
            @Override
            public void success(Object obj) {
                HomeFragment fragment = (HomeFragment) v;
                fragment.yuyues((YuYueEmnety) obj);
            }
        });
    }

    public void getYuyue2(int uid,String sid,int mid){
        model.YuYue(uid, sid,mid, new Icontract.Imodel() {
            @Override
            public void success(Object obj) {
                Fragment1 fragment = (Fragment1) v;
                fragment.yuyues((YuYueEmnety) obj);
            }
        });
    }
    public void getYuyue3(int uid,String sid,int mid){
        model.YuYue(uid, sid,mid, new Icontract.Imodel() {
            @Override
            public void success(Object obj) {
                Fragment2 fragment = (Fragment2) v;
                fragment.yuyues((YuYueEmnety) obj);
            }
        });
    }
    public void getYuyue4(int uid,String sid,int mid){
        model.YuYue(uid, sid,mid, new Icontract.Imodel() {
            @Override
            public void success(Object obj) {
                Fragment3 fragment = (Fragment3) v;
                fragment.yuyues((YuYueEmnety) obj);
            }
        });
    }


}
