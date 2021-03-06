package com.example.indianic.gridviewwithglideimage.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.indianic.gridviewwithglideimage.ImageLoad;
import com.example.indianic.gridviewwithglideimage.R;
import com.example.indianic.gridviewwithglideimage.model.Image;

import java.util.ArrayList;

/**
 * Created by indianic on 04/04/16.
 */
public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.MyHolder> {

    private int mHeight,mWidth;
    private Context mContext;
    private ArrayList<Image> mLinks;
    private LayoutInflater inflater;


    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.items, parent, false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyHolder holder, final int position) {
        final String linkk = mLinks.get(position).getFull();
        Glide.with(mContext).load(linkk).into(holder.imageView);
        Log.e("Position---", position + "");
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext,ImageLoad.class);
                intent.putExtra("url",linkk);
                intent.putExtra("height",mHeight);
                intent.putExtra("width",mWidth);
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mLinks.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder{
        private ImageView imageView;
        public MyHolder(View view) {
            super(view);
            imageView = (ImageView) view.findViewById(R.id.items_iv_link);
            imageView.getLayoutParams().height = mWidth/2;
            imageView.getLayoutParams().width = mWidth/2;
        }
    }

    public ImageAdapter(Context context,int height,int width,ArrayList<Image> links) {
        mContext = context;
        mLinks =links;
        mHeight = height;
        mWidth = width;
//        inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }



}
