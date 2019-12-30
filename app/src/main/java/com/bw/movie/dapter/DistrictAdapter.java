package com.bw.movie.dapter;

import android.content.Context;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;




import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

import com.bw.movie.R;
import com.bw.movie.bean.RegionListBean;



public class DistrictAdapter extends RecyclerView.Adapter<DistrictAdapter.Holder> {

    private  List<RegionListBean.ResultBean> result;
    private Context context;

    public DistrictAdapter(List<RegionListBean.ResultBean> result, Context context) {
        this.result = result;
        this.context = context;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = View.inflate(context, R.layout.selector_item2, null);
        Holder holder = new Holder(inflate);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, final int i) {
        holder.movieName.setText(result.get(i).getRegionName());
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
        return result.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        @BindView(R.id.movie_name)
        TextView movieName;
        public Holder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
    public interface setItemClick{
        void setClick(int position);
    }
    private setItemClick setOnClick;
    public void setOnItemClick(setItemClick setOnClick){
        this.setOnClick = setOnClick;
    }
}
