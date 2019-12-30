package com.bw.movie.view.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.List;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

import com.bw.movie.R;

import com.bw.movie.base.mvp.BaseFragment;
import com.bw.movie.base.mvp.BasePresenter;
import com.bw.movie.bean.DetailsBean;
import com.bw.movie.contract.Icontract;
import com.bw.movie.dapter.PlayerAdapter;
import com.bw.movie.presenter.Presenter;

/**
 * 作者：Han98
 * 创建时间：2019/12/10
 * 描述：TODO
 * 最近修改：2019/12/10 16:42 modify by liujc
 */
public class TrailerFragment extends BaseFragment implements Icontract.IDetail {

    Presenter presenter;
    @BindView(R.id.player_recy)
    RecyclerView playerRecy;

      public   Unbinder bind;
    @Override
    protected void initView(View view) {
        bind = ButterKnife.bind(this,view);
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        playerRecy.setLayoutManager(manager);
    }

    @Override
    protected void initData() {
        Intent intent = getActivity().getIntent();
        Bundle extras = intent.getExtras();
        int movieid = extras.getInt("movieid");
        presenter.getDetalis1(movieid);
    }

    @Override
    protected int initLayout() {
        return R.layout.trailer;
    }

    @Override
    protected BasePresenter Ipresenter() {
        presenter = new Presenter();
        return presenter;
    }

    @Override
    public void deTails(DetailsBean detailsBean) {
        DetailsBean.ResultBean result = detailsBean.getResult();
        List<DetailsBean.ResultBean.ShortFilmListBean> shortFilmList = result.getShortFilmList();

        PlayerAdapter adapter = new PlayerAdapter(shortFilmList,getContext());

        playerRecy.setAdapter(adapter);

    }
}
