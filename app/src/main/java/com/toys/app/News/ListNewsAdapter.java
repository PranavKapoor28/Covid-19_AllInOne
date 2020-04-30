package com.toys.app.News;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.toys.app.R;

import java.util.ArrayList;
import java.util.List;

public class ListNewsAdapter extends ArrayAdapter<NewsModel> {

    private Context context;
    private List<NewsModel> newsModelsList;
    private List<NewsModel> newsModelsListFiltered;

    public ListNewsAdapter( Context context, List<NewsModel> newsModelsList) {
        super(context, R.layout.list_custom_item,newsModelsList);

        this.context = context;
        this.newsModelsList = newsModelsList;
        this.newsModelsListFiltered = newsModelsList;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_custom_item,null,true);
        TextView tvAuthor = view.findViewById(R.id.tvAuthor);
        TextView tvTitle = view.findViewById(R.id.tvTitle);
        TextView tvDescription = view.findViewById(R.id.tvDescription);

        ImageView imageView = view.findViewById(R.id.imageFlag1);

        tvAuthor.setText(newsModelsListFiltered.get(position).getAuthor());
        tvTitle.setText(newsModelsListFiltered.get(position).getTitle());
        tvDescription.setText(newsModelsListFiltered.get(position).getDescription());


        Glide.with(context).load(newsModelsListFiltered.get(position).getFlag()).into(imageView);

        return view;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Nullable
    @Override
    public NewsModel getItem(int position) {
        return newsModelsListFiltered.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public Filter getFilter() {
        Filter filter = new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {

                FilterResults filterResults = new FilterResults();
                if(constraint == null || constraint.length() == 0){
                    filterResults.count = newsModelsList.size();
                    filterResults.values = newsModelsList;

                }else{
                    List<NewsModel> resultsModel = new ArrayList<>();
                    String searchStr = constraint.toString().toLowerCase();

                    for(NewsModel itemsModel:newsModelsList){
                        if(itemsModel.getAuthor().toLowerCase().contains(searchStr)){
                            resultsModel.add(itemsModel);

                        }
                        filterResults.count = resultsModel.size();
                        filterResults.values = resultsModel;
                    }


                }

                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {

                newsModelsListFiltered = (List<NewsModel>) results.values;
                covid_NewsActivity.newsModelsList = (List<NewsModel>) results.values;
                notifyDataSetChanged();

            }
        };
        return filter;
    }



        }