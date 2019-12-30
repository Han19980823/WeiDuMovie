package com.bw.movie.view.activity;

import android.graphics.Color;
import android.os.Bundle;

import com.bw.movie.R;
import com.bw.movie.base.BaseActivity;
import com.bw.movie.base.BasePresenterActivity;
import com.bw.movie.dapter.MyAdapter;
import com.bw.movie.view.fragment.HaidianFragment;
import com.bw.movie.view.fragment.JIntianFragment;
import com.bw.movie.view.fragment.PriceFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import butterknife.ButterKnife;

public class Main3Activity extends BaseActivity {

    @BindView(R.id.tab_layout)
    TabLayout tabLayout;
    @BindView(R.id.view_pager)
    ViewPager viewPager;
    List<String> slist = new ArrayList<>();
    List<Fragment> flist = new ArrayList<>();

    @Override
    protected BasePresenterActivity Ipresenter() {
        return null;
    }

    @Override
    protected void initData() {
        slist.add("海淀区");
        slist.add("今天");
        slist.add("价格最低");
        flist.add(new HaidianFragment());
        flist.add(new JIntianFragment());
        flist.add(new PriceFragment());
        MyAdapter adapter = new MyAdapter(getSupportFragmentManager(),slist,flist);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabTextColors(Color.WHITE,Color.WHITE);
        viewPager.setOffscreenPageLimit(3);

    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
    }

    @Override
    protected int initLayout() {
        return R.layout.activity_main3;
    }
}
