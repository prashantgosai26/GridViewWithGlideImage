package com.example.indianic.gridviewwithglideimage;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;

import com.example.indianic.gridviewwithglideimage.adapter.ImageAdapter;
import com.example.indianic.gridviewwithglideimage.database.SqliteDBhelper;
import com.example.indianic.gridviewwithglideimage.model.Image;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private String[] thumble = {
            "https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcR49hteD1W_VlkscTgIW3rTS0v0Gb3bhITlY9yfg4d0xf3GIrRPHA",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSmzbRdXFv556hfuAsq_WrmcGGJYbKfoZhuOq2_S3UN6lQ_rLFEYA",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR4uJqzDTAO1ZHMsuZdXwvUkXVwWRBCzSmVs98YkkeCBmuKK8Hw",
            "https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcTkjMRE_4SIgLbIKUGrLh1IrwvBt3rC3Q9kaPk0QuleqZ_wkzuv",
            "https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcTkjMRE_4SIgLbIKUGrLh1IrwvBt3rC3Q9kaPk0QuleqZ_wkzuv",
            "https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcT4fxajsjjAG-bmUGw3jbBkvGgc6AdoDMnJ_QFf-erd_0FQBT2N",
            "https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcQL6N8AIEB2NlYEGamJZD5mbpIfat3JcQPJAewdXUyQRq88yM26DA",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSeirtt_qVfiMDey252DksruFvJscrjiMdHx21wxJC5_Kd8IICv",
            "https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcQbUfiomMAeHQrypf6yiiG0Sk2-Gz6LHSxBluJzcvu2SHMhNa7a6w",
            "https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcQtANH2ZUMqnG9jLYy0d1IRzbFaaGWT2KMONIjlTRFy1_Aqx7wCGQ",
            "https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcQKZOvpTLBEe6ZoMosJlz9SWpmtpdWqxiug0yVeK0FLf_1LB9ea-A",
            "https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcRKm1YdYVUwd_YqRuicG02DSPni1w5hQM0rfpLCVye8MexWt9Rf6Q"
    };

    private String[] newone ={
      "https://www.hdwallpapers.net/previews/lamborghini-centenario-lp770-4-1000.jpg",
            "https://www.hdwallpapers.net/previews/ford-gt-supercar-984.jpg",
            "https://www.hdwallpapers.net/previews/ford-mustang-shelby-gt500kr-977.jpg",
            "https://www.hdwallpapers.net/previews/fenyr-supersport-938.jpg",
            "https://www.hdwallpapers.net/previews/nissan-skyline-gt-r-evolution-882.jpg",
            "https://www.hdwallpapers.net/previews/volkswagen-cc-on-cw-12-concave-wheels-857.jpg",
            "https://www.hdwallpapers.net/previews/ford-mustang-shelby-gt500-841.jpg",
            "https://www.hdwallpapers.net/previews/lotus-340r-781.jpg",
            "https://www.hdwallpapers.net/previews/bmw-i8-designed-by-ac-schnitzer-756.jpg",
            "https://www.hdwallpapers.net/previews/bmw-e90-on-z-performance-wheels-745.jpg",
            "https://www.hdwallpapers.net/previews/laferrari-710.jpg",
            "https://www.hdwallpapers.net/previews/infiniti-red-bull-racing-rb11-2015-formula-1-car-614.jpg",
            "https://www.hdwallpapers.net/previews/mansory-carbonado-lamborghini-aventador-lp700-4-578.jpg",
            "https://www.hdwallpapers.net/previews/mclaren-mp4-12cf-by-mansory-577.jpg",
            "https://www.hdwallpapers.net/previews/shelby-mustang-gt500kr-537.jpg",
            "https://www.hdwallpapers.net/previews/lamborghini-murcielago-lp670-432.jpg",
            "https://www.hdwallpapers.net/previews/matte-black-ferrari-f430-on-savini-wheels-418.jpg",
            "https://www.hdwallpapers.net/previews/lamborghini-aventador-lp700-4-in-white-417.jpg",
            "https://www.hdwallpapers.net/previews/matte-black-lamborghini-aventador-on-vellano-wheels-416.jpg",
            "https://www.hdwallpapers.net/previews/lamborghini-aventador-lp722-by-prestige-imports-411.jpg",
            "https://www.hdwallpapers.net/previews/lamborghini-aventador-on-adv1-wheels-410.jpg",
            "https://www.hdwallpapers.net/previews/red-lamborghini-aventador-409.jpg",
            "https://www.hdwallpapers.net/previews/lamborghini-aventador-matte-black-408.jpg",
            "https://www.hdwallpapers.net/previews/white-lamborghini-aventador-363.jpg",
            "https://www.hdwallpapers.net/previews/2015-audi-rs-5-coupe-359.jpg"
    };
    private RecyclerView recyclerView;
    private SqliteDBhelper database;
    private Application application;
    private ArrayList<Image> images;
    private SQLiteDatabase mDB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DisplayMetrics displaymetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        application = (Application) getApplication();
        database = application.getSqliteDBhelper();
        images = new ArrayList<>();
        try {
            database.createDataBase();
            database.openDataBase();
            images = database.getLinks();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        int height = displaymetrics.heightPixels;
        int width = displaymetrics.widthPixels;
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(),2);
        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(new ImageAdapter(this,height,width,images));
    }
}
