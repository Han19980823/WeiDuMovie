package com.bw.movie.view.activity;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.sqlite.SQLiteDatabase;

import com.bw.movie.green.dao.DaoMaster;
import com.bw.movie.green.dao.DaoSession;
import com.facebook.cache.disk.DiskCacheConfig;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.opensdk.openapi.IWXAPI;

import com.bw.movie.utils.ImagePipelineConfigUtils;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

/**
 * 作者：Han98
 * 创建时间：2019/12/4
 * 描述：TODO
 * 最近修改：2019/12/4 20:41 modify by liujc
 */
public class App extends Application {
    public static Context context;
    public static IWXAPI mWxApi;
    private static DaoSession daoSession;


    @Override
    public void onCreate() {
        super.onCreate();
        context = this;

        registerToWX();
        //创建数据库
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(this, "login.db");
        //获取原生数据库
        SQLiteDatabase writableDatabase = devOpenHelper.getWritableDatabase();
        //对原生数据库进行二次封装
        DaoMaster daoMaster = new DaoMaster(writableDatabase);
        //返回session对象
        daoSession = daoMaster.newSession();

        //磁盘缓存的配置
        DiskCacheConfig diskCacheConfig = DiskCacheConfig.newBuilder(this)
                .setBaseDirectoryPath(getCacheDir())
                .setMaxCacheSize(8*1024*1024)
                .build();
        //把磁盘缓存的设置，设置到三级缓存中
        ImagePipelineConfig pipelineConfig = ImagePipelineConfig.newBuilder(this)
                .setMainDiskCacheConfig(diskCacheConfig)
                .build();
        Fresco.initialize(this,pipelineConfig);//pipelineConfig可不写

    }
    private void registerToWX() {
        //第二个参数是指你应用在微信开放平台上的AppID
        mWxApi = WXAPIFactory.createWXAPI(this, "wxb3852e6a6b7d9516", false);
        // 将该app注册到微信
        mWxApi.registerApp("wxb3852e6a6b7d9516");

    }
    public static DaoSession getDaoSession(){
        return daoSession;
    }
}
