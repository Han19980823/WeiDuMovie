package com.bw.movie.dapter;


/*
 *@auther:胡明明
 *@Date: 2019/11/20
 *@Time:15:29
 *@Description:${DESCRIPTION}
 **/

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.ButterKnife;

import com.bw.movie.R;
import com.bw.movie.bean.ShiJianBean;

import java.util.List;

public class ShiJianAdapter extends RecyclerView.Adapter<ShiJianAdapter.ViewHolder> {
    private Context context;
    private ShiJianBean shiJianBean;

    public ShiJianAdapter(Context context, ShiJianBean shiJianBean) {
        this.context = context;
        this.shiJianBean = shiJianBean;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.xuanzuo_shijian, null);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        List<String> result = shiJianBean.getResult();
            if (holder instanceof ViewHolder){
                holder.textView.setText(result.get(position));
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onItemClicks.onChangeData(result.get(position));
                    }
                });
            }
    }

    @Override
    public int getItemCount() {
        return shiJianBean.getResult().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
            TextView textView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
    //接口回调
    onItemClicks onItemClicks;
    public void setOnItemClicks( onItemClicks onItemClicks){
        this.onItemClicks = onItemClicks;
    }
    public interface onItemClicks{
        void onChangeData(String p);
    }

}
