package com.bw.movie.dapter;




import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bw.movie.R;
import com.bw.movie.bean.ShiJianYingYuanBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class ShiJianYingYuanAdapter extends RecyclerView.Adapter<ShiJianYingYuanAdapter.Holder> {
    Context context;
    List<ShiJianYingYuanBean.ResultBean> result;


    public ShiJianYingYuanAdapter(Context context, List<ShiJianYingYuanBean.ResultBean> result) {

        this.context = context;
        this.result = result;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.yingyuan_item1, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.yingyuanItem1Name.setText(result.get(position).getName());
        holder.yingyuanItem1Dizhi.setText(result.get(position).getAddress());
        holder.yingyuanItem1Juli.setText(result.get(position).getPrice()+"元");
        holder.yingyuanItem1Img.setImageURI(result.get(position).getLogo());


        holder.relative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClicks.onChangeData(result.get(position).getCinemaId());
            }
        });
    }

    @Override
    public int getItemCount() {
        return result.size();
    }

    class Holder extends RecyclerView.ViewHolder {
        @BindView(R.id.yingyuan_item1_img)
        SimpleDraweeView yingyuanItem1Img;
        @BindView(R.id.yingyuan_item1_name)
        TextView yingyuanItem1Name;
        @BindView(R.id.yingyuan_item1_dizhi)
        TextView yingyuanItem1Dizhi;
        @BindView(R.id.yingyuan_item1_juli)
        TextView yingyuanItem1Juli;
        @BindView(R.id.relative)
        RelativeLayout relative;
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
