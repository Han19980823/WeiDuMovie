package com.bw.movie.view.fragment;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.util.Log;
import android.view.View;
import android.widget.Toast;


import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.bw.movie.R;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.bw.movie.base.mvp.BaseFragment;
import com.bw.movie.base.mvp.BasePresenter;
import com.bw.movie.bean.NearByMovieBean;
import com.bw.movie.contract.Icontract;
import com.bw.movie.dapter.NearByMovie_Adapter;
import com.bw.movie.presenter.Presenter;
import com.bw.movie.view.activity.CinemaInfoActivity;


public class NearbyMovie_Fragment extends BaseFragment implements Icontract.INear {
    @BindView(R.id.nearbymovie_recycler)
    XRecyclerView nearbymovieRecycler;

    private int page = 1;
    private List<NearByMovieBean.ResultBean> list;
    private NearByMovie_Adapter nearByMovie_adapter;
    private AMapLocationClient mlocationClient;
    private AMapLocationClientOption mLocationOption;
    private double longitude;
    private double latitude;
    private Presenter presenter;

    @Override
    public int initLayout() {
        return R.layout.nearbymovie_fragment;
    }

    @Override
    protected BasePresenter Ipresenter() {
        presenter = new Presenter();

        return presenter;
    }
    @Override
    protected void initView(View view) {
        ButterKnife.bind(this,view);
        list = new ArrayList<>();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        nearbymovieRecycler.setLayoutManager(linearLayoutManager);
        nearByMovie_adapter = new NearByMovie_Adapter(getActivity(),list);
        nearbymovieRecycler.setAdapter(nearByMovie_adapter);
    }

    @Override
    public void initData() {
        nearbymovieRecycler.setLoadingMoreEnabled(true);
        nearbymovieRecycler.setPullRefreshEnabled(true);
        nearbymovieRecycler.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                list.clear();
                page = 1;
                requestData(page);
                nearbymovieRecycler.refreshComplete();
                nearByMovie_adapter.notifyDataSetChanged();
            }

            @Override
            public void onLoadMore() {
                page++;
                requestData(page);
                nearbymovieRecycler.refreshComplete();
                nearByMovie_adapter.notifyDataSetChanged();
            }
        });
    }



    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser){
            requestData(page);
            if(ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION)
                    != PackageManager.PERMISSION_GRANTED){//未开启定位权限
                //开启定位权限,200是标识码
                ActivityCompat.requestPermissions(getActivity(),new String[]{Manifest.permission.ACCESS_FINE_LOCATION},200);

            }else{
                MyLocation(getActivity());//开始定位
                Toast.makeText(getActivity(),"已开启定位权限",Toast.LENGTH_LONG).show();
            }
        }
    }



    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode){
            case 200://刚才的识别码
                if(grantResults[0] == PackageManager.PERMISSION_GRANTED){//用户同意权限,执行我们的操作
                    MyLocation(getActivity());//开始定位

                }else{//用户拒绝之后,当然我们也可以弹出一个窗口,直接跳转到系统设置页面
                    Toast.makeText(getActivity(),"未开启定位权限,请手动到设置去开启权限",Toast.LENGTH_LONG).show();
                }
                break;
            default:break;
        }
    }


    private void requestData(int pagea){
        Map<String,Object> map = new HashMap<>();
        map.put("count",5);
        map.put("page",pagea);
        map.put("longitude",longitude);
        map.put("latitude",latitude);
       presenter.home_Coming_Show(map);
    }


    public void MyLocation(Context context) {
        mlocationClient = new AMapLocationClient(context);
        mLocationOption = new AMapLocationClientOption();
        mlocationClient.setLocationListener(new AMapLocationListener() {



            @Override
            public void onLocationChanged(AMapLocation amapLocation) {
                try {
                    if (amapLocation != null) {
                        if (amapLocation.getErrorCode() == 0) {
                            //定位成功回调信息，设置相关消息
                            //获取当前定位结果来源，如网络定位结果，详见定位类型表
                            Log.i("定位类型", amapLocation.getLocationType() + "");
                            Log.i("获取纬度", amapLocation.getLatitude() + "");
                            Log.i("获取经度", amapLocation.getLongitude() + "");
                            Log.i("获取精度信息", amapLocation.getAccuracy() + "");
                            //如果option中设置isNeedAddress为false，则没有此结果，网络定位结果中会有地址信息，GPS定位不返回地址信息。
                            Log.i("地址", amapLocation.getAddress());
                            Log.i("国家信息", amapLocation.getCountry());
                            Log.i("省信息", amapLocation.getProvince());
                            Log.i("城市信息", amapLocation.getCity());
                            Log.i("城区信息", amapLocation.getDistrict());
                            Log.i("街道信息", amapLocation.getStreet());
                            Log.i("街道门牌号信息", amapLocation.getStreetNum());
                            Log.i("城市编码", amapLocation.getCityCode());
                            Log.i("地区编码", amapLocation.getAdCode());
                            Log.i("获取当前定位点的AOI信息", amapLocation.getAoiName());
                            Log.i("获取当前室内定位的建筑物Id", amapLocation.getBuildingId());
                            Log.i("获取当前室内定位的楼层", amapLocation.getFloor());
                            Log.i("获取GPS的当前状态", amapLocation.getGpsAccuracyStatus() + "");
                            //获取定位时间
                            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                            Date date = new Date(amapLocation.getTime());
                            Log.i("获取定位时间", df.format(date));
                            //维度
                            latitude = amapLocation.getLatitude();
                            //精度
                            longitude = amapLocation.getLongitude();



                            // 停止定位
                            mlocationClient.stopLocation();
                        } else {
                            //定位失败时，可通过ErrCode（错误码）信息来确定失败的原因，errInfo是错误信息，详见错误码表。
                            Log.e("AmapError", "location Error, ErrCode:"
                                    + amapLocation.getErrorCode() + ", errInfo:"
                                    + amapLocation.getErrorInfo());
                        }
                    }
                } catch (Exception e) {
                }

            }
        });
        //设置定位模式为高精度模式，Battery_Saving为低功耗模式，Device_Sensors是仅设备模式
        mLocationOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
        mLocationOption.setInterval(5000);
        //设置定位参数
        mlocationClient.setLocationOption(mLocationOption);
        //启动定位
        mlocationClient.startLocation();

    }

    @Override
    public void onStop() {
        super.onStop();
        // 停止定位
        if (null != mlocationClient) {
            mlocationClient.stopLocation();
        }

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (null != mlocationClient) {
            /**
             * 如果AMapLocationClient是在当前Activity实例化的，
             * 在Activity的onDestroy中一定要执行AMapLocationClient的onDestroy
             */
            mlocationClient.onDestroy();
            mlocationClient = null;
        }
    }



    @Override
    public void successe(NearByMovieBean nearByMovieBean) {
        if (page == 1){
            list.clear();
        }

        List<NearByMovieBean.ResultBean> result = nearByMovieBean.getResult();
        list.addAll(result);
        nearByMovie_adapter.notifyDataSetChanged();
        nearByMovie_adapter.setItemClick(new NearByMovie_Adapter.setClick() {
            @Override
            public void setOnClick(int position) {
                Intent it = new Intent(getActivity(), CinemaInfoActivity.class);
                it.putExtra("cinemaId",list.get(position).getId());
                startActivity(it);
            }
        });
    }
}
