package com.bw.movie.base;

import java.lang.ref.WeakReference;

/**
 * 作者：Han98
 * 创建时间：2019/12/7
 * 描述：TODO
 * 最近修改：2019/12/7 13:13 modify by liujc
 */
public class BasePresenterActivity<V extends BaseActivity> {
    public V v;
    private WeakReference weakReference;

    /**
     * 绑定
     * @param v
     */
    public void attach(V v){
        this.v = v;
    }

    /**
     * 解绑
     */
    public void unAttach(){
        if (v!=null){
            v =null;
            weakReference.clear();
        }
    }

}
