package com.bw.movie.dapter;


/*
 *@auther:胡明明
 *@Date: 2019/11/13
 *@Time:20:30
 *@Description:${DESCRIPTION}
 **/

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bw.movie.R;
import com.bw.movie.bean.RegionListBean;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class QuLieAdapter extends RecyclerView.Adapter<QuLieAdapter.Holder> {
    List<RegionListBean.ResultBean> result;
    Context context;

    public QuLieAdapter(List<RegionListBean.ResultBean> result, Context context) {
        this.result = result;
        this.context = context;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.yingyuan_item, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
            holder.yingyuanText.setText(result.get(position).getRegionName());
            holder.yingyuanLinear.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onItemClicks.onChangeData(result.get(position).getRegionId());
                }
            });

    }

    @Override
    public int getItemCount() {
        return result.size();
    }

    class Holder extends RecyclerView.ViewHolder {
        @BindView(R.id.yingyuan_text)
        TextView yingyuanText;
        @BindView(R.id.yingyuan_linear)
        LinearLayout yingyuanLinear;

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
        void onChangeData(int p);
    }

}
