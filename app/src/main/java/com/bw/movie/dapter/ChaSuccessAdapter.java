package com.bw.movie.dapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bw.movie.R;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.bw.movie.bean.SelectBean;


/**
 * 作者：Han98
 * 创建时间：2019/12/6
 * 描述：TODO
 * 最近修改：2019/12/6 14:16 modify by liujc
 */
public class ChaSuccessAdapter extends RecyclerView.Adapter<ChaSuccessAdapter.Holder> {
    Context context;
    List<SelectBean.ResultBean> result;

    public ChaSuccessAdapter(Context context,  List<SelectBean.ResultBean> resultt) {
        this.context = context;
        this.result = resultt;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.cha, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.imgView.setImageURI(result.get(position).getImageUrl());
        holder.text.setText(result.get(position).getName());
        holder.text1.setText("导演: "+result.get(position).getDirector());
        holder.text2.setText("演员: "+result.get(position).getStarring());
        holder.text3.setText("评分: "+result.get(position).getScore()+"");


    }

    @Override
    public int getItemCount() {
        return result.size();
    }

    class Holder extends RecyclerView.ViewHolder {
        @BindView(R.id.img_view)
        SimpleDraweeView imgView;
        @BindView(R.id.text)
        TextView text;
        @BindView(R.id.text1)
        TextView text1;
        @BindView(R.id.text2)
        TextView text2;
        @BindView(R.id.text3)
        TextView text3;


        public Holder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
