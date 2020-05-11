package com.toys.app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.request.RequestOptions;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Aws on 11/03/2018.
 */

public class ListNewsAdapter extends RecyclerView.Adapter<ListNewsAdapter.ViewHolder> {

    LayoutInflater inflater;
    List<NewsModel> news;


    RequestOptions option;

    public ListNewsAdapter(Context mContext,List<NewsModel> news)
    {
        this.inflater=LayoutInflater.from(mContext);
        this.news = news;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view=inflater.inflate(R.layout.list_news_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.Author.setText(news.get(position).getAuthor());
        holder.Title.setText(news.get(position).getTitle());
        Picasso.get().load(news.get(position).getCoverImage()).into(holder.cover_image);

    }

    @Override
    public int getItemCount() {
        return news.size();
    }
/*
    private Context mContext ;
    private List<NewsModel> mData ;
    RequestOptions option;*/



    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView Author,Title ;
        ImageView cover_image;



        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            Author = itemView.findViewById(R.id.Author);
            Title = itemView.findViewById(R.id.Title);

            cover_image = itemView.findViewById(R.id.coverImage);

        }
    }
}

