package com.bw.movie.base;


/*
 *@auther:胡明明
 *@Date: 2019/11/5
 *@Time:20:09
 *@Description:${DESCRIPTION}
 **/

import android.content.Context;

public interface IBaseView {
    //为presenter层提供上下文   ps： 非必须
    Context context();
}
