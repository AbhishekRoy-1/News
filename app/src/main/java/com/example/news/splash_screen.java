package com.example.news;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ProgressBar;

import java.util.Objects;

public class splash_screen extends AppCompatActivity {
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        progressBar= findViewById(R.id.progressBar);
       // getSupportActionBar().hide();
        Thread thread= new Thread(){
            public void run() {
                try {
                    sleep(3000);
                    progressBar.setProgress(3000);
                }
                catch (Exception e){
                    e.printStackTrace();
                }
                finally{
                    Intent intent= new Intent(splash_screen.this,MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        };thread.start();

    }
}