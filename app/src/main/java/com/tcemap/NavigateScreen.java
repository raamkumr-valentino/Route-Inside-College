package com.tcemap;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;

public class NavigateScreen extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<NavigateRoute> list= new ArrayList<>();
    int[] img_id={R.drawable.bank,
            R.drawable.bhalls,
            R.drawable.cse,
            R.drawable.eee,
            R.drawable.fc,
            R.drawable.guesthouse,
            R.drawable.it,
            R.drawable.km,
            R.drawable.mecht,
            R.drawable.ncc,
            R.drawable.outdoor,
            R.drawable.parking,
            R.drawable.placementcell,
            R.drawable.science,
            R.drawable.temple};
    String[] location,instruction;
    String tym[]={"100m 3mins walk",
            "60m 1min",
            "52m 1min",
            "24m 50sec",
            "46m 1min9sec",
            "180m 5min",
            "56m 1min",
            "15min 30sec",
            "78m 2min",
            "107m 3min3sec",
            "37m 56sec",
            "85m 1min",
            "174m 3min",
            "35m 46sec",
            "190m 4min"};
    Toolbar toolbar;
    String from,to;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigate_screen);
        toolbar=(Toolbar)findViewById(R.id.app_bar_home_id);
        setSupportActionBar(toolbar);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
        {
            getWindow().setStatusBarColor(getResources().getColor(R.color.colorPrimary));
        }
        if(toolbar!=null)
        {
            getSupportActionBar().setTitle("Navigation");
            getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onBackPressed();
                }
            });
        }
        from=getIntent().getStringExtra("fromarray");
        location=getResources().getStringArray(R.array.names);
        instruction=getResources().getStringArray(R.array.From_Information_Technology);
        int count=0;
        for(String Location:location)
        {
            NavigateRoute navigateRoute=new NavigateRoute(img_id[count],Location,tym[count],instruction[count]);
            count++;
            list.add(navigateRoute);
        }
        recyclerView=(RecyclerView)findViewById(R.id.recycle_id);
        layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        adapter=new NavigateRouteAdapter(list);
        recyclerView.setAdapter(adapter);;
    }
}
