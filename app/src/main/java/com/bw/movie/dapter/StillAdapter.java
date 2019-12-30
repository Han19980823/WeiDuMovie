package com.bw.movie.dapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bw.movie.R;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * 作者：Han98
 * 创建时间：2019/12/11
 * 描述：TODO
 * 最近修改：2019/12/11 10:34 modify by liujc
 */
public class StillAdapter extends RecyclerView.Adapter<StillAdapter.Hodler> {
    List<String> posterList;
    Context context;



    public StillAdapter(List<String> posterList, Context context) {
        this.posterList = posterList;
        this.context = context;
    }

    @NonNull
    @Override
    public Hodler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.stills, parent, false);
        return new Hodler(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Hodler holder, int position) {
        holder.sim.setImageURI(posterList.get(position));
    }

    @Override
    public int getItemCount() {
        return posterList.size();
    }

    class Hodler extends RecyclerView.ViewHolder {
        @BindView(R.id.sim)
        SimpleDraweeView sim;
        public Hodler(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
