package com.bw.movie.view.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bw.movie.R;
import com.bw.movie.base.BaseActivity;
import com.bw.movie.base.BasePresenterActivity;
import com.bw.movie.bean.DetailsBean;
import com.bw.movie.bean.XiaDanBean;
import com.bw.movie.bean.YingTingBean;
import com.bw.movie.bean.ZhiFuBean;
import com.bw.movie.bean.ZuoWeiHaoBean;
import com.bw.movie.contract.Icontract;
import com.bw.movie.dapter.YingTingAdapter;
import com.bw.movie.dapter.ZuoWeiAdapter;
import com.bw.movie.presenter.Presenter2;
import com.facebook.drawee.view.SimpleDraweeView;
import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

public class GouPiaoActivity extends BaseActivity implements Icontract.Xiadan {


    @BindView(R.id.goupiao_fanhui)
    SimpleDraweeView goupiaoFanhui;
    @BindView(R.id.goupiao_name)
    TextView goupiaoName;
    @BindView(R.id.rela)
    RelativeLayout rela;
    @BindView(R.id.goupiao_jcvideo)
    JCVideoPlayerStandard goupiaoJcvideo;
    @BindView(R.id.img_jcv)
    SimpleDraweeView imgJcv;
    @BindView(R.id.goupiao_rlv)
    RecyclerView goupiaoRlv;
    @BindView(R.id.cb_cinemaseatkexuan)
    CheckBox cbCinemaseatkexuan;
    @BindView(R.id.cb_cinemaseatyishou)
    CheckBox cbCinemaseatyishou;
    @BindView(R.id.cb_cinemaseat_xuanzhong)
    CheckBox cbCinemaseatXuanzhong;
    @BindView(R.id.liner)
    LinearLayout liner;
    @BindView(R.id.tv_cinema)
    TextView tvCinema;
    @BindView(R.id.recycle_yingting)
    RecyclerView recycleYingting;
    @BindView(R.id.btn_xuanzuo)
    Button btnXuanzuo;
    @BindView(R.id.img)
    SimpleDraweeView img;
    @BindView(R.id.wechat)
    CheckBox wechat;
    @BindView(R.id.img1)
    SimpleDraweeView img1;
    @BindView(R.id.zfb)
    CheckBox zfb;
    @BindView(R.id.paybck)
    LinearLayout paybck;
    @BindView(R.id.btn_xiadan)
    Button btnXiadan;
    public int key;
    public int cinemaid;
    //  EventBus.getDefault().register(this);
    double money = 0;
    public double fare1;
    public int scheduleId;
    public String seats;

    public String orderId;
    int id = 1;
    private Presenter2 presenter2;
    private Unbinder bind;

    @Override
    protected BasePresenterActivity Ipresenter() {
        presenter2 = new Presenter2();
        return presenter2;
    }

    @Override
    protected void initData() {

        Intent intent = getIntent();
        key = intent.getIntExtra("key", 0);
        cinemaid = intent.getIntExtra("cinemaid", 0);
            presenter2.getXIngqing(key);
            presenter2.getYingT(key, cinemaid);
        //布局管理器
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recycleYingting.setLayoutManager(linearLayoutManager);


    }

