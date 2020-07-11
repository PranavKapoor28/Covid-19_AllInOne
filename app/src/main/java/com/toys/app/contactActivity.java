package com.toys.app;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class contactActivity extends AppCompatActivity {

    TextView linkedin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle("Contact Us");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        setContentView(R.layout.activity_contact);


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        Intent myIntent = new Intent(getApplicationContext(), HomeActivity.class);
        startActivityForResult(myIntent, 0);

        return super.onOptionsItemSelected(item);
    }



    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

}
