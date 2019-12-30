package com.bw.movie.view.activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.bw.movie.R;
import com.bw.movie.base.BaseActivity;
import com.bw.movie.base.BasePresenterActivity;
import com.bw.movie.bean.YuYueBean;
import com.bw.movie.contract.Icontract;
import com.bw.movie.dapter.YuYueAdapter;
import com.bw.movie.presenter.Presenter2;

import java.util.List;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class YuYueActivity extends BaseActivity implements Icontract.chaYuYue {


    @BindView(R.id.yuyue_recy)
    RecyclerView yuyueRecy;

    private Presenter2 presenter2;


    @Override
    protected BasePresenterActivity Ipresenter() {
        presenter2 = new Presenter2();

        return presenter2;
    }

    @Override
    protected void initData() {
        SharedPreferences sp = getSharedPreferences("data", Context.MODE_PRIVATE);
        String session = sp.getString("session", null);
        Log.d("yuyue","aa"+session);
        int userId = sp.getInt("userId", 0);
        Log.d("yuyue","aa"+userId);
        presenter2.getYuYue(userId,session);
    }

    @Override
    protected void initView() {

        ButterKnife.bind(this);
        LinearLayoutManager manager =  new LinearLayoutManager(this);
        yuyueRecy.setLayoutManager(manager);
    }

    @Override
    protected int initLayout() {
        return R.layout.activity_yu_yue;
    }

    @Override
    public void success(YuYueBean yuYueBean) {
        Toast.makeText(this, yuYueBean.getMessage(), Toast.LENGTH_SHORT).show();
       List<YuYueBean.ResultBean> result = yuYueBean.getResult();
        YuYueAdapter adapter = new YuYueAdapter(this, result);
        yuyueRecy.setAdapter(adapter);

    }

}
