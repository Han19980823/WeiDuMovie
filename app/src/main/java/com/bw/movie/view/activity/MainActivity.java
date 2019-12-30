package com.bw.movie.view.activity;

import androidx.annotation.NonNull;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

import com.bw.movie.R;

import com.bw.movie.base.BaseActivity;
import com.bw.movie.base.BasePresenterActivity;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;

public class MainActivity extends BaseActivity {
        public Unbinder unbinder;
    @BindView(R.id.time)
    TextView time;
    int time1 = 3;

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {

            super.handleMessage(msg);
            time.setText(time1 + "");
            time1--;
            initThread();
            if (time1 == -1) {
                Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                startActivity(intent);
                MainActivity.this.finish();

            }
        }
    };

    @Override
    protected BasePresenterActivity Ipresenter() {
        return null;
    }

    @Override
    protected void initData() {
        unbinder = ButterKnife.bind(this);
        initThread();
    }

    private void initThread() {
        new Thread() {
            @Override
            public void run() {
                super.run();
                handler.sendEmptyMessageDelayed(1, 1000);
            }
        }.start();
    }

    @Override
    protected void initView() {

    }

    @Override
    protected int initLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeMessages(1);
    }
}
