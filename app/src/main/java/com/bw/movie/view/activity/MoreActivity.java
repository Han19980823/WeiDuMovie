package com.bw.movie.view.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TableLayout;

import com.bw.movie.R;
import com.bw.movie.base.BaseActivity;
import com.bw.movie.base.BasePresenterActivity;
import com.bw.movie.dapter.MoreAdapter;
import com.bw.movie.view.fragment.Fragment1;
import com.bw.movie.view.fragment.Fragment2;
import com.bw.movie.view.fragment.Fragment3;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MoreActivity extends BaseActivity {


    @BindView(R.id.back_gengduo)
    ImageView backGengduo;

    @BindView(R.id.btn_sou1)
    ImageView btnSou1;
    @BindView(R.id.tab_layout1)
    TabLayout tabLayout1;
    @BindView(R.id.view_pager1)
    ViewPager viewPager1;
    ArrayList<String> slist = new ArrayList<>();
    ArrayList<Fragment> flist = new ArrayList<>();

    @Override
    protected BasePresenterActivity Ipresenter() {
        return null;
    }
    @OnClick(R.id.btn_sou1)
    public void setBtn_sou(View view) {
        Intent intent = new Intent(this, SelectActivity.class);
        startActivity(intent);
    }

    @Override
    protected void initData() {
        slist.add("正在热映");
        slist.add("即将热映");
        slist.add("热门电影");
        flist.add(new Fragment1());
        flist.add(new Fragment2());
        flist.add(new Fragment3());
        MoreAdapter moreAdapter = new MoreAdapter(getSupportFragmentManager(), slist, flist);
        viewPager1.setAdapter(moreAdapter);

        tabLayout1.setupWithViewPager(viewPager1);
        tabLayout1.setTabTextColors(Color.WHITE,Color.WHITE);
        viewPager1.setOffscreenPageLimit(3);
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
    }

    @Override
    protected int initLayout() {
        return R.layout.activity_more;
    }


}
