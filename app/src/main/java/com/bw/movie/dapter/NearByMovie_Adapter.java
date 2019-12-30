package com.bw.movie.dapter;

import android.content.Context;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import com.bw.movie.R;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.bw.movie.bean.NearByMovieBean;



public class NearByMovie_Adapter extends XRecyclerView.Adapter<NearByMovie_Adapter.Holder> {



    private Context context;
    private List<NearByMovieBean.ResultBean> list;

    public NearByMovie_Adapter(Context context, List<NearByMovieBean.ResultBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(context, R.layout.nearbymovie_adapter, null);
        Holder holder = new Holder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, final int i) {
        Glide.with(context).load(list.get(i).getLogo()).into(holder.nearbymovieAdapterImage);
        holder.nearbymovieAdapterName.setText(list.get(i).getName());
        holder.nearbymovieAdapterAddress.setText(list.get(i).getAddress());
        holder.nearbymovieAdapterDistance.setText(list.get(i).getDistance()+"m");
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (setClick != null){
                    setClick.setOnClick(i);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        @BindView(R.id.nearbymovie_adapter_image)
        ImageView nearbymovieAdapterImage;
        @BindView(R.id.nearbymovie_adapter_name)
        TextView nearbymovieAdapterName;
        @BindView(R.id.nearbymovie_adapter_address)
        TextView nearbymovieAdapterAddress;
        @BindView(R.id.nearbymovie_adapter_distance)
        TextView nearbymovieAdapterDistance;

        public Holder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
    public interface setClick{
        void setOnClick(int position);
    }
    private setClick setClick;
    public void setItemClick(setClick setClick){
        this.setClick = setClick;
    }
}
