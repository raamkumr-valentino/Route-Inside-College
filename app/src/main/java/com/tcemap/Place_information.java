package com.tcemap;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;

public class Place_information extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<Place_info> info=new ArrayList<>();
    //int img=R.drawable.bhalls;
    String[] information;
    String[] information_places;
    String[] information_tym;
    String time="10m 1min";
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_information);
        toolbar=(Toolbar)findViewById(R.id.app_bar_home_id);
        setSupportActionBar(toolbar);
        if(toolbar!=null)
        {
            getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        information=getResources().getStringArray(R.array.information_technology);
        information_places=getResources().getStringArray(R.array.it_places);
        information_tym=getResources().getStringArray(R.array.it_places_tym);
        int count=0;
        for(String Info : information)
        {
            Place_info placeInfo=new Place_info(information_places[count],information_tym[count],Info);
            count++;
            info.add(placeInfo);
        }
        recyclerView=(RecyclerView)findViewById(R.id.info_recycle);
        layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        adapter=new Place_info_Adapter(info);
        recyclerView.setAdapter(adapter);;
    }
}
