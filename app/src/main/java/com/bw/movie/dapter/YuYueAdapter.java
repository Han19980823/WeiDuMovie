package com.bw.movie.dapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bw.movie.R;
import com.bw.movie.bean.YuYueBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 作者：Han98
 * 创建时间：2019/12/26
 * 描述：TODO
 * 最近修改：2019/12/26 20:08 modify by liujc
 */
public class YuYueAdapter extends RecyclerView.Adapter<YuYueAdapter.Holder> {
    Context context;
    List<YuYueBean.ResultBean> result;

    public YuYueAdapter(Context context,   List<YuYueBean.ResultBean> result ) {
        this.context = context;
        this.result = result;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.yuyue, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.imgView.setImageURI(result.get(position).getImageUrl());
        holder.text1.setText(result.get(position).getName());
        holder.text2.setText(result.get(position).getWantSeeNum()+"人想看");
        Long releaseTime = result.get(position).getReleaseTime();
        //mill为你龙类型的时间戳
        Date date = new Date(releaseTime);
        String strs = "";
        try {
            //yyyy表示年MM表示月dd表示日
            //yyyy-MM-dd是日期的格式，比如2015-12-12如果你要得到2015年12月12日就换成yyyy年MM月dd日
            SimpleDateFormat sdf = new SimpleDateFormat("MM月dd日");
            //进行格式化
            strs = sdf.format(date);
            holder.text3.setText(strs + "上映");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return result.size();
    }

    class Holder extends RecyclerView.ViewHolder {
        @BindView(R.id.img_view)
        SimpleDraweeView imgView;
        @BindView(R.id.text1)
        TextView text1;
        @BindView(R.id.text2)
        TextView text2;
        @BindView(R.id.text3)
        TextView text3;
        public Holder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
