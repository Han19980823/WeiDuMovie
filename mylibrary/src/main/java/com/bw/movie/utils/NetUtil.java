package com.bw.movie.utils;


import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/*
 *@auther:胡明明
 *@Date: 2019/11/5
 *@Time:19:46
 *@Description:${DESCRIPTION}
 **/
//网络判断
public class NetUtil {
    public static boolean hasNetWork(Context context){
       ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = manager.getActiveNetworkInfo();
        if (activeNetworkInfo!=null && activeNetworkInfo.isConnected()){
                return true;
        }else{
            return false;
        }
    }
}
