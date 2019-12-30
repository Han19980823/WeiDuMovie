package com.bw.movie.view.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

import com.bw.movie.R;
import com.bw.movie.base.BaseActivity;
import com.bw.movie.base.BasePresenterActivity;
import com.bw.movie.bean.CodeBean;
import com.bw.movie.bean.LoginBean;
import com.bw.movie.bean.RegistBean;
import com.bw.movie.bean.WeChatBean;
import com.bw.movie.contract.Icontract;
import com.bw.movie.green.bean.LoginDaoBean;
import com.bw.movie.green.bean.WechatLoginBean;
import com.bw.movie.green.dao.DaoSession;
import com.bw.movie.green.dao.LoginDaoBeanDao;
import com.bw.movie.green.dao.WechatLoginBeanDao;
import com.bw.movie.presenter.Presenter2;
import com.bw.movie.utils.EncryptUtil;
import com.bw.movie.utils.StatusBarUtils;
import com.tencent.mm.opensdk.modelmsg.SendAuth;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;


public class LoginActivity extends BaseActivity implements Icontract.Iview1, Icontract.IWeChat {

    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.emils)
    EditText emils;
    @BindView(R.id.pwd)
    EditText pwd;
    @BindView(R.id.forget)
    TextView forget;
    @BindView(R.id.register)
    TextView register;
    @BindView(R.id.login)
    Button login;
    @BindView(R.id.wechat)
    ImageButton wechat;

    private LoginDaoBeanDao loginDaoBeanDao;
    private WechatLoginBeanDao wechatLoginBeanDao;
    private DaoSession daoSession;
    private Presenter2 presenter2;
    private Unbinder unbinder;

    @Override
    public int initLayout() {
        return R.layout.activity_regsit_sctivity;
    }


    @Override
    protected BasePresenterActivity Ipresenter() {
        presenter2 = new Presenter2();
        return presenter2;
    }

    @Override
    public void initData() {
        daoSession = App.getDaoSession();
        loginDaoBeanDao = daoSession.getLoginDaoBeanDao();
        StatusBarUtils.immersionAll(this);
        EventBus.getDefault().register(this);
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);

    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void getCode(String code) {
        Log.i("TAG", code);
        presenter2.getWeChat(code);
    }


    @OnClick({R.id.back, R.id.forget, R.id.register, R.id.login, R.id.wechat})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                Intent it1 = new Intent(LoginActivity.this, HomeActivity.class);
                startActivity(it1);
                finish();
                break;
            case R.id.forget:
                break;
            case R.id.register:
                Intent it = new Intent(LoginActivity.this, RegistActivity.class);
                startActivity(it);
                finish();
                break;
            case R.id.login:
                String emils1 = emils.getText().toString().trim();
                String pwd1 = pwd.getText().toString().trim();
                if (TextUtils.isEmpty(emils1) && TextUtils.isEmpty(pwd1)) {
                    Toast.makeText(this, "输入框为空", Toast.LENGTH_SHORT).show();
                } else {
                    String encrypt = EncryptUtil.encrypt(pwd1);
                    presenter2.getLogin(emils1, encrypt);
                }
                break;
            case R.id.wechat:
                if (!App.mWxApi.isWXAppInstalled()) {
                    Toast.makeText(this, "您还未安装微信客户端", Toast.LENGTH_SHORT).show();
                    return;
                }
                // 发送授权登录信息，来获取code
                final SendAuth.Req req = new SendAuth.Req();
                // 应用的作用域，获取个人信息
                req.scope = "snsapi_userinfo";
                req.state = "app_wechat";
                App.mWxApi.sendReq(req);

                break;
        }
    }


    @Override
    public void success(LoginBean loginBean) {
        Toast.makeText(this, loginBean.getMessage(), Toast.LENGTH_SHORT).show();
        if (loginBean.getStatus().equals("0000")) {
            LoginBean.ResultBean.UserInfoBean userInfo = loginBean.getResult().getUserInfo();
            String email = userInfo.getEmail();
            String headPic = userInfo.getHeadPic();
            int id = userInfo.getId();
            long lastLoginTime = userInfo.getLastLoginTime();
            String nickName = userInfo.getNickName();

            int sex = userInfo.getSex();
            String sid = loginBean.getResult().getSessionId();

            int  uid = loginBean.getResult().getUserId();
            Log.e("aaa", "success: "+uid );
            List<LoginDaoBean> loginDaoBeans = loginDaoBeanDao.queryRaw("where email = ?", email);
            if (loginDaoBeans.size() == 0) {
                LoginDaoBean loginDao = new LoginDaoBean(null, email, headPic, id, lastLoginTime, nickName, sex);
                loginDaoBeanDao.insert(loginDao);
            } else {
                LoginDaoBean loginDaoBean = loginDaoBeans.get(0);
                Long mId = loginDaoBean.getMId();
                LoginDaoBean loginDao1 = new LoginDaoBean(mId, email, headPic, id, lastLoginTime, nickName, sex);
                loginDaoBeanDao.update(loginDao1);
            }
            Intent it = new Intent(this, HomeActivity.class);
            startActivity(it);
            finish();
        }
    }

    @Override
    public void code(CodeBean codeBean) {

    }

    @Override
    public void regist(RegistBean registBean) {

    }

    @Override
    public void success(WeChatBean weChatBean) {

        WeChatBean.ResultBean result = weChatBean.getResult();
        String sessionId = result.getSessionId();
        int userId = result.getUserId();
        SharedPreferences sp = getSharedPreferences("data",MODE_PRIVATE);
        SharedPreferences.Editor edit = sp.edit();
        edit.putString("session",sessionId);
        Log.e("sss", "success: "+sessionId );
        edit.putInt("userId",userId);
        Log.e("sss", "success: "+userId );
        edit.commit();

        WeChatBean.ResultBean.UserInfoBean userInfo = weChatBean.getResult().getUserInfo();
        Toast.makeText(this, weChatBean.getMessage(), Toast.LENGTH_SHORT).show();
        if (weChatBean.getStatus().equals("0000")) {
            String birthday = userInfo.getBirthday();
            String headPic = userInfo.getHeadPic();
            String lastLoginTime = userInfo.getLastLoginTime();
            String nickName = userInfo.getNickName();
            String phone = userInfo.getPhone();
            String sex = userInfo.getSex();

            wechatLoginBeanDao = daoSession.getWechatLoginBeanDao();

            List<WechatLoginBean> wechatLoginBeans = wechatLoginBeanDao.loadAll();
            if (wechatLoginBeans.size() == 0) {
                WechatLoginBean wechatLoginBean = new WechatLoginBean(null, nickName, phone, birthday, sex, lastLoginTime, headPic);
                wechatLoginBeanDao.insert(wechatLoginBean);
            } else {
                WechatLoginBean wechatLoginBean2 = wechatLoginBeans.get(0);
                Long id = wechatLoginBean2.getId();
                WechatLoginBean wechatLoginBean1 = new WechatLoginBean(id, nickName, phone, birthday, sex, lastLoginTime, headPic);
                wechatLoginBeanDao.update(wechatLoginBean1);
            }
            Intent it = new Intent(this, HomeActivity.class);
            startActivity(it);
            finish();
        }
        //    Toast.makeText(this, result.getSessionId(), Toast.LENGTH_SHORT).show();
    }
}
