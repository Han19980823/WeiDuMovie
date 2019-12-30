package com.bw.movie.base.mvp;

import java.lang.ref.WeakReference;

/**
 * 作者：Han98
 * 创建时间：2019/12/4
 * 描述：TODO
 * 最近修改：2019/12/4 19:39 modify by liujc
 */
public class BasePresenter<V extends BaseFragment> {
    public V v;
    private WeakReference weakReference;

    /**
     * 绑定
     * @param v
     */
    public void attach(V v){
        this.v = v;
        weakReference= new WeakReference(v);
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
