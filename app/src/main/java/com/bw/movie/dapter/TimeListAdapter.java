package com.bw.movie.dapter;

import android.content.Context;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bw.movie.R;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;


public class TimeListAdapter extends RecyclerView.Adapter<TimeListAdapter.Holder> {

    private List<String> list;
    private Context context;

    public TimeListAdapter(List<String> result, Context context) {
        this.list = result;
        this.context = context;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = View.inflate(context, R.layout.time_item, null);
        Holder holder = new Holder(inflate);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, final int i) {
        holder.movieName.setText(list.get(i+1));
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
        return list.size()-1;
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
