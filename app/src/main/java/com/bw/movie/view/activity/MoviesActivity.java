package com.bw.movie.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bw.movie.R;
import com.bw.movie.base.BaseActivity;
import com.bw.movie.base.BasePresenterActivity;
import com.bw.movie.bean.ZhouQI;
import com.bw.movie.contract.Icontract;
import com.bw.movie.dapter.ZhouQIAdapter;
import com.bw.movie.presenter.Presenter;
import com.bw.movie.presenter.Presenter2;
import com.bw.movie.view.fragment.CinemaScheduleFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.annotations.Nullable;

/**
 * 作者：Han98
 * 创建时间：2019/12/16
 * 描述：TODO
 * 最近修改：2019/12/16 17:13 modify by liujc
 */
public class MoviesActivity extends BaseActivity implements Icontract.IZho {

    private TabLayout tab;
    private ViewPager vp;

    private ArrayList<String> tablist;
    private ArrayList<Fragment> list;
    private Presenter2 presenter2;

    @Override
    protected BasePresenterActivity Ipresenter() {
        presenter2 = new Presenter2();
        presenter2.zhouqi();
        return presenter2;
    }

    @Override
    protected void initData() {


        list = new ArrayList<>();
        tablist = new ArrayList<>();
        list.add(new CinemaScheduleFragment());
        list.add(new CinemaScheduleFragment());
        list.add(new CinemaScheduleFragment());
        list.add(new CinemaScheduleFragment());
        list.add(new CinemaScheduleFragment());
        list.add(new CinemaScheduleFragment());
        list.add(new CinemaScheduleFragment());
        vp.setOffscreenPageLimit(7);
    }

    @Override
    protected void initView() {
        tab = findViewById(R.id.week_tab);
        vp = findViewById(R.id.week_vp);
    }



    @Override
    protected int initLayout() {
        return R.layout.movies;
    }


    @Override
    public void zhou(ZhouQI zhouQI) {
        List<String> result = zhouQI.getResult();
        for (String s : result) {
            tablist.add(s);
        }
        vp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                return list.get(i);
            }

            @Override
            public int getCount() {
                return list.size();
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return tablist.get(position);
            }
        });
        tab.setupWithViewPager(vp);

    }
}
