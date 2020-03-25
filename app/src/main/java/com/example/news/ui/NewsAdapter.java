package com.example.news.ui;

import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.news.R;
import com.example.news.model.Hits;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {
    private Context context;
    private Hits[] hits;
    public int mSelectedNews = 0;

    public NewsAdapter(Context context, Hits[] hits) {
        this.context = context;
        this.hits = hits;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_news_item, parent, false);
        return new ViewHolder(view);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String title = hits[position].getTitle();
        String date = hits[position].getCreatedAt();
        holder.tvTitle.setText(title);
        holder.tvDate.setText(date);

        holder.cvNewsListItem.setOnClickListener(view -> {
            holder.switchNews.toggle();

        });

    }

    public void setData(Hits[] hits) {
        this.hits = hits;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if (hits== null){
            return 0;
        }else{
            return hits.length;
        }

    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle = itemView.findViewById(R.id.tvTitle);
        TextView tvDate = itemView.findViewById(R.id.tvDate);
        CardView cvNewsListItem = itemView.findViewById(R.id.cvNewsListItem);
        Switch switchNews = itemView.findViewById(R.id.switchListItem);

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }


}
