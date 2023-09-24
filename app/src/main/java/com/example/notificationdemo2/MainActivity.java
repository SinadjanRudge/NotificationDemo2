package com.example.notificationdemo2;


import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    Handler handler = new Handler();
    Runnable runnable;
    int delay = 4000;

    private Button button;

    Adapter adapter;
    RecyclerView recyclerView;

    Toolbar toolbar;


    ArrayList courseImg = new ArrayList<>();
    ArrayList courseName = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       // ActionBar actionBar = getSupportActionBar();
        
       // actionBar.setTitle("EyeSentry");
        
      //  actionBar.setDisplayUseLogoEnabled(true);
        
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        // Getting reference of recyclerView
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        // Setting the layout as linear
        // layout for vertical orientation
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);

        // Sending reference and data to Adapter
        //Adapter adapter = new Adapter(MainActivity.this, courseImg, courseName);
        adapter = new Adapter(MainActivity.this, courseImg, courseName);

        courseImg.add(0,R.drawable.awake);
        courseName.add(0,"Awake" + "  " + "BSIT" + " " + "4" + "A");

        // Setting Adapter to RecyclerView
        recyclerView.setAdapter(adapter);

    }


    @Override
    protected void onResume() {
        handler.postDelayed(runnable = new Runnable() {
            public void run() {
                handler.postDelayed(runnable, delay);

                if (courseImg.size() > 3)
                {
                    courseImg.remove(courseImg.size() - 1);
                    courseName.remove(courseImg.size() - 1);
                }
                courseImg.add(0,R.drawable.girl);
                courseName.add(0,"Sarah Leland" + "  " + "BSIT" + " " + "4" + "A");
                adapter.notifyDataSetChanged();
            }
        }, delay);
        super.onResume();
    }







}