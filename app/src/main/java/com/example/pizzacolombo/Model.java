package com.example.pizzacolombo;

public class Model {



    String mItemName;
    String mItemDetail;
    int mItemPhoto;

    public Model(String mItemName, String mItemDetail, int mItemPhoto) {
        this.mItemName = mItemName;
        this.mItemDetail = mItemDetail;
        this.mItemPhoto = mItemPhoto;
    }




    public String getmItemName() {

        return mItemName;
    }

    public String getmItemDetail() {
        return mItemDetail;
    }

    public int getmItemPhoto() {
        return mItemPhoto;
    }
}
