package com.toys.app;


import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Created by SHAJIB-PC on 9/9/2019.
 */

public class DetailsActivity extends AppCompatActivity {
    private WebView webView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        getSupportActionBar().setTitle("LATEST NEWS!!");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        Intent intent = getIntent();
        if(null!=intent){

            String url = intent.getStringExtra("url");
            if(null!=url){


                webView = findViewById(R.id.webView);
                webView.setWebViewClient(new WebViewClient());
                webView.getSettings().setJavaScriptEnabled(true);
                webView.loadUrl(url);
            }
        }
    }

    @Override
    public void onBackPressed() {
        if(webView.canGoBack()){
            getObbDir();
        }
        else{
            super.onBackPressed();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        Intent myIntent = new Intent(getApplicationContext(), covid_NewsActivity.class);
        startActivityForResult(myIntent, 0);

        return super.onOptionsItemSelected(item);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }
}