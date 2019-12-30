package com.bw.movie.view.fragment;

import android.view.View;
import android.widget.Toast;

import com.bw.movie.R;
import com.bw.movie.base.mvp.BaseFragment;
import com.bw.movie.base.mvp.BasePresenter;
import com.bw.movie.bean.MovieBean;
import com.bw.movie.contract.Icontract;
import com.bw.movie.dapter.Home1Adapters;
import com.bw.movie.dapter.HomeAdapter;
import com.bw.movie.presenter.Presenter;

import java.util.List;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 作者：Han98
 * 创建时间：2019/12/16
 * 描述：TODO
 * 最近修改：2019/12/16 15:50 modify by liujc
 */
public class CinemaScheduleFragment extends BaseFragment implements Icontract.Iviews {

    @BindView(R.id.be_recy)
    RecyclerView beRecy;

    @Override
    protected void initView(View view) {
        ButterKnife.bind(this, view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        beRecy.setLayoutManager(layoutManager);
    }

    @Override
    protected void initData() {


    }

    @Override
    protected int initLayout() {

        return R.layout.zhouqi;
    }

    @Override
    protected BasePresenter Ipresenter() {
        Presenter presenter = new Presenter();
        presenter.getMoview();
        return presenter;
    }


    @Override
    public void success(MovieBean movieBean) {
        Toast.makeText(getContext(), movieBean.getMessage(), Toast.LENGTH_SHORT).show();
        List<MovieBean.ResultBean> movieBeanResult = movieBean.getResult();
        Home1Adapters homeAdapter = new Home1Adapters(getContext(),movieBeanResult);
        beRecy.setAdapter(homeAdapter);
    }
}
