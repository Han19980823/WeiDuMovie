package com.bw.movie.dapter;


/*
 *@auther:胡明明
 *@Date: 2019/11/20
 *@Time:20:30
 *@Description:${DESCRIPTION}
 **/

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bw.movie.R;
import com.bw.movie.bean.YingTingBean;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class YingTingAdapter extends RecyclerView.Adapter<YingTingAdapter.Holder> {
    Context context;
    List<YingTingBean.ResultBean> result;


    public YingTingAdapter(Context context, List<YingTingBean.ResultBean> result) {
        this.context = context;
        this.result = result;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.yingying_item, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {

        holder.yingtingName.setText(result.get(position).getScreeningHall());

        holder.yingtingTimestart.setText(result.get(position).getBeginTime());

        holder.yingtingTimeclose.setText(result.get(position).getEndTime());

        holder.relaview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClicks.onChangeData(result.get(position).getHallId(), result.get(position).getFare(), result.get(position).getId());
            }
        });
    }

    @Override
    public int getItemCount() {
        return result.size();
    }

    class Holder extends RecyclerView.ViewHolder {
        @BindView(R.id.yingting_name)
        TextView yingtingName;
        @BindView(R.id.yingting_timestart)
        TextView yingtingTimestart;
        @BindView(R.id.yingting_timeclose)
        TextView yingtingTimeclose;
        @BindView(R.id.relaview)
        RelativeLayout relaview;
        public Holder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }



    //接口回调
    onItemClicks onItemClicks;

    public void setOnItemClicks(onItemClicks onItemClicks) {
        this.onItemClicks = onItemClicks;
    }

    public interface onItemClicks {
        void onChangeData(int p, double fare, int ytid);
    }
}
