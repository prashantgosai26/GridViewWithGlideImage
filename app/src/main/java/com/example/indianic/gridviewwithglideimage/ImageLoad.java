package com.example.indianic.gridviewwithglideimage;

import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class ImageLoad extends AppCompatActivity {

    private String strURL;
    private ImageView imageView;
    private ImageView ivFullScreen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_load);
        imageView = (ImageView) findViewById(R.id.imageoad_iv);
        ivFullScreen = (ImageView) findViewById(R.id.imageoad_iv_full);
        strURL = getIntent().getStringExtra("url");
        Glide.with(this).load(strURL).into(imageView);
        ivFullScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
            }
        });
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }
}
