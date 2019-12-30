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
import com.bw.movie.bean.DetailsBean;



/**
 * 作者：Han98
 * 创建时间：2019/12/11
 * 描述：TODO
 * 最近修改：2019/12/11 09:55 modify by liujc
 */
public class ActorAdapter extends RecyclerView.Adapter<ActorAdapter.Holder> {
    List<DetailsBean.ResultBean.MovieActorBean> movieActor;
    Context context;


    public ActorAdapter(List<DetailsBean.ResultBean.MovieActorBean> movieActor, Context context) {
        this.movieActor = movieActor;
        this.context = context;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.actor, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.imgView1.setImageURI(movieActor.get(position).getPhoto());
        holder.textName1.setText(movieActor.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return movieActor.size();
    }


    class Holder extends RecyclerView.ViewHolder {
        @BindView(R.id.img_view1)
        SimpleDraweeView imgView1;
        @BindView(R.id.text_name1)
        TextView textName1;
        public Holder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
