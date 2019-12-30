package com.bw.movie.dapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.bw.movie.R;
import com.facebook.drawee.view.SimpleDraweeView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.bw.movie.bean.PinglunBean;



/**
 * 作者：Han98
 * 创建时间：2019/12/11
 * 描述：TODO
 * 最近修改：2019/12/11 10:34 modify by liujc
 */
public class FilmAdapter extends RecyclerView.Adapter<FilmAdapter.Hodler> {
    List<PinglunBean.ResultBean> result;
    Context context;



    public FilmAdapter(List<PinglunBean.ResultBean> result, Context context) {
        this.result = result;
        this.context = context;
    }

    @NonNull
    @Override
    public Hodler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.films, parent, false);
        return new Hodler(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Hodler holder, int position) {
        holder.sim.setImageURI(result.get(position).getCommentHeadPic());
        holder.userName.setText(result.get(position).getCommentUserName());
        Long releaseTime = result.get(position).getCommentTime();
        //mill为你龙类型的时间戳
        Date date=new Date(releaseTime);
        String strs="";
        try {
            //yyyy表示年MM表示月dd表示日
            //yyyy-MM-dd是日期的格式，比如2015-12-12如果你要得到2015年12月12日就换成yyyy年MM月dd日
            SimpleDateFormat sdf=new SimpleDateFormat("MM月dd日");
            //进行格式化
            strs=sdf.format(date);
            holder.times.setText(strs);
        } catch (Exception e) {
            e.printStackTrace();
        }

        holder.namePinglun.setText(result.get(position).getCommentContent());
    }

    @Override
    public int getItemCount() {
        return result.size();
    }

    class Hodler extends RecyclerView.ViewHolder {
        @BindView(R.id.sim)
        SimpleDraweeView sim;
        @BindView(R.id.user_name)
        TextView userName;
        @BindView(R.id.times)
        TextView times;
        @BindView(R.id.name_pinglun)
        TextView namePinglun;
        public Hodler(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
