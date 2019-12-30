package com.bw.movie.dapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bw.movie.R;
import com.bw.movie.bean.JiJiangBean;
import com.bw.movie.bean.MovieBean;
import com.bw.movie.view.activity.ChooseActivity;
import com.bw.movie.view.activity.DetailsActivity;
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
 * 创建时间：2019/12/6
 * 描述：TODO
 * 最近修改：2019/12/6 14:16 modify by liujc
 */
public class Home1Adapters extends RecyclerView.Adapter<Home1Adapters.Holder> {
    Context context;
    List<MovieBean.ResultBean> movieBeanResult;

    public Home1Adapters(Context context, List<MovieBean.ResultBean> movieBeanResult ) {
        this.context = context;
        this.movieBeanResult = movieBeanResult;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.getmoview, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
       holder.imgView.setImageURI(movieBeanResult.get(position).getImageUrl());
        holder.text1.setText(movieBeanResult.get(position).getName());
        holder.text2.setText(movieBeanResult.get(position).getStarring());
        holder.text3.setText(movieBeanResult.get(position).getDirector());
        int movieId = movieBeanResult.get(position).getMovieId();
        holder.imgView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ChooseActivity.class);
                intent.putExtra("movieeId",movieId);
                context.startActivity(intent);

            }
        });


    }

    @Override
    public int getItemCount() {
        return movieBeanResult.size();
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
