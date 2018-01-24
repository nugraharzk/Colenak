package com.example.rizki.talentbdgproject.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.rizki.talentbdgproject.R;
import com.example.rizki.talentbdgproject.classes.ImageSlider;

import java.util.List;

/**
 * Created by Rizki on 11/17/2017.
 */

public class PagerAdapter extends android.support.v4.view.PagerAdapter {
    Context context;
    LayoutInflater layoutInflater;
    int[] resource;

    public PagerAdapter(Context context, int[] resource) {
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
        this.resource = resource;
    }

    @Override
    public int getCount() {
        return resource.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == ((LinearLayout)object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = layoutInflater.inflate(R.layout.slider_home, container, false);

        ImageView imageView = view.findViewById(R.id.imageView);
        imageView.setImageResource(resource[position]);

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((LinearLayout)object);
    }
}
