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
import com.bw.movie.bean.ZhengZaiBena;
import com.bw.movie.view.activity.DetailsActivity;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * 作者：Han98
 * 创建时间：2019/12/5
 * 描述：TODO
 * 最近修改：2019/12/5 20:28 modify by liujc
 */
public class Fragment3Adapter extends RecyclerView.Adapter<Fragment3Adapter.Holder> {
    List<ZhengZaiBena.ResultBean> result;
    Context context;


    public Fragment3Adapter(List<ZhengZaiBena.ResultBean> result, Context context) {
        this.result = result;
        this.context = context;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.more1, parent, false);

        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.imgView.setImageURI(result.get(position).getImageUrl());
        holder.text1.setText(result.get(position).getName());
        holder.text2.setText(result.get(position).getDirector());
        holder.text3.setText(result.get(position).getStarring());
        int movieId = result.get(position).getMovieId();
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
        holder.btnYuyue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                setYuyue.success(movieId);
            }
        });

    }

        setYuyue setYuyue;

    public void setSetYuyue(Fragment3Adapter.setYuyue setYuyue) {
        this.setYuyue = setYuyue;
    }

    public interface setYuyue {
        void success(int id);
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
        @BindView(R.id.btn_yuyue)
        Button btnYuyue;


        public Holder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
