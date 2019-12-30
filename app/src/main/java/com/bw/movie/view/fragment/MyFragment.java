package com.bw.movie.view.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bw.movie.R;
import com.bw.movie.base.mvp.BaseFragment;
import com.bw.movie.base.mvp.BasePresenter;
import com.bw.movie.green.bean.LoginDaoBean;
import com.bw.movie.green.bean.WechatLoginBean;
import com.bw.movie.green.dao.LoginDaoBeanDao;
import com.bw.movie.green.dao.WechatLoginBeanDao;
import com.bw.movie.view.activity.App;
import com.bw.movie.view.activity.LoginActivity;
import com.bw.movie.view.activity.Personal_Details_Activity;
import com.bw.movie.view.activity.YuYueActivity;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * 作者：Han98
 * 创建时间：2019/12/4
 * 描述：TODO
 * 最近修改：2019/12/4 19:44 modify by liujc
 */
public class MyFragment extends BaseFragment {


    @BindView(R.id.lin_id)
    LinearLayout textView;
    @BindView(R.id.headPic)
    ImageView headPic2;
    @BindView(R.id.picName)
    TextView picName;
    @BindView(R.id.e1)
    ImageView e1;
    @BindView(R.id.tz)
    ImageView tz;
    @BindView(R.id.beginning)
    LinearLayout beginning;
    @BindView(R.id.wodeyuyue)
    LinearLayout wodeyuyue;
    private LoginDaoBeanDao loginDaoBeanDao;
    private WechatLoginBeanDao wechatLoginBeanDao;

    @Override
    protected void initView(View view) {
        ButterKnife.bind(this, view);

        EventBus.getDefault().register(this);
        loginDaoBeanDao = App.getDaoSession().getLoginDaoBeanDao();
        wechatLoginBeanDao = App.getDaoSession().getWechatLoginBeanDao();
    }

    @Override
    protected void initData() {
        List<LoginDaoBean> loginDaoBeans = loginDaoBeanDao.loadAll();

        List<WechatLoginBean> wechatLoginBeans = wechatLoginBeanDao.loadAll();
        Log.i("aaa", wechatLoginBeans.size() + "");

        if (loginDaoBeans != null && loginDaoBeans.size() > 0) {
            String headPics = loginDaoBeans.get(0).getHeadPic();
            //   Glide.with(getActivity()).load(headPics).apply(RequestOptions.circleCropTransform())
            // .into(headPic2);
            String nickName = loginDaoBeans.get(0).getNickName();
            picName.setText(nickName);
        } else {
            String headPics = wechatLoginBeans.get(0).getHeadPic();
            //   Glide.with(getActivity()).load(headPics).apply(RequestOptions.circleCropTransform())
            //     .into(headPic2);
            String nickName = wechatLoginBeans.get(0).getNickName();
            picName.setText(nickName);
        }
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
            }
        });

    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void getBitMap(Bitmap bitmap) {
        //  Glide.with(getActivity()).load(bitmap).apply(RequestOptions.circleCropTransform())
        ///5j   .into(headPic2);
    }

    @OnClick(R.id.tz)
    public void setTextView(View view) {
        Intent intent = new Intent(getActivity(), Personal_Details_Activity.class);
        startActivity(intent);

    }

    @OnClick(R.id.wodeyuyue)
    public void setWodeyuyue(View view){
        Intent intent = new Intent(getActivity(), YuYueActivity.class);
        getActivity().startActivity(intent);
    }

    @Override
    protected int initLayout() {
        return R.layout.my_fragment;
    }

    @Override
    protected BasePresenter Ipresenter() {
        return null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
