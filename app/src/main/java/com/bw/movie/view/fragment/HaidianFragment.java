package com.bw.movie.view.fragment;

import android.content.Intent;
import android.view.View;

import com.bw.movie.R;
import com.bw.movie.base.mvp.BaseFragment;
import com.bw.movie.base.mvp.BasePresenter;
import com.bw.movie.bean.CinemaByRegionBean;
import com.bw.movie.bean.RegionListBean;
import com.bw.movie.contract.Icontract;
import com.bw.movie.dapter.CinemaByRegionAdapter;
import com.bw.movie.dapter.DistrictAdapter;
import com.bw.movie.presenter.Presenter;
import com.bw.movie.view.activity.CinemaInfoActivity;

import java.util.List;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 作者：Han98
 * 创建时间：2019/12/16
 * 描述：TODO
 * 最近修改：2019/12/16 16:33 modify by liujc
 */
public class HaidianFragment extends BaseFragment implements Icontract.Iloca {
    @BindView(R.id.location_recycler)
    RecyclerView locationRecycler;
    @BindView(R.id.location_recycler2)
    RecyclerView locationRecycler2;
    private DistrictAdapter districtAdapter;
    private CinemaByRegionAdapter cinemaByRegionAdapter;
    private Presenter presenter;


    @Override
    public int initLayout() {
        return R.layout.haidian;
    }

    @Override
    protected BasePresenter Ipresenter() {
        presenter = new Presenter();
        presenter.getRegions();
        return presenter;
    }



    @Override
    protected void initView(View view) {
        ButterKnife.bind(this,view);
    }

    @Override
    public void initData() {
        locationRecycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        locationRecycler2.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    @Override
    public void success(RegionListBean regionListBean) {
        final List<RegionListBean.ResultBean> result = regionListBean.getResult();
        districtAdapter = new DistrictAdapter(result, getActivity());
        locationRecycler.setAdapter(districtAdapter);
        districtAdapter.notifyDataSetChanged();

        districtAdapter.setOnItemClick(new DistrictAdapter.setItemClick() {
            @Override
            public void setClick(int position) {
                int regionId = result.get(position).getRegionId();
                presenter.getByRegions(regionId);
                locationRecycler2.setAdapter(cinemaByRegionAdapter);
            }
        });
    }

    @Override
    public void Bysuccess(CinemaByRegionBean cinemaByRegionBean) {
        List<CinemaByRegionBean.ResultBean> result = cinemaByRegionBean.getResult();

        cinemaByRegionAdapter = new CinemaByRegionAdapter(result, getActivity());
        cinemaByRegionAdapter.setItemClick(new CinemaByRegionAdapter.setOnClick() {
            @Override
            public void setClick(int position) {
                Intent it = new Intent(getActivity(), CinemaInfoActivity.class);
                it.putExtra("cinemaId",result.get(position).getId());
                startActivity(it);
                //Toast.makeText(getActivity(), childList.get(position).getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
