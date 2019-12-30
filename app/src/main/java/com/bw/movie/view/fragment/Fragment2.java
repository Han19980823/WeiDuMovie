package com.bw.movie.view.fragment;

import android.content.SharedPreferences;
import android.view.View;
import android.widget.Toast;

import com.bw.movie.R;
import com.bw.movie.base.mvp.BaseFragment;
import com.bw.movie.base.mvp.BasePresenter;
import com.bw.movie.bean.JiJiangBean;
import com.bw.movie.bean.YuYueEmnety;
import com.bw.movie.contract.Icontract;
import com.bw.movie.dapter.Home1Adapter;
import com.bw.movie.presenter.Presenter;

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
public class Fragment2 extends BaseFragment implements Icontract.IFragm2,Home1Adapter.getYuYue {
    @BindView(R.id.recy_more1)
    RecyclerView recyMore1;
    private Presenter presenter;
    String session;
    int userId;
    YuYueEmnety yuYueEmnetys;
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
        return R.layout.fragment2;
    }

    @Override
    protected BasePresenter Ipresenter() {
        presenter = new Presenter();
        presenter.More2();
        return presenter;
    }
    @Override
    public void success(JiJiangBean jiJiangBean) {

        Home1Adapter home1Adapter = new Home1Adapter(getContext(),jiJiangBean.getResult());
        home1Adapter.setYuYue(this);
        recyMore1.setAdapter(home1Adapter);
    }

    @Override
    public void yuyues(YuYueEmnety yuYueEmnety) {
        yuYueEmnetys = yuYueEmnety;
    }

    @Override
    public void success(int mid) {
        presenter.getYuyue3(userId,session,mid);
        if (yuYueEmnetys!=null){
            Toast.makeText(getContext(), yuYueEmnetys.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}
