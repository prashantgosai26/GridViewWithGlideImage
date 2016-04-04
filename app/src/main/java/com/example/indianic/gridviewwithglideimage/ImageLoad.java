package com.example.indianic.gridviewwithglideimage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class ImageLoad extends AppCompatActivity {

    private String strURL;
    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_load);
        imageView = (ImageView) findViewById(R.id.imageoad_iv);
        strURL = getIntent().getStringExtra("url");
        Glide.with(this).load(strURL).into(imageView);
    }
}
