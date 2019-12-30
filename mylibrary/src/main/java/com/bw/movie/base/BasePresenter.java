package com.bw.movie.base;


/*
 *@auther:胡明明
 *@Date: 2019/11/5
 *@Time:20:09
 *@Description:${DESCRIPTION}
 **/

import android.content.Context;


import com.bw.movie.app.App;

import java.lang.ref.WeakReference;

public abstract class BasePresenter<V extends IBaseView> {

    private WeakReference<V> vWeakReference;

    public BasePresenter(){
        //初始化model
        initModel();
    }
    //初始化model
    protected abstract void initModel();

    //绑定View
    protected void attachView(V v){
        vWeakReference = new WeakReference<>(v);
    }

    //解绑
    protected void detachView(){
        if (vWeakReference!=null){
            vWeakReference.clear();
            vWeakReference=null;
        }
    }
    //p判断是否挂载
    /**
     * 判断view是否挂载
     * 防止出现 presenter 层 view 调用空指针
     * 每次调用业务请求的时候都要先调用方法检查是否与 View 绑定
     * 只有返回ture才进行回调
     */
    protected boolean isViewAttached(){
        if (vWeakReference==null || vWeakReference.get()==null){
            return false;
        }
        return true;
    }
    /**
     * 获取view接口
     * 每只有 isViewAttached 返回ture的时候，才能调用他
     */
    public V getView(){
        return vWeakReference.get();
    }
    //context为上下文
    //上下文为null，则返回应用上下文
    protected Context context(){
        if (isViewAttached() && getView().context()!=null){
            return getView().context();
        }
        return App.getsAppContext();
    }

}
