package com.bw.movie.utils;


/*
 *@auther:胡明明
 *@Date: 2019/11/5
 *@Time:20:47
 *@Description:${DESCRIPTION}
 **/

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public abstract class CommonObserver<T> implements Observer<T> {
    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onComplete() {

    }
}
