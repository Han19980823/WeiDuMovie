package com.bw.movie.view.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.bw.movie.R;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

import com.bw.movie.base.mvp.BaseFragment;
import com.bw.movie.base.mvp.BasePresenter;
import com.bw.movie.bean.DetailsBean;
import com.bw.movie.contract.Icontract;
import com.bw.movie.dapter.ActorAdapter;
import com.bw.movie.presenter.Presenter;

/**
 * 作者：Han98
 * 创建时间：2019/12/10
 * 描述：TODO
 * 最近修改：2019/12/10 16:42 modify by liujc
 */
public class IntroduceFragment extends BaseFragment implements Icontract.IDetail
{
    @BindView(R.id.text_jieshao)
    TextView textJieshao;
    @BindView(R.id.img_view1)
    SimpleDraweeView imgView1;
    @BindView(R.id.text_name1)
    TextView textName1;
    @BindView(R.id.recy_mingxing)
    RecyclerView recyMingxing;
    public Unbinder unbinder;
    private Presenter presenter;


    @Override
    protected void initView(View view) {
        unbinder = ButterKnife.bind(this,view);

    }

    @Override
    protected void initData() {
        Intent intent = getActivity().getIntent();
        Bundle extras = intent.getExtras();
        int movieid = extras.getInt("movieid");
        presenter.getDetalis(movieid);
        LinearLayoutManager  manager = new LinearLayoutManager(getContext());
        manager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyMingxing.setLayoutManager(manager);
    }

    @Override
    protected int initLayout() {
        return R.layout.introduce;
    }

    @Override
    protected BasePresenter Ipresenter() {
        presenter = new Presenter();

        return presenter;
    }

    @Override
    public void deTails(DetailsBean detailsBean) {
        DetailsBean.ResultBean result = detailsBean.getResult();
        String summary = result.getSummary();
        textJieshao.setText(summary);
        List<DetailsBean.ResultBean.MovieDirectorBean> movieDirector = result.getMovieDirector();
        imgView1.setImageURI(movieDirector.get(0).getPhoto());
        textName1.setText(movieDirector.get(0).getName());
         List<DetailsBean.ResultBean.MovieActorBean> movieActor = result.getMovieActor();
        ActorAdapter actorAdapter = new ActorAdapter(movieActor,getContext());
        recyMingxing.setAdapter(actorAdapter);

    }
}
