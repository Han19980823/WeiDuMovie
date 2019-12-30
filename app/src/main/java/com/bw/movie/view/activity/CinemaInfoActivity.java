package com.bw.movie.view.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bw.movie.R;
import com.bw.movie.bean.AddaresBean;
import com.bw.movie.bean.CinemaInfoBean;
import com.bw.movie.contract.Icontract;
import com.bw.movie.presenter.Presenter;
import com.bw.movie.presenter.Presenter2;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

import com.bw.movie.view.fragment.YingYuanPjFragment;

import com.bw.movie.base.BaseActivity;
import com.bw.movie.base.BasePresenterActivity;
import com.bw.movie.dapter.ItemAdapter;
import com.bw.movie.view.fragment.YingYuanXqFragment;

public class CinemaInfoActivity extends BaseActivity implements Icontract.IInfo {


    @BindView(R.id.cinemainfo_back_activity)
    ImageView cinemainfoBackActivity;
    @BindView(R.id.cinemainfo_name)
    TextView cinemainfoName;
    @BindView(R.id.focus)
    ImageView focus;
    @BindView(R.id.cinemainfo_type)
    TextView cinemainfoType;
    @BindView(R.id.cinemainfo_tab)
    TabLayout cinemainfoTab;
    @BindView(R.id.cinemainfo_viewpage)
    ViewPager cinemainfoViewpage;
    @BindView(R.id.cinemainfo_but)
    Button cinemainfoBut;
    List<String> slist = new ArrayList<>();
    List<Fragment> flist = new ArrayList<>();
    private Presenter2 presenter2;
    public static int cinemaId;
    public Unbinder unbind;
    @Override
    protected BasePresenterActivity Ipresenter() {
        Intent intent = getIntent();
        cinemaId = intent.getIntExtra("cinemaId", 0);
        presenter2 = new Presenter2();
        presenter2.getSAdd(cinemaId);
        return presenter2;
    }

    @Override
    protected void initData() {

        slist.add("影院详情");
        slist.add("影院评价");
        flist.add(new YingYuanXqFragment());
        flist.add(new YingYuanPjFragment());
        ItemAdapter adapter = new ItemAdapter(getSupportFragmentManager(),flist,slist);
        cinemainfoViewpage.setAdapter(adapter);
        cinemainfoTab.setupWithViewPager(cinemainfoViewpage);
        cinemainfoTab.setTabTextColors(Color.WHITE,Color.WHITE);
    }

    @OnClick(R.id.cinemainfo_but)
    public void setCinemainfoBut(View view){
        Intent intent = new Intent(this,MoviesActivity.class);

        startActivity(intent);
    }
    @Override
    protected void initView() {
         unbind = ButterKnife.bind(this);
    }

    @Override
    protected int initLayout() {
        return R.layout.activity_cinema_info;
    }


    @Override
    public void success(AddaresBean addaresBean) {


        cinemainfoName.setText(addaresBean.getResult().getName());
        final int followCinema = addaresBean.getResult().getFollowCinema();
        if (followCinema == 1){
            Glide.with(this).load(R.drawable.emptyheart).into(focus);
        }else {
            Glide.with(this).load(R.mipmap.emptyhearts).into(focus);
        }
        cinemainfoType.setText(addaresBean.getResult().getLabel());
    }
}
