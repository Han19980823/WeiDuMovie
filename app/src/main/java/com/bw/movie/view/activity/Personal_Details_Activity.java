package com.bw.movie.view.activity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.annotations.Nullable;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bigkoo.pickerview.TimePickerView;
import com.bumptech.glide.Glide;
import com.bw.movie.R;
import com.bw.movie.base.BaseActivity;
import com.bw.movie.base.BasePresenterActivity;
import com.bw.movie.bean.BirthBean;
import com.bw.movie.bean.TouXiangBean;
import com.bw.movie.bean.YongHuBean;
import com.bw.movie.contract.Icontract;
import com.bw.movie.presenter.Presenter2;
import com.bw.movie.utils.ImageUtil;
import com.facebook.drawee.view.SimpleDraweeView;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Personal_Details_Activity extends BaseActivity implements Icontract.IToux {

    @BindView(R.id.cinemadetail_fanhui)
    SimpleDraweeView cinemadetailFanhui;
    @BindView(R.id.denglu)
    ImageView ziliaoImg;
    @BindView(R.id.ziliao_name)
    TextView ziliaoName;
    @BindView(R.id.ziliao_sex)
    TextView ziliaoSex;
    @BindView(R.id.ziliao_email)
    TextView ziliaoEmail;
    @BindView(R.id.ziliao_riqi)
    TextView ziliaoRiqi;
    private SharedPreferences sp;
    private int userId;
    private String s;
    private static SimpleDateFormat format;
    private Presenter2 presenter;
    private MultipartBody.Part picture;

    @Override
    protected void initData() {

        sp = getSharedPreferences("data", Context.MODE_PRIVATE);
        userId = sp.getInt("userId", 0);
        s = sp.getString("session", null);
        presenter.getYonghu(userId, s);
        Log.e("aaa", "initData: "+userId );
        Log.e("aaa", "initData: "+s );
    }

    @Override
    protected void initView() {

    }

    @Override
    protected int initLayout() {
        return R.layout.activity_personal__details_;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @Override
    protected BasePresenterActivity Ipresenter() {
        presenter = new Presenter2();
        return presenter;
    }

    @OnClick({R.id.cinemadetail_fanhui, R.id.denglu})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.cinemadetail_fanhui:
                finish();
                break;
            case R.id.denglu:
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent, 1);
                break;
        }
    }


    //修改生日
    public static String getTime(Date date) {
        format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(date);
    }



    @Override
    public void Touxaing(TouXiangBean touXiangBean) {
        if (touXiangBean.getStatus().equals("0000")) {
            Toast.makeText(this, touXiangBean.getMessage(), Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, touXiangBean.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void yh(YongHuBean yongHuBean) {
        if (yongHuBean.getStatus().equals("0000")) {
            YongHuBean.ResultBean result = yongHuBean.getResult();

            ziliaoName.setText(result.getNickName());
            ziliaoEmail.setText(result.getEmail());
            int sex = result.getSex();
            if (sex == 1) {
                ziliaoSex.setText("男");
            } else {
                ziliaoSex.setText("女");
            }
        /*    Date date = new Date(result.getLastLoginTime());
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            ziliaoRiqi.setText(format.format(date));*/

            ziliaoRiqi.setText("2019-12-07");
            ziliaoRiqi.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    TimePickerView timePickerView = new TimePickerView(Personal_Details_Activity.this, TimePickerView.Type.YEAR_MONTH_DAY);
                    // 设置是否循环
                    timePickerView.setCyclic(true);
                    timePickerView.setTime(new Date());
                    timePickerView.setCyclic(false);
                    timePickerView.setCancelable(true);
                    //时间选择后回调
                    timePickerView.setOnTimeSelectListener(new TimePickerView.OnTimeSelectListener() {

                        @Override
                        public void onTimeSelect(Date date) {
                            //   edit.putString("birth",getTime(date)).commit();
                            ziliaoRiqi.setText(getTime(date));

                            String dateStr = new SimpleDateFormat("yyyy-MM-dd").format(date);
                            presenter.getData(userId,s,dateStr);
                        }
                    });
                    timePickerView.show();
                }
            });



        }

    }

    @Override
    public void bir(BirthBean birthBean) {
        Toast.makeText(this,birthBean.getMessage(),Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //判断是不是选中图片了
        if (requestCode == 1) {
            if (resultCode == Activity.RESULT_OK) {
                Uri uri = data.getData();
                if (uri != null) {
                    //用一个工具类获取图片的绝对路径,我会粘到下方
                    String path = ImageUtil.getPath(this, uri);
                    Glide.with(this).load(path)
                            .placeholder(R.mipmap.close)
                            .error(R.mipmap.feedback)
                            .into(ziliaoImg);
                    if (path != null) {
                        //转换为file类型
                        File file = new File(path);
                        //进行类型转换,因为在RetrofitService定义的是@Part MultipartBody.Part,所以要转成这样的格式
                        RequestBody requestBody = RequestBody.create(MediaType.parse("multipart/form-data"), file);
                        picture = MultipartBody.Part.createFormData("picture", file.getName(), requestBody);
                    }
                }
            } else {
                Toast.makeText(this, "取消相册", Toast.LENGTH_SHORT).show();
            }
        }
////        if (requestCode == 1& resultCode == RESULT_OK) {
////            Uri uri = data.getData();
////            if (uri != null) {
////                //用一个工具类获取图片的绝对路径,我会粘到下方
////                String path = ImageUtil.getPath(this, uri);
////                ziliaoImg.setImageURI(path);
////                if (path != null) {
////                    if (path != null) {
////                        //转换为file类型
////
////                        File file1 = new File(path);
////                        //进行类型转换,因为在RetrofitService定义的是@Part MultipartBody.Part,所以要转成这样的格式
////                        RequestBody requestBody1 = RequestBody.create(MediaType.parse("multipart/form-data"), file1);
////                        image1 = MultipartBody.Part.createFormData("image", file1.getName(), requestBody1);
////                        //调用P层
////                        presenter.getTou(userId, s, image1);
////
////
////                    }
////                }}
//        }
    }
}
