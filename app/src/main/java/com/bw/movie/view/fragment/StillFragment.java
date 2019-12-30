package com.bw.movie.view.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.List;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

import com.bw.movie.R;

import com.bw.movie.base.mvp.BaseFragment;
import com.bw.movie.base.mvp.BasePresenter;
import com.bw.movie.bean.DetailsBean;
import com.bw.movie.contract.Icontract;
import com.bw.movie.dapter.StillAdapter;
import com.bw.movie.presenter.Presenter;

/**
 * 作者：Han98
 * 创建时间：2019/12/10
 * 描述：TODO
 * 最近修改：2019/12/10 16:43 modify by liujc
 */
public class StillFragment extends BaseFragment implements Icontract.still {


    @BindView(R.id.still_recy)
    RecyclerView stillRecy;
    private Presenter presenter;

    @Override
    protected void initView(View view) {
        ButterKnife.bind(this, view);
        GridLayoutManager manager = new GridLayoutManager(getContext(),3);
        stillRecy.setLayoutManager(manager);
    }

    @Override
    protected void initData() {
        Intent intent = getActivity().getIntent();
        Bundle extras = intent.getExtras();
        int movieid = extras.getInt("movieid");
        presenter.getDetalis2(movieid);
    }

    @Override
    protected int initLayout() {

        return R.layout.still;
    }

    @Override
    protected BasePresenter Ipresenter() {
        presenter = new Presenter();

        return presenter;
    }

    @Override
    public void Still(DetailsBean detailsBean) {
        DetailsBean.ResultBean result = detailsBean.getResult();
        List<String> posterList = result.getPosterList();
        StillAdapter adapter = new StillAdapter(posterList,getContext());
        stillRecy.setAdapter(adapter);


    }
}
