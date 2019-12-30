package com.bw.movie.dapter;

import android.content.Context;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bw.movie.R;
import com.bw.movie.bean.MovieScheduleBean;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;


public class MovieScheduleAdapter extends RecyclerView.Adapter<MovieScheduleAdapter.Holder> {

    private List<MovieScheduleBean.ResultBean> list;
    private Context context;

    public MovieScheduleAdapter(List<MovieScheduleBean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Holder holder = new Holder(View.inflate(context, R.layout.movieschedule_adapter, null));
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, final int i) {
        holder.scheduleName.setText(list.get(i).getScreeningHall());

        String beginTime = list.get(i).getBeginTime();
        String endTime = list.get(i).getEndTime();
        String substring = beginTime.substring(0, 5);
        String substring1 = endTime.substring(0, 5);
        holder.startTime.setText(substring);
        holder.stopTime.setText(substring1);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (setOnClick != null){
                    setOnClick.setClick(i);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        @BindView(R.id.schedule_Name)
        TextView scheduleName;
        @BindView(R.id.start_Time)
        TextView startTime;
        @BindView(R.id.stop_Time)
        TextView stopTime;
        public Holder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
    public interface setOnClick{
        void setClick(int position);
    }
    private setOnClick setOnClick;
    public void setItemClick(setOnClick setOnClick){
        this.setOnClick = setOnClick;
    }
}
