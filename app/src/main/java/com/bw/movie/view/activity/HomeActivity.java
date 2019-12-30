package com.bw.movie.view.activity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

import com.bw.movie.R;
import com.bw.movie.view.fragment.HomeFragment;
import com.bw.movie.view.fragment.MovieFragment;
import com.bw.movie.view.fragment.NoScrollViewPager;

import com.bw.movie.base.BaseActivity;
import com.bw.movie.base.BasePresenterActivity;
import com.bw.movie.view.fragment.MyFragment;

public class HomeActivity extends BaseActivity {

    @BindView(R.id.vp)
    NoScrollViewPager vp;
    @BindView(R.id.yingpian)
    LinearLayout yingpian;
    @BindView(R.id.movie)
    LinearLayout movie;
    @BindView(R.id.relat_a)
    RelativeLayout relatA;
    @BindView(R.id.shapes)
    LinearLayout shapes;
    @BindView(R.id.cinema)
    LinearLayout cinema;
    @BindView(R.id.relat_b)
    RelativeLayout relatB;
    @BindView(R.id.my)
    LinearLayout my;
    @BindView(R.id.my_a)
    LinearLayout myA;
    @BindView(R.id.relat_c)
    RelativeLayout relatC;

    private Unbinder bind;


    @Override
    protected BasePresenterActivity Ipresenter() {
        return null;
    }

    @Override
    protected void initData() {

        ArrayList<Fragment> list = new ArrayList<>();
        list.add(new HomeFragment());
        list.add(new MovieFragment());
        list.add(new MyFragment());
        vp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return list.get(position);
            }

            @Override
            public int getCount() {
                return list.size();
            }
        });
        vp.setOffscreenPageLimit(3);
        vp.setScanScroll(false);

    }



        @Override
    protected void initView() {
        bind = ButterKnife.bind(this);
    }

    @Override
    protected int initLayout() {
        return R.layout.activity_home;
    }


    @OnClick({R.id.relat_a, R.id.relat_b, R.id.relat_c})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.relat_a:
                yingpian.setVisibility ( View.VISIBLE );
                movie.setVisibility ( View.GONE );
                shapes.setVisibility ( View.GONE );
                cinema.setVisibility ( View.VISIBLE );
                my.setVisibility ( View.GONE );
                myA.setVisibility ( View.VISIBLE );
                vp.setCurrentItem ( 0 );
                break;
            case R.id.relat_b:
                yingpian.setVisibility ( View.GONE );
                movie.setVisibility ( View.VISIBLE );
                shapes.setVisibility ( View.VISIBLE );
                cinema.setVisibility ( View.GONE );
                my.setVisibility ( View.GONE );
                myA.setVisibility ( View.VISIBLE );
                vp.setCurrentItem ( 1 );
                break;
            case R.id.relat_c:
                yingpian.setVisibility ( View.GONE );
                movie.setVisibility ( View.VISIBLE );
                shapes.setVisibility ( View.GONE );
                cinema.setVisibility ( View.VISIBLE );
                my.setVisibility ( View.VISIBLE );
                myA.setVisibility ( View.GONE );
                vp.setCurrentItem ( 2 );
                break;
        }
    }


}
