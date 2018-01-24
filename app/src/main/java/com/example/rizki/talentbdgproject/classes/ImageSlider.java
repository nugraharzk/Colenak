package com.example.rizki.talentbdgproject.classes;

import android.support.annotation.DrawableRes;

/**
 * Created by Rizki on 11/17/2017.
 */

public class ImageSlider {

    private String name;

    //optional @DrawableRes
    @DrawableRes
    private int resId;

    public ImageSlider(String name, int resId) {
        this.name = name;
        this.resId = resId;
    }

    @Override
    public String toString() {
        return name;
    }

}
