package com.example.laxmirefinary;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bottomnavapp.R;

public class SplashSreen extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        getActionBar().hide();
        setContentView(R.layout.activity_splash_sreen);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_sreen);
        VideoView videoView = (VideoView) findViewById(R.id.videoview);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        videoView.setVideoPath("android.resource://"+getPackageName()+"/"+R.raw.appstart);
        videoView.setOnCompletionListener(mediaPlayer -> {
            if(isFinishing())
                return;
            startActivity(new Intent(SplashSreen.this,HomeActivity.class));
            finish();
        });
        videoView.start();
    }
}