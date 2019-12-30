package com.bw.movie.view.activity;

import android.content.Intent;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bw.movie.R;
import com.bw.movie.base.BaseActivity;
import com.bw.movie.base.BasePresenterActivity;
import com.bw.movie.bean.DetailsBean;
import com.bw.movie.bean.MoviesDateilBean;
import com.bw.movie.bean.PriceBean;
import com.bw.movie.bean.RegionListBean;
import com.bw.movie.bean.SeatInfoBean;
import com.bw.movie.bean.ShiJianBean;
import com.bw.movie.bean.ShiJianYingYuanBean;
import com.bw.movie.bean.XuanZuoXinXiBean;
import com.bw.movie.contract.Icontract;
import com.bw.movie.dapter.PriceAdapter;
import com.bw.movie.dapter.QuLieAdapter;
import com.bw.movie.dapter.ShiJianAdapter;
import com.bw.movie.dapter.ShiJianYingYuanAdapter;
import com.bw.movie.dapter.XuanZuoXinXiAdapter;
import com.bw.movie.presenter.Presenter2;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;

public class ChooseActivity extends BaseActivity implements Icontract.IInfos {


    @BindView(R.id.xuanzuo_fanhui)
    SimpleDraweeView xuanzuoFanhui;
    @BindView(R.id.imgseactseat)
    JCVideoPlayer imgseactseat;
    @BindView(R.id.xuanzuo_name)
    TextView xuanzuoName;
    @BindView(R.id.xuanzuo_time)
    TextView xuanzuoTime;
    @BindView(R.id.xuanzuo_fen)
    TextView xuanzuoFen;
    @BindView(R.id.xuanzuo_daoyan)
    TextView xuanzuoDaoyan;
    @BindView(R.id.xuanzuo_quyu)
    TextView xuanzuoQuyu;
    @BindView(R.id.xuanzuo_shijian)
    TextView xuanzuoShijian;
    @BindView(R.id.xuanzuo_price)
    RadioButton xuanzuoPrice;
    @BindView(R.id.img_seatsesrach)
    SimpleDraweeView imgSeatsesrach;
    @BindView(R.id.xuanzuo_rlv)
    RecyclerView xuanzuoRlv;
    @BindView(R.id.include_text)
    TextView includeText;
    @BindView(R.id.include_relate)
    RelativeLayout includeRelate;
    private int key;
    private Presenter2 presenter2;

    @Override
    public void success(SeatInfoBean seatInfoBean) {


        //  EventBus.getDefault().postSticky(xuanZuoXinXiBean);

    }


    @Override
    public void successes(MoviesDateilBean moviesDateilBean) {

    }

