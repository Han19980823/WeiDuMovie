package com.bw.movie.view.fragment;

import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bw.movie.R;

import com.bw.movie.base.mvp.BaseFragment;
import com.bw.movie.base.mvp.BasePresenter;
import com.bw.movie.bean.MoviesDateilBean;

import com.google.gson.Gson;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


public class Details_Foreshow_Fragment extends BaseFragment {


    @Override
    protected void initView(View view) {

    }

    @Override
    protected void initData() {

    }

    @Override
    public int initLayout() {
        return R.layout.details_foreshow;
    }

    @Override
    protected BasePresenter Ipresenter() {
        return null;
    }


}
