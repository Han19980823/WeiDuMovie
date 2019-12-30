package com.bw.movie.base.mvp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 作者：Han98
 * 创建时间：2019/12/4
 * 描述：TODO
 * 最近修改：2019/12/4 19:38 modify by liujc
 */
public abstract class BaseFragment<P extends BasePresenter> extends Fragment {
    public Unbinder unbinder;
    public  P p;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        p =  Ipresenter();
        if (p!=null){
            p.attach(this);
        }

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(initLayout(), container, false);


        return inflate;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);

    }

    protected abstract void initView(View view);

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();

    }

    protected abstract void initData();

    protected abstract int initLayout();

    protected abstract P Ipresenter();

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (p!=null){
            p.unAttach();
            p = null;
        }
    }
}
