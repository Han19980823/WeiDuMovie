package com.bw.movie.dapter;

import android.content.Context;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bw.movie.R;
import com.bw.movie.bean.PaiQiBean;
import com.bw.movie.bean.SearchBean;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.Holder> {

    private Context context;
    List<PaiQiBean.ResultBean> result;

    public SearchAdapter(Context context,  List<PaiQiBean.ResultBean> result) {
        this.context = context;
        this.result = result;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(context, R.layout.search_activity_adapter, null);
        Holder holder = new Holder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, final int i) {
        Glide.with(context).load(result.get(i).getImageUrl()).into(holder.comingImage);
        holder.comingName.setText(result.get(i).getName());
        holder.comingTime.setText("导演:"+result.get(i).getDirector());
        holder.comingMiss.setText("演员:"+result.get(i).getStarring());
        holder.searchScroe.setText("评分:"+result.get(i).getScore());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ItemClick != null){
                    ItemClick.OnClick(i);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return result.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        @BindView(R.id.coming_image)
        ImageView comingImage;
        @BindView(R.id.coming_name)
        TextView comingName;
        @BindView(R.id.coming_time)
        TextView comingTime;
        @BindView(R.id.coming_miss)
        TextView comingMiss;
        @BindView(R.id.search_scroe)
        TextView searchScroe;
        @BindView(R.id.coming_but)
        Button comingBut;
        @BindView(R.id.coming_relat)
        RelativeLayout comingRelat;

        public Holder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public interface setOnClick {
        void OnClick(int position);
    }

    private setOnClick ItemClick;

    public void setClickLister(setOnClick ItemClick) {
        this.ItemClick = ItemClick;
    }
}
