package com.bw.movie.dapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.bw.movie.R;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.bw.movie.bean.MovieBean;
import com.bw.movie.view.activity.DetailsActivity;


/**
 * 作者：Han98
 * 创建时间：2019/12/5
 * 描述：TODO
 * 最近修改：2019/12/5 20:28 modify by liujc
 */
public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.Holder> {
    List<MovieBean.ResultBean> movieBeanResult;
    Context context;



    public HomeAdapter(List<MovieBean.ResultBean> movieBeanResult, Context context) {
        this.movieBeanResult = movieBeanResult;
        this.context = context;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.zhengzai, parent, false);

        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.imgView.setImageURI(movieBeanResult.get(position).getImageUrl());
        holder.textName.setText(movieBeanResult.get(position).getName());
        holder.textView.setText(movieBeanResult.get(position).getScore() + "分");
        int movieId = movieBeanResult.get(position).getMovieId();
        holder.imgView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailsActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("movieid", movieId);
                intent.putExtras(bundle);
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
        @BindView(R.id.text_name)
        TextView textName;
        @BindView(R.id.text_fen)
        TextView textView;
        @BindView(R.id.btn_By)
        Button btnBy;
        public Holder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