    /**
     *  MD5加密
     * @param sourceStr
     * @return
     */
    public static String MD5(String sourceStr) {
        String result = "";
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(sourceStr.getBytes());
            byte b[] = md.digest();
            int i;
            StringBuffer buf = new StringBuffer("");
            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if (i < 0)
                    i += 256;
                if (i < 16)
                    buf.append("0");
                buf.append(Integer.toHexString(i));
            }
            result = buf.toString();
        } catch (NoSuchAlgorithmException e) {
            System.out.println(e);
        }
        return result;
    }

    @Override
    protected void initView() {
       unbinder =  ButterKnife.bind(this);
    }

    @Override
    protected int initLayout() {
        return R.layout.activity_gou_piao;
    }


    @OnClick(R.id.btn_xiadan)
    public void setBtnXiadan(View view){
        SharedPreferences sp = getSharedPreferences("data",MODE_PRIVATE);
        String session = sp.getString("session", null);
        Log.d("aa","aa"+session);
        int userId = sp.getInt("userId", 0);
        Log.d("aa","aa"+userId);
        String s1 = MD5(userId + "" + scheduleId + "movie");
        Log.e("s1", "onClick: "+s1 );
        presenter2.getXIdan(userId, session,scheduleId, seats, s1);
    }
    @Override
    public void success(XiaDanBean xiaDanBean) {

        //吐司下单成功
        if (xiaDanBean.getStatus().equals("0000")) {
            Toast.makeText(this, "" + xiaDanBean.getMessage(), Toast.LENGTH_SHORT).show();
            orderId = xiaDanBean.getOrderId();

            btnXiadan.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                  //  btnXiadan.setVisibility(View.INVISIBLE);
                    paybck.setVisibility(View.VISIBLE);
                   // payBtn.setVisibility(View.VISIBLE);
                    //   payBtn.setText("￥" + result.getPrice());
                    wechat.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            wechat.setChecked(true);
                            zfb.setChecked(false);
                            id = 1;
                            btnXiadan.setText("微信支付￥ " + money);
                        }
                    });
                    zfb.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            zfb.setChecked(true);
                            wechat.setChecked(false);
                            id = 2;
                            btnXiadan.setText("支付宝支付￥ " + money);
                        }
                    });
                    btnXiadan.setOnClickListener(new View.OnClickListener() {
                        SharedPreferences sp = getSharedPreferences("data",0);
                        String sessions = sp.getString("session", null);
                        int userIds = sp.getInt("userId", 0);
                        @Override
                        public void onClick(View v) {

                            presenter2.getzhifu( userIds,sessions,id, orderId);
                            Log.d("aa","aa"+userIds);
                            Log.d("aa","aa"+sessions);
                            Log.d("aa","aa"+id);
                            Log.d("aa","aa"+orderId);

                        }
                    });
                }
            });



        } else {
            Toast.makeText(this, xiaDanBean.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void zhifu(ZhiFuBean zhiFuBean) {
        Toast.makeText(this, zhiFuBean.getMessage(), Toast.LENGTH_SHORT).show();
        if (zhiFuBean.getStatus().equals("0000")) {
            PayReq payReq = new PayReq();
            payReq.appId = zhiFuBean.getAppId();
            payReq.nonceStr = zhiFuBean.getNonceStr();
            payReq.partnerId = zhiFuBean.getPartnerId();
            payReq.prepayId = zhiFuBean.getPrepayId();
            payReq.sign = zhiFuBean.getSign();
            payReq.timeStamp = zhiFuBean.getTimeStamp();
            payReq.packageValue = zhiFuBean.getPackageValue();
            payReq.extData = "app data";
            App.mWxApi.sendReq(payReq);

        }
    }

    @Override
    public void xianfgqing(DetailsBean detailsBean) {
        DetailsBean.ResultBean result = detailsBean.getResult();
        goupiaoName.setText(result.getName());
        goupiaoJcvideo.setUp(result.getShortFilmList().get(0).getVideoUrl(), JCVideoPlayer.SCREEN_LAYOUT_NORMAL,"" );
    }

    @Override
    public void yingting(YingTingBean yingTingBean) {
        if (yingTingBean.getStatus().equals("0000")) {
            List<YingTingBean.ResultBean> result = yingTingBean.getResult();
            YingTingAdapter yingTingAdapter = new YingTingAdapter(GouPiaoActivity.this,result);

            recycleYingting.setAdapter(yingTingAdapter);
            //布局管理器
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
            linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
            recycleYingting.setLayoutManager(linearLayoutManager);
            //接口回调
            yingTingAdapter.setOnItemClicks(new YingTingAdapter.onItemClicks() {
                @Override
                public void onChangeData(int p, double fare, int ytid) {
                    scheduleId = ytid;
                    presenter2.zuowei(p);
                    fare1 = fare;
                    money = 0;
                    btnXiadan.setVisibility(View.INVISIBLE);
                    //chooseSeat.setText("￥ "+money);
                    btnXuanzuo.setVisibility(View.VISIBLE);
                }
            });
        } else {
            Toast.makeText(this, yingTingBean.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void zuozuo(ZuoWeiHaoBean zuoWeiHaoBean) {
        if (zuoWeiHaoBean.getStatus().equals("0000")) {
            List<ZuoWeiHaoBean.ResultBean> result = zuoWeiHaoBean.getResult();
            int seat = Integer.parseInt(result.get(result.size() - 1).getSeat());
            ZuoWeiAdapter zuoWeiAdapter = new ZuoWeiAdapter(this, result);
            goupiaoRlv.setAdapter(zuoWeiAdapter);
            //布局管理器
            GridLayoutManager gridLayoutManager = new GridLayoutManager(this, seat);
            goupiaoRlv.setLayoutManager(gridLayoutManager);
            zuoWeiAdapter.setOnclickListener(new ZuoWeiAdapter.OnclickListener() {
                @Override
                public void onclick(String row, String seat, boolean ischecked) {
                    if (ischecked == true) {
                        Toast.makeText(GouPiaoActivity.this, row + "-" + seat, Toast.LENGTH_SHORT).show();
                        money = money + fare1;
                        btnXuanzuo.setVisibility(View.INVISIBLE);
                        btnXiadan.setVisibility(View.VISIBLE);
                        btnXiadan.setText("￥ " + money);
                        seats = row + "-" + seat;
                    } else {
                        money = money - fare1;
                        btnXuanzuo.setVisibility(View.INVISIBLE);
                        btnXiadan.setVisibility(View.VISIBLE);
                        btnXiadan.setText("￥ " + money);

                    }
                }
            });
        } else {
            Toast.makeText(this, zuoWeiHaoBean.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @OnClick(R.id.goupiao_fanhui)
    public void onViewClicked() {
        finish();

    }
}