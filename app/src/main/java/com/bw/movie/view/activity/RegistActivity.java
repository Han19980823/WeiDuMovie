package com.bw.movie.view.activity;

import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import androidx.annotation.NonNull;
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
import com.bw.movie.contract.Icontract;
import com.bw.movie.presenter.Presenter2;
import com.bw.movie.utils.EncryptUtil;

public class RegistActivity extends BaseActivity implements Icontract.Iview1  {


    @BindView(R.id.ed_name)
    EditText edName;

    @BindView(R.id.ed_pwd)
    EditText edPwd;
    @BindView(R.id.ed_code)
    EditText edCode;
    @BindView(R.id.btn_code)
    Button btnCode;
    @BindView(R.id.btn_login)
    Button btnLogin;
    private String email;
    int i = 30;
    Handler handler = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {
            btnCode.setText("获取验证码"+i);
            super.handleMessage(msg);
            i--;
            thr();
            if (i==-1){
                btnCode.setText("请重新获取验证码");
                finish();
            }

        }
    };
    private Presenter2 presenter2;
    private Unbinder unbinder;
    private EditText ed_emali;

    @Override
    protected BasePresenterActivity Ipresenter() {
        presenter2 = new Presenter2();
        return presenter2;
    }

    @Override
    protected void initData() {

    }

    /**
     * 子线程做耗时操作
     */

    private void thr() {
        new Thread(){

            @Override
            public void run() {
                super.run();
                handler.sendEmptyMessageDelayed(1,1000);
            }
        }.start();
    }

    @Override
    protected void initView() {
        unbinder =   ButterKnife.bind(this);
        ed_emali = findViewById(R.id.ed_email);
    }

    @OnClick(R.id.btn_login)
    public void setRegist(View view) {
        String name = edName.getText().toString();
        email = ed_emali.getText().toString();
        String pwd = edPwd.getText().toString();
        String code = edCode.getText().toString();
        String encrypt = EncryptUtil.encrypt(pwd);
        if (isEmail(email.trim()) && email.trim().length() <= 31) {
          if (email!=null){

          }
        } else {
              Toast.makeText(this, "邮箱不对", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * 邮箱正则校验
     *
     * @param email
     * @return
     */
    public boolean isEmail(String email) {
        if (null == email && "".endsWith(email)) return false;
        Pattern p = Pattern.compile("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*");//复杂匹配
        Matcher m = p.matcher(email);
        return m.matches();
    }

    @Override
    protected int initLayout() {
        return R.layout.activity_regist;
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeMessages(1);
    }



    @Override
    public void success(LoginBean loginBean) {

    }

    @Override
    public void code(CodeBean codeBean) {

    }

    @Override
    public void regist(RegistBean registBean) {

    }
}
