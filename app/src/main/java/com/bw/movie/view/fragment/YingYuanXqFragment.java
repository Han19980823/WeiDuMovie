package com.bw.movie.view.fragment;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bw.movie.R;
import com.bw.movie.base.mvp.BaseFragment;
import com.bw.movie.base.mvp.BasePresenter;
import com.bw.movie.bean.AddaresBean;
import com.bw.movie.contract.Icontract;
import com.bw.movie.presenter.Presenter;
import com.bw.movie.view.activity.CinemaInfoActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


/**
 * 作者：Han98
 * 创建时间：2019/12/12
 * 描述：TODO
 * 最近修改：2019/12/12 19:04 modify by liujc
 */
public class YingYuanXqFragment extends BaseFragment implements Icontract.Iaddpre {
    @BindView(R.id.cinima_location)
    ImageView cinimaLocation;
    @BindView(R.id.location_address)
    TextView locationAddress;
    @BindView(R.id.dianhua)
    ImageView dianhua;
    @BindView(R.id.dianhua_text)
    TextView dianhuaText;
    @BindView(R.id.address)
    TextView address;
    private int cinemaId;
    public Unbinder unbinder;

    @Override
    protected void initView(View view) {
        unbinder =  ButterKnife.bind(this
        ,view);
    }

    @Override
    protected void initData() {


    }

    @Override
    protected int initLayout() {
        return R.layout.yingyuanxq;
    }

    @Override
    protected BasePresenter Ipresenter() {
        cinemaId = CinemaInfoActivity.cinemaId;
        Presenter presenter = new Presenter() ;
        presenter.getSAdd(cinemaId);
        return presenter;
    }

    @Override
    public void success(AddaresBean addaresBean) {
        locationAddress.setText(addaresBean.getResult().getAddress());
        dianhuaText.setText(addaresBean.getResult().getPhone());
        address.setText(addaresBean.getResult().getVehicleRoute());
    }
}
