package com.example.rizki.talentbdgproject.classes;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by Rizki on 11/17/2017.
 */

public class CustomTextView extends TextView {

    public CustomTextView(Context context) {
        super(context);
        setFont();
    }
    public CustomTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setFont();
    }
    public CustomTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        setFont();
    }

    private void setFont() {
        Typeface font = Typeface.createFromAsset(getContext().getAssets(), "fonts/BestMarker.ttf");
        setTypeface(font, Typeface.NORMAL);
    }

}
