package com.bw.movie.view.fragment;


import android.content.Intent;
import android.view.View;

import com.bw.movie.R;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import androidx.recyclerview.widget.LinearLayoutManager;
import butterknife.BindView;
import butterknife.ButterKnife;

import com.bw.movie.base.mvp.BaseFragment;
import com.bw.movie.base.mvp.BasePresenter;
import com.bw.movie.bean.RecommendBean;
import com.bw.movie.contract.Icontract;
import com.bw.movie.dapter.RecommendMovie_Adapter;
import com.bw.movie.presenter.Presenter;
import com.bw.movie.view.activity.CinemaInfoActivity;


public class RecommendMovie_Fragment extends BaseFragment implements Icontract.IMovie {
    @BindView(R.id.recommend_recycler)
    XRecyclerView recommendRecycler;

    private int page = 1;
    private List<RecommendBean.ResultBean> list;
    private RecommendMovie_Adapter recommendMovie_adapter;
    private Presenter presenter;

    @Override
    public int initLayout() {
        return R.layout.recommend_movie_fragment;
    }

    @Override
    protected BasePresenter Ipresenter() {
        presenter = new Presenter();

        return presenter;
    }


    @Override
    protected void initView(View view) {
        ButterKnife.bind(this, view);
        list = new ArrayList<>();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recommendRecycler.setLayoutManager(linearLayoutManager);
        recommendMovie_adapter = new RecommendMovie_Adapter(getActivity(), list);
        recommendRecycler.setAdapter(recommendMovie_adapter);
        requestData(page);
    }

    @Override
    public void initData() {
        recommendRecycler.setLoadingMoreEnabled(true);
        recommendRecycler.setPullRefreshEnabled(true);
        recommendRecycler.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                list.clear();
                page = 1;
                requestData(page);
                recommendRecycler.refreshComplete();
                recommendMovie_adapter.notifyDataSetChanged();
            }

            @Override
            public void onLoadMore() {
                page++;
                requestData(page);
                recommendRecycler.refreshComplete();
                recommendMovie_adapter.notifyDataSetChanged();
            }
        });
    }


    private void requestData(int page) {
        Map<String, Object> map = new HashMap<>();
        map.put("count", 5);
        map.put("page", page);
        presenter.getRecomm(map);
    }


    @Override
    public void success(RecommendBean recommendBean) {
        List<RecommendBean.ResultBean> result = recommendBean.getResult();
        list.addAll(result);
        recommendMovie_adapter.notifyDataSetChanged();
//        recommendMovie_adapter.setItemClick(new RecommendMovie_Adapter.setClick() {
//            @Override
//            public void setOnClick(int position) {
//                Intent it = new Intent(getActivity(), CinemaInfoActivity.class);
//                it.putExtra("cinemaId", list.get(position).getId());
//                startActivity(it);
//            }
//        });
    }


}
