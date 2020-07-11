package com.toys.app;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

/**
 * Created by Aws on 11/03/2018.
 */

public class ListNewsAdapter extends RecyclerView.Adapter<ListNewsAdapter.ViewHolder> {

    private ArrayList<NewsModel> news=new ArrayList<>();
    private Context context;


    RequestOptions option;

    public ListNewsAdapter(Context context)
    {
        this.context=context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_news_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

        holder.Description.setText(news.get(position).getDescription());
        holder.Title.setText(news.get(position).getTitle());
        holder.pubdate.setText(news.get(position).getPubdate());
        holder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(@NonNull View v) {
                Intent intent=new Intent(context,DetailsActivity.class);
                intent.putExtra("url",news.get(position).getLink());
                context.startActivity(intent);
            }
        });
        /* Picasso.get().load(news.get(position).getCoverImage()).into(holder.cover_image);*/


    }

    @Override
    public int getItemCount() {
        return news.size();
    }

    public void setNews(ArrayList<NewsModel> news){
        this.news=news;
        notifyDataSetChanged();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        CardView parent;
        TextView Title,Description,pubdate ;
        ImageView cover_image;



        public ViewHolder(@NonNull View itemView) {
            super(itemView);


            Title = itemView.findViewById(R.id.Title);
            Description = itemView.findViewById(R.id.Description);
            pubdate = itemView.findViewById(R.id.pubdate);
            parent=itemView.findViewById(R.id.cardView);
            /*  cover_image = itemView.findViewById(R.id.coverImage);*/

        }
    }
}
