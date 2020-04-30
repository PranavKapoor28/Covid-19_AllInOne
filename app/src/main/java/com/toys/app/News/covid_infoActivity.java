package com.toys.app.News;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.toys.app.R;

public class covid_infoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle("CoronaVirus 19");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        setContentView(R.layout.activity_covid_info);



    }
}
