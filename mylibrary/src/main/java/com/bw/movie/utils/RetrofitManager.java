package com.bw.movie.utils;






import com.bw.movie.app.Constantes;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/*
 *@auther:胡明明
 *@Date: 2019/11/5
 *@Time:19:43
 *@Description:${DESCRIPTION}
 **/
//工具类
public class RetrofitManager {
    private Retrofit mRetrofit;
    //默认Api
//    private IApi mIApi;
    private static final String BASE_URL = Constantes.BASE_URL;



    private static final class SingleHolder{
        private static final RetrofitManager _INSTANCE = new RetrofitManager(BASE_URL);
    }

    public static RetrofitManager getInstance(){
        return SingleHolder._INSTANCE;
    }
    private OkHttpClient initOkHttp(){
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return new OkHttpClient().newBuilder()
                .addInterceptor(httpLoggingInterceptor)
                .connectTimeout(Constantes.TIME, TimeUnit.SECONDS)
                .readTimeout(Constantes.TIME, TimeUnit.SECONDS)
                .writeTimeout(Constantes.TIME, TimeUnit.SECONDS)
                .build();
    }


    private RetrofitManager(String url) {
        mRetrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(url)
                .client(initOkHttp())
                .build();
    }
/**
 * 如果有其他的IApi，通过这个有参的方法创建
 */
public <T> T create(Class<T> service){
    return mRetrofit.create(service);
}
    /**
     * 创建默认的单例IApi
     *//*
        public IApi create(){
            if (mIApi==null){
                mIApi = create(IApi.class);
            }
            return mIApi;
        }*/
}
