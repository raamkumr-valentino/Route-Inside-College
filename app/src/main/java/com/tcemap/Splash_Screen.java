package com.tcemap;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by RaamKumr on 8/13/2016.
 */
public class Splash_Screen extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);
        Thread splashThread=new Thread()
        {
            @Override
            public void run() {
                try {
                    sleep(3000);
                    Intent startApplication_Home = new Intent(getApplicationContext(),Home.class);
                    startActivity(startApplication_Home);
                    finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        splashThread.start();
    }
}
