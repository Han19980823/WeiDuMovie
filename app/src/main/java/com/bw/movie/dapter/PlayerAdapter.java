package com.bw.movie.dapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;

import com.bw.movie.R;
import com.bw.movie.bean.DetailsBean;


/**
 * 作者：Han98
 * 创建时间：2019/12/11
 * 描述：TODO
 * 最近修改：2019/12/11 10:34 modify by liujc
 */
public class PlayerAdapter extends RecyclerView.Adapter<PlayerAdapter.Hodler> {
    List<DetailsBean.ResultBean.ShortFilmListBean> shortFilmList;
    Context context;


    public PlayerAdapter(List<DetailsBean.ResultBean.ShortFilmListBean> shortFilmList, Context context) {
        this.shortFilmList = shortFilmList;
        this.context = context;
    }

    @NonNull
    @Override
    public Hodler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.player, parent, false);
        return new Hodler(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Hodler holder, int position) {
        holder.trailerMovie1.setUp(shortFilmList.get(position).getVideoUrl(),JCVideoPlayer.SCREEN_LAYOUT_NORMAL, "");

    }

    @Override
    public int getItemCount() {
        return shortFilmList.size();
    }

    class Hodler extends RecyclerView.ViewHolder {
        @BindView(R.id.trailer_movie1)
        JCVideoPlayer trailerMovie1;
        public Hodler(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
