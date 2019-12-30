package com.bw.movie.base;

/*
 *@auther:胡明明
 *@Date: 2019/11/5
 *@Time:19:41
 *@Description:${DESCRIPTION}
 **/

import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bw.movie.R;
import com.bw.movie.utils.NetUtil;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity implements IBaseView {

    protected P mPresenter;
    private Unbinder bind;
    private int nonet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        boolean network = hasNetWork();
        if (!network){
            nonet = R.layout.layout_wuwangluo;
            setContentView(nonet);
        }else {
            nonet = provideLayoutId();
            setContentView(nonet);
            bind = ButterKnife.bind(this);
            mPresenter = providePresenter();
            if (mPresenter!=null){
                mPresenter.attachView(this);
            }
            initView();
            initData();
        }

    }
        protected abstract P providePresenter();

    protected void initData(){

    }
    protected void initView(){

    }
    protected abstract int provideLayoutId();

    //判断是否有网
    public boolean hasNetWork(){
        return NetUtil.hasNetWork(this);
    }
    //无网提示
    public void showNoNetTip(){
        Toast.makeText(BaseActivity.this, "无网，请检查网络", Toast.LENGTH_SHORT).show();
    }

    //上下文
    @Override
    public Context context() {
        return this;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        bind.unbind();
        if (mPresenter!=null){
            mPresenter.detachView();
        }
    }
}
