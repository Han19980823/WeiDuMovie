package com.bw.movie.view.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bw.movie.R;
import com.bw.movie.base.BaseActivity;
import com.bw.movie.base.BasePresenterActivity;
import com.bw.movie.bean.DetailsBean;
import com.bw.movie.contract.Icontract;
import com.bw.movie.dapter.DetailsAdapter;
import com.bw.movie.presenter.Presenter2;
import com.bw.movie.view.fragment.FilmFragment;
import com.bw.movie.view.fragment.IntroduceFragment;
import com.bw.movie.view.fragment.StillFragment;
import com.bw.movie.view.fragment.TrailerFragment;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.tabs.TabLayout;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class DetailsActivity extends BaseActivity implements Icontract.IDetail {


    @BindView(R.id.sim)
    SimpleDraweeView img;
    @BindView(R.id.text_name)
    TextView textName;
    @BindView(R.id.text_time)
    TextView textTime;
    @BindView(R.id.text_time1)
    TextView textTime1;


    Unbinder bind;
    @BindView(R.id.lin_lay)
    LinearLayout linLay;
    @BindView(R.id.tab_layout)
    TabLayout tabLayout;
    @BindView(R.id.view_pager)
    ViewPager viewPager;
    @BindView(R.id.btn_xuanzuo)
    TextView btnXuanzuo;

    private Presenter2 presenter2;
    List<String> slist = new ArrayList<>();
    List<Fragment> flist = new ArrayList<>();
    private int movieid;

    @Override
    public void deTails(DetailsBean detailsBean) {
        DetailsBean.ResultBean result = detailsBean.getResult();
        String imageUrl = result.getImageUrl();
        img.setImageURI(imageUrl);
        textName.setText(result.getName());
        textTime.setText(result.getDuration());

        Long releaseTime = detailsBean.getResult().getReleaseTime();
        //mill为你龙类型的时间戳
        Date date = new Date(releaseTime);
        String strs = "";
        try {
            //yyyy表示年MM表示月dd表示日
            //yyyy-MM-dd是日期的格式，比如2015-12-12如果你要得到2015年12月12日就换成yyyy年MM月dd日
            SimpleDateFormat sdf = new SimpleDateFormat("MM月dd日");
            //进行格式化
            strs = sdf.format(date);
            textTime1.setText(strs + "中国大陆上映");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    protected BasePresenterActivity Ipresenter() {
        presenter2 = new Presenter2();

        return presenter2;
    }

    @Override
    protected void initData() {

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        movieid = extras.getInt("movieid");
        presenter2.getDetalis(movieid);
        slist.add("介绍");
        slist.add("预告");
        slist.add("剧照");
        slist.add("影评");
        flist.add(new IntroduceFragment());
        flist.add(new TrailerFragment());
        flist.add(new StillFragment());
        flist.add(new FilmFragment());
        DetailsAdapter adapter = new DetailsAdapter(getSupportFragmentManager(), slist, flist);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabTextColors(Color.WHITE, Color.WHITE);
        viewPager.setOffscreenPageLimit(4);

    }

    @Override
    protected void initView() {
       ButterKnife.bind(this);

    }

    @OnClick(R.id.btn_xuanzuo)
    public void setBtnXuanzuo(View view){
        Intent intent = new Intent(DetailsActivity.this,Main3Activity.class);
        intent.putExtra("cid",movieid);
        startActivity(intent);

    }

    @Override
    protected int initLayout() {
        return R.layout.activity_details;
    }


}