    @Override
    public void successDe(DetailsBean detailsBean) {
        if (detailsBean.getStatus().equals("0000")){
            DetailsBean.ResultBean result = detailsBean.getResult();
            if (result!=null){
                includeRelate.setVisibility(View.GONE);
                xuanzuoRlv.setVisibility(View.VISIBLE);
                //shipin视频
                imgseactseat.setUp(result.getShortFilmList().get(0).getVideoUrl(), JCVideoPlayer.SCREEN_LAYOUT_NORMAL, "");
                //    Glide.with(this).load(result.getShortFilmList().get(0).getImageUrl()).into(imgseactseat.ivThumb);
                // imgseactseat.ivThumb.(result.getShortFilmList().get(0).getImageUrl());
                //电影名
                xuanzuoName.setText(result.getName());
                //时长
                xuanzuoTime.setText(result.getDuration());
                //评分
                xuanzuoFen.setText(result.getScore() + "分");
                //导演
                List<DetailsBean.ResultBean.MovieDirectorBean> movieDirector = result.getMovieDirector();
                xuanzuoDaoyan.setText(movieDirector.get(0).getName());
            }else{
                includeRelate.setVisibility(View.VISIBLE);
                xuanzuoRlv.setVisibility(View.GONE);
                includeText.setText("暂无数据");
            }
        }else{
            Toast.makeText(this, detailsBean.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void price(PriceBean priceBean) {
        if (priceBean.getStatus().equals("0000")){
            List<PriceBean.ResultBean> result = priceBean.getResult();
            if (result!=null){
                includeRelate.setVisibility(View.GONE);
                xuanzuoRlv.setVisibility(View.VISIBLE);
                PriceAdapter priceAdapter = new PriceAdapter(this,result);
                xuanzuoRlv.setAdapter(priceAdapter);
                //布局管理器
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
                xuanzuoRlv.setLayoutManager(linearLayoutManager);
                //j接口回调
                priceAdapter.setOnItemClicks(new PriceAdapter.onItemClicks() {
                    @Override
                    public void onChangeData(int p) {
                        Intent intent = new Intent(ChooseActivity.this, GouPiaoActivity.class);
                        intent.putExtra("cinemaid", p);
                        intent.putExtra("key", key);
                        startActivity(intent);
                    }
                });
            }else{
                includeRelate.setVisibility(View.VISIBLE);
                xuanzuoRlv.setVisibility(View.GONE);
                includeText.setText("暂无数据");
            }
        }else{
            Toast.makeText(this, priceBean.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void shijian(ShiJianBean shiJianBean) {
        if (shiJianBean.getStatus().equals("0000")){
            List<String> result = shiJianBean.getResult();
            if (result!=null){
                includeRelate.setVisibility(View.GONE);
                xuanzuoRlv.setVisibility(View.VISIBLE);
                ShiJianAdapter shiJianAdapter = new ShiJianAdapter(this, shiJianBean);
                xuanzuoRlv.setAdapter(shiJianAdapter);
                shiJianAdapter.setOnItemClicks(new ShiJianAdapter.onItemClicks() {
                    @Override
                    public void onChangeData(String p) {
                        xuanzuoShijian.setText(p);
                        presenter2.shijianyingyuan(key, p, 1, 5);
                    }
                });
                //布局管理器
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
                xuanzuoRlv.setLayoutManager(linearLayoutManager);

            }else{
                includeRelate.setVisibility(View.VISIBLE);
                xuanzuoRlv.setVisibility(View.GONE);
                includeText.setText("暂无数据");
            }
        }else{
            Toast.makeText(this, shiJianBean.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void shijianyingyuan(ShiJianYingYuanBean shiJianYingYuanBean) {
        if (shiJianYingYuanBean.equals("0000")) {
            List<ShiJianYingYuanBean.ResultBean> result = shiJianYingYuanBean.getResult();
            if (result != null) {
                includeRelate.setVisibility(View.GONE);
                xuanzuoRlv.setVisibility(View.VISIBLE);
                ShiJianYingYuanAdapter shiJianYingYuanAdapter = new ShiJianYingYuanAdapter(this,result);
                xuanzuoRlv.setAdapter(shiJianYingYuanAdapter);
                //布局管理器
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
                xuanzuoRlv.setLayoutManager(linearLayoutManager);
                shiJianYingYuanAdapter.setOnItemClicks(new ShiJianYingYuanAdapter.onItemClicks() {
                    @Override
                    public void onChangeData(int p) {
                        Intent intent = new Intent(ChooseActivity.this, GouPiaoActivity.class);
                        intent.putExtra("cinemaid", p);
                        intent.putExtra("key", key);
                        startActivity(intent);
                    }
                });
            } else {
                includeRelate.setVisibility(View.VISIBLE);
                xuanzuoRlv.setVisibility(View.GONE);
                includeText.setText("暂无数据");
            }
        }else{
            Toast.makeText(this,shiJianYingYuanBean.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void Regis(RegionListBean regionListBean) {
        if (regionListBean.getStatus().equals("0000")) {
            List<RegionListBean.ResultBean> result = regionListBean.getResult();
            if (result != null) {
                includeRelate.setVisibility(View.GONE);
                xuanzuoRlv.setVisibility(View.VISIBLE);
                QuLieAdapter quLieAdapter = new QuLieAdapter(result,this);
                xuanzuoRlv.setAdapter(quLieAdapter);
                //布局管理器
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
                xuanzuoRlv.setLayoutManager(linearLayoutManager);
                quLieAdapter.setOnItemClicks(new QuLieAdapter.onItemClicks() {
                    @Override
                    public void onChangeData(int p) {
                        xuanzuoQuyu.setText(result.get(p - 1).getRegionName());
                        presenter2.xuanzuoxinxi(key, p, 1, 5);
                    }
                });
            }else{
                includeRelate.setVisibility(View.VISIBLE);
                xuanzuoRlv.setVisibility(View.GONE);
                includeText.setText("暂无数据");
            }
        } else {
            Toast.makeText(this, regionListBean.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void xuanzuo(XuanZuoXinXiBean xuanZuoXinXiBean) {
        if (xuanZuoXinXiBean.getStatus().equals("0000")) {
            List<XuanZuoXinXiBean.ResultBean> result = xuanZuoXinXiBean.getResult();
            if (result != null) {
                includeRelate.setVisibility(View.GONE);
                xuanzuoRlv.setVisibility(View.VISIBLE);
                XuanZuoXinXiAdapter xuanZuoXinXiAdapter = new XuanZuoXinXiAdapter(result,this);

                xuanzuoRlv.setAdapter(xuanZuoXinXiAdapter);
                //布局管理器
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
                xuanzuoRlv.setLayoutManager(linearLayoutManager);
                xuanZuoXinXiAdapter.setOnItemClicks(new XuanZuoXinXiAdapter.onItemClicks() {
                    @Override
                    public void onChangeData(int p) {
                        Intent intent = new Intent(ChooseActivity.this, GouPiaoActivity.class);
                        intent.putExtra("cinemaid", p);
                        intent.putExtra("key", key);
                        startActivity(intent);
                    }
                });
            }else{
                includeRelate.setVisibility(View.VISIBLE);
                xuanzuoRlv.setVisibility(View.GONE);
                includeText.setText("暂无数据");
            }
        } else {
            Toast.makeText(this, xuanZuoXinXiBean.getMessage(), Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    protected BasePresenterActivity Ipresenter() {
        Intent intent = getIntent();
        key = intent.getIntExtra("movieeId", 0);
        presenter2 = new Presenter2();
        presenter2.chooser(key);
        return presenter2;
    }

    @Override
    protected void initData() {

        //布局管理器
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        xuanzuoRlv.setLayoutManager(linearLayoutManager);
    }

    @Override
    protected void initView() {
        unbinder = ButterKnife.bind(this);
    }

    @Override
    protected int initLayout() {
        return R.layout.activity_choose;
    }

    @OnClick({R.id.xuanzuo_fanhui, R.id.xuanzuo_quyu, R.id.xuanzuo_shijian, R.id.xuanzuo_price})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.xuanzuo_fanhui:
                finish();
                break;
            case R.id.xuanzuo_quyu:
                presenter2.getRegion();
                break;
            case R.id.xuanzuo_shijian:
                presenter2.getshijian();
                break;
            case R.id.xuanzuo_price:
                presenter2.getPrice(key, 1, 5);
                break;
        }
    }


}
