package com.bw.movie.view.fragment;

import android.content.SharedPreferences;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.bw.movie.R;
import com.bw.movie.base.mvp.BaseFragment;
import com.bw.movie.base.mvp.BasePresenter;
import com.bw.movie.bean.MovieBean;
import com.bw.movie.bean.YuYueEmnety;
import com.bw.movie.bean.ZhengZaiBena;
import com.bw.movie.contract.Icontract;
import com.bw.movie.dapter.Fragment1Adapter;
import com.bw.movie.dapter.HomeAdapter;
import com.bw.movie.presenter.Presenter;

import java.util.List;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

import static android.content.Context.MODE_PRIVATE;

/**
 * 作者：Han98
 * 创建时间：2019/12/26
 * 描述：TODO
 * 最近修改：2019/12/26 15:22 modify by liujc
 */
public class Fragment1 extends BaseFragment implements Icontract.IFragm1,Fragment1Adapter.setYuyue {
    @BindView(R.id.recy_more1)
    RecyclerView recyMore1;
    YuYueEmnety yuYueEmnetys;
    private Presenter presenter;
    String session;
    int userId;

    @Override
    protected void initView(View view) {
        ButterKnife.bind(this,view);

    }

    @Override
    protected void initData() {
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        recyMore1.setLayoutManager(manager);
        SharedPreferences sp = getActivity().getSharedPreferences("data",MODE_PRIVATE);
        session = sp.getString("session", null);

        userId = sp.getInt("userId", 0);
    }

    @Override
    protected int initLayout() {
        return R.layout.fragment1;
    }

    @Override
    protected BasePresenter Ipresenter() {
        presenter = new Presenter();
        presenter.More1();
        return presenter;
    }

    @Override
    public void success(MovieBean zhengZaiBena) {

        List<MovieBean.ResultBean> result = zhengZaiBena.getResult();
        Fragment1Adapter fragment1Adapter = new Fragment1Adapter(result,getContext());
        fragment1Adapter.setSetYuyue(this);
        recyMore1.setAdapter(fragment1Adapter);
    }

    @Override
    public void yuyues(YuYueEmnety yuYueEmnety) {
        yuYueEmnetys = yuYueEmnety;
    }

    @Override
    public void success(int id) {
        presenter.getYuyue2(userId,session,id);
        if (yuYueEmnetys!=null){
            Toast.makeText(getContext(), yuYueEmnetys.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}
