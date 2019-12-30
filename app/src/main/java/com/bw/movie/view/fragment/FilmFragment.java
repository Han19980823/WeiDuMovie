package com.bw.movie.view.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.List;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

import com.bw.movie.R;

import com.bw.movie.base.mvp.BaseFragment;
import com.bw.movie.base.mvp.BasePresenter;
import com.bw.movie.bean.PinglunBean;
import com.bw.movie.contract.Icontract;
import com.bw.movie.dapter.FilmAdapter;
import com.bw.movie.presenter.Presenter;

/**
 * 作者：Han98
 * 创建时间：2019/12/10
 * 描述：TODO
 * 最近修改：2019/12/10 16:44 modify by liujc
 */
public class FilmFragment extends BaseFragment implements Icontract.film {

    @BindView(R.id.pinglun_recy)
    RecyclerView pinglunRecy;
    private Presenter presenter;

    @Override
    protected void initView(View view) {
        ButterKnife.bind(this,view);
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        pinglunRecy.setLayoutManager(manager);
    }

    @Override
    protected void initData() {
        Intent intent = getActivity().getIntent();
        Bundle extras = intent.getExtras();
        int movieid = extras.getInt("movieid");
        presenter.getPinglun(movieid);
    }

    @Override
    protected int initLayout() {
        return R.layout.film;
    }

    @Override
    protected BasePresenter Ipresenter() {
        presenter = new Presenter();
        return presenter;
    }

    @Override
    public void fils(PinglunBean pinglunBean) {
        List<PinglunBean.ResultBean> result = pinglunBean.getResult();
        FilmAdapter adapter = new FilmAdapter(result,getContext());
        pinglunRecy.setAdapter(adapter);
    }
}
