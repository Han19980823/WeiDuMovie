package com.bw.movie.view.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bw.movie.R;
import com.bw.movie.base.mvp.BaseFragment;
import com.bw.movie.base.mvp.BasePresenter;
import com.bw.movie.bean.BannerBean;
import com.bw.movie.bean.JiJiangBean;
import com.bw.movie.bean.MovieBean;
import com.bw.movie.bean.YuYueBean;
import com.bw.movie.bean.YuYueEmnety;
import com.bw.movie.bean.ZhengZaiBena;
import com.bw.movie.contract.Icontract;
import com.bw.movie.dapter.Home1Adapter;
import com.bw.movie.dapter.Home2Adapter;
import com.bw.movie.dapter.HomeAdapter;
import com.bw.movie.presenter.Presenter;
import com.bw.movie.view.activity.MoreActivity;
import com.bw.movie.view.activity.SelectActivity;
import com.facebook.drawee.view.SimpleDraweeView;
import com.xuezj.cardbanner.CardBanner;
import com.xuezj.cardbanner.ImageData;
import com.xuezj.cardbanner.imageloader.CardImageLoader;

import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

import static android.content.Context.MODE_PRIVATE;

/**
 * 作者：Han98
 * 创建时间：2019/12/4
 * 描述：TODO
 * 最近修改：2019/12/4 19:44 modify by liujc
 */
public class HomeFragment extends BaseFragment implements Icontract.Iview,Home1Adapter.getYuYue {


    @BindView(R.id.banner)
    CardBanner cardBanner;
    @BindView(R.id.home_recy)
    RecyclerView homeRecy;
    @BindView(R.id.home1_recy)
    RecyclerView homeRecy1;
    @BindView(R.id.home_recy2)
    RecyclerView homeRecy2;
    @BindView(R.id.img1)
    SimpleDraweeView img1;
    @BindView(R.id.btn_sou)
    ImageView btn_sou;
    public Unbinder unbinder;
    ArrayList<ImageData> list = new ArrayList<>();
    @BindView(R.id.gengduo1)
    TextView gengduo1;
    @BindView(R.id.gengduo2)
    TextView gengduo2;
    @BindView(R.id.gengduo3)
    TextView gengduo3;

    private String session;
    private int userId;
    private Presenter presenter;

    YuYueEmnety yuYueEmnetys;
    @Override
    protected void initView(View view) {
        unbinder = ButterKnife.bind(this, view);

    }

    @Override
    protected void initData() {
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        manager.setOrientation(LinearLayoutManager.HORIZONTAL);
        homeRecy.setLayoutManager(manager);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        homeRecy1.setLayoutManager(layoutManager);

        LinearLayoutManager manager1 = new LinearLayoutManager(getContext());
        manager1.setOrientation(LinearLayoutManager.HORIZONTAL);
        homeRecy2.setLayoutManager(manager1);

        SharedPreferences sp = getActivity().getSharedPreferences("data",MODE_PRIVATE);
        session = sp.getString("session", null);

        userId = sp.getInt("userId", 0);

    }

    @Override
    protected int initLayout() {
        return R.layout.home_fragment;
    }

    @Override
    protected BasePresenter Ipresenter() {
        presenter = new Presenter();
        presenter.getBanner();
        presenter.getMovie1();
        presenter.getMovie2();
        presenter.getMovie3();
        return presenter;
    }


    @OnClick(R.id.btn_sou)
    public void setBtn_sou(View view) {
        Intent intent = new Intent(getActivity(), SelectActivity.class);
        startActivity(intent);
    }

    /**
     * banner数据
     *
     * @param bannerBean
     */
    @Override
    public void success(BannerBean bannerBean) {
        final List<BannerBean.ResultBean> result = bannerBean.getResult();
        for (int i = 0; i < result.size(); i++) {
            String imageUrl = result.get(i).getImageUrl();
            ImageData imageData = new ImageData();
            imageData.setImage(imageUrl);
            list.add(imageData);

        }
        cardBanner.setDatas(list).setCardImageLoader(new CardImageLoader() {
            @Override
            public void load(Context context, ImageView imageView, Object path) {
                Glide.with(context).load(path).into(imageView);
            }
        }).setPlay(true).start();


    }

    @Override
    public void movieSuccess1(MovieBean movieBean) {
        List<MovieBean.ResultBean> movieBeanResult = movieBean.getResult();
        HomeAdapter homeAdapter = new HomeAdapter(movieBeanResult, getContext());
        homeRecy.setAdapter(homeAdapter);

    }

    @Override
    public void zhengzai1(JiJiangBean zhengZaiBena) {
        List<JiJiangBean.ResultBean> result1 = zhengZaiBena.getResult();
        Home1Adapter home1Adapter = new Home1Adapter(getContext(), result1);
        home1Adapter.setYuYue(this);
        homeRecy1.setAdapter(home1Adapter);
    }

    @Override
    public void zhengzai2(ZhengZaiBena zhengZaiBena) {
        img1.setImageURI(zhengZaiBena.getResult().get(0).getImageUrl());
        List<ZhengZaiBena.ResultBean> result2 = zhengZaiBena.getResult();
        Home2Adapter home2Adapter = new Home2Adapter(getContext(), result2);
        homeRecy2.setAdapter(home2Adapter);


    }

    @Override
    public void yuyues(YuYueEmnety yuYueEmnety) {

        yuYueEmnetys = yuYueEmnety;

    }

    @OnClick(R.id.gengduo1)
    public void setGengduo1(View view){
        Intent intent = new Intent(getActivity(), MoreActivity.class);
        getActivity().startActivity(intent);
    }
    @OnClick(R.id.gengduo2)
    public void setGengduo2(View view){
        Intent intent = new Intent(getActivity(), MoreActivity.class);
        getActivity().startActivity(intent);
    }
    @OnClick(R.id.gengduo3)
    public void setGengduo3(View view){
        Intent intent = new Intent(getActivity(), MoreActivity.class);
        getActivity().startActivity(intent);
    }

    @Override
    public void success(int mid) {
        presenter.getYuyue(userId,session,mid);
        if (yuYueEmnetys!=null){
            Toast.makeText(getContext(), yuYueEmnetys.getMessage(), Toast.LENGTH_SHORT).show();
        }

    }
}
