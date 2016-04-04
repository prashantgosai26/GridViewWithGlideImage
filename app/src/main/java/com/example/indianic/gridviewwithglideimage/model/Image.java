package com.example.indianic.gridviewwithglideimage.model;

/**
 * Created by indianic on 04/04/16.
 */
public class Image {

    private int id;
    private String thumble;
    private String full;

    public Image(int id, String thumble, String full) {
        this.id = id;
        this.thumble = thumble;
        this.full = full;
    }

    public int getId() {
        return id;
    }

    public String getThumble() {
        return thumble;
    }

    public String getFull() {
        return full;
    }

}
