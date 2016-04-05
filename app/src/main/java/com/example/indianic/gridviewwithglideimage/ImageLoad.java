package com.example.indianic.gridviewwithglideimage;

import android.app.ProgressDialog;
import android.app.WallpaperManager;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.GlideBitmapDrawable;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

import java.io.File;
import java.io.IOException;

public class ImageLoad extends AppCompatActivity {

    private String strURL;
    private int height,width;
    private ImageView imageView;
    private ImageView ivFullScreen;
    private ProgressDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_load);
        imageView = (ImageView) findViewById(R.id.imageoad_iv);
        ivFullScreen = (ImageView) findViewById(R.id.imageoad_iv_full);
        strURL = getIntent().getStringExtra("url");
        height = getIntent().getIntExtra("height", 0);
        width = getIntent().getIntExtra("width",0);
        dialog = new ProgressDialog(this);
        dialog.show();
        Glide.with(this).load("https://static.pexels.com/photos/479/landscape-nature-sunset-trees.jpg").listener(new RequestListener<String, GlideDrawable>() {
            @Override
            public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                Log.e("@@##Error",e.getMessage());
                return false;
            }

            @Override
            public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {

                dialog.cancel();
                return false;
            }
        }).error(R.drawable.full).into(imageView);
        ivFullScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Drawable drawable = imageView.getDrawable();
                Bitmap bitmap = ((GlideBitmapDrawable)drawable).getBitmap();

                //**set backgroudn**
                WallpaperManager manager = WallpaperManager.getInstance(getApplicationContext());
                try{
//                    manager.suggestDesiredDimensions(width,height);
                    manager.setBitmap(bitmap);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                //**Share Image**
//                String strPath = MediaStore.Images.Media.insertImage(getContentResolver(),bitmap,"","");
//                Uri uri = Uri.parse(strPath);
//                Intent shareIntent = new Intent(Intent.ACTION_SEND);
//                shareIntent.setType("image/*");
//                shareIntent.putExtra(Intent.EXTRA_STREAM, uri);
//                startActivity(Intent.createChooser(shareIntent, "Share image using"));
            }
        });
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }
}

