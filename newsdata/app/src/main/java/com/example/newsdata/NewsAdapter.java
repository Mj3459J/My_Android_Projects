package com.example.newsdata;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.model.Model;


import java.util.ArrayList;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.Inner> {
    ArrayList<model> data;
    Context context;
    public NewsAdapter(ArrayList<model> data,Context context){
        this.data=data;
        this.context=context;
    }
    @NonNull
    @Override
    public NewsAdapter.Inner onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.news_item,parent,false);
        return new Inner(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsAdapter.Inner holder, int position) {
        Glide.with(context).load(data.get(position).urltoimage).into(holder.itemImage);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class Inner extends ViewHolder {
        ImageView itemImage;
        TextView titleText;
        TextView descText;
        public Inner(@NonNull View itemView) {
            super(itemView);
            itemImage= itemView.findViewById(R.id.myimage);
            titleText = itemView.findViewById(R.id.title);
            descText = itemView.findViewById(R.id.description);
        }
    }
}
