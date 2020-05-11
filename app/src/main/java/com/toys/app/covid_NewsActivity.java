package com.toys.app;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class covid_NewsActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<NewsModel> news;
    private static String JSON_URL="http://newsapi.org/v2/top-headlines?country=in&apiKey=b58d2dda442b496eac9b741d350d678f";
    ListNewsAdapter adapter;




    private AppBarConfiguration mAppBarConfiguration;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_covid__news);


        recyclerView=findViewById(R.id.news_list);
        news=new ArrayList<>();
        fetchData();


        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        adapter=new ListNewsAdapter(getApplicationContext(),news);
        recyclerView.setAdapter(adapter);

    }

    private void fetchData() {

        RequestQueue queue=Volley.newRequestQueue(this);
        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, JSON_URL, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        try {
                            JSONObject Obj = response.getJSONObject(0);

                            JSONArray jsonArry = Obj.optJSONArray("articles");
/*
                            for (int i = 0; i < jsonArry.length(); i++) {
                                //gets each JSON object within the JSON array
                                JSONObject jsonObject = jsonArry.getJSONObject(i);

                                NewsModel news = new NewsModel();
                                news.setAuthor(jsonObject.optString("author"));
                                news.setTitle(jsonObject.optString("title"));
                                news.setDescription(jsonObject.optString("description"));
                                news.setCoverImage(jsonObject.optString("CoverImage"));
                                news.setContent(jsonObject.optString("content"));

                                news.add(news);
                            }*/
                        }catch (Exception e) {
                            e.printStackTrace();
                        }
                    }

                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("tag","onErrorResponse:"+error.getMessage());
            }

        });

        queue.add(request);
    }


}