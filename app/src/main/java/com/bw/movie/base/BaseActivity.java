package com.bw.movie.base;

import android.os.Build;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import butterknife.Unbinder;

/**
 * 作者：Han98
 * 创建时间：2019/12/4
 * 描述：TODO
 * 最近修改：2019/12/4 19:19 modify by liujc
 */
public abstract class BaseActivity<P extends BasePresenterActivity> extends AppCompatActivity {
    public Unbinder unbinder;
    public  P p;
    private boolean isstatus = false;
    private boolean isFullScreen = false;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(initLayout());
        p =  Ipresenter();
        if (p!=null){
            p.attach(this);
        }
        initView();
        initData();
        Steep();
    }


    public void  Steep(){

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window window = getWindow();
            window.setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
    }

    //沉浸式
    public void setIsstatus(boolean isstatus){

        this.isstatus=isstatus;
        if (isstatus){
            if (Build.VERSION.SDK_INT>Build.VERSION_CODES.KITKAT){
                getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            }
        }
    }

    //设置是否隐藏状态栏,显示全屏
    public void setFullScreen(boolean fullScreen){
        this.isFullScreen=isstatus;
        if(isFullScreen){
            //是全屏的时候
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
    }


    protected abstract P Ipresenter();

    protected abstract void initData();

    protected abstract void initView();

    protected abstract int initLayout();

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }
}
