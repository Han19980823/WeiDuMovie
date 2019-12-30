package com.bw.movie.view.fragment;
import android.content.Intent;
import android.view.View;

import java.util.List;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

import com.bw.movie.R;
import com.bw.movie.bean.CinemaByRegionBean;
import com.bw.movie.bean.RegionListBean;
import com.bw.movie.dapter.CinemaByRegionAdapter;
import com.bw.movie.view.activity.CinemaInfoActivity;

import com.bw.movie.base.mvp.BaseFragment;
import com.bw.movie.base.mvp.BasePresenter;
import com.bw.movie.contract.Icontract;
import com.bw.movie.dapter.DistrictAdapter;
import com.bw.movie.presenter.Presenter;

public class LocationSearch_Fragment extends BaseFragment  implements Icontract.Iloca {
    @BindView(R.id.location_recycler)
    RecyclerView locationRecycler;
    @BindView(R.id.location_recycler2)
    RecyclerView locationRecycler2;
    private DistrictAdapter districtAdapter;
    private CinemaByRegionAdapter cinemaByRegionAdapter;
    private Presenter presenter;


    @Override
    public int initLayout() {
        return R.layout.location_search_fragment;
    }

    @Override
    protected BasePresenter Ipresenter() {
        presenter = new Presenter();
        presenter.getRegion();
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
                presenter.getByRegion(regionId);
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
