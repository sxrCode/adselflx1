package com.sxr.com.mainmodule.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.sxr.com.mainmodule.R;

import static android.content.Context.*;


public class ColorOptionsView extends LinearLayout {
    private View mValue;
    private ImageView mImage;

    public ColorOptionsView(Context context) {
        super(context);
    }

    public ColorOptionsView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        @SuppressLint("CustomViewStyleable") TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.Options, 0, 0);
        String title = typedArray.getString(R.styleable.Options_titleText);
        int valueColor = typedArray.getColor(R.styleable.Options_valueColor, getResources().getColor(R.color.blue_sky));
        typedArray.recycle();

        setOrientation(LinearLayout.HORIZONTAL);
        setGravity(Gravity.CENTER_VERTICAL);

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(LAYOUT_INFLATER_SERVICE);
        if (inflater != null) {
            inflater.inflate(R.layout.view_color_options, this);
        }

        TextView titleView = (TextView) getChildAt(0);
        titleView.setText(title);

        mImage = (ImageView) getChildAt(2);

        mValue = getChildAt(1);
        mValue.setBackgroundColor(valueColor);
    }

    public ColorOptionsView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setValueColor(int color) {
        mValue.setBackgroundColor(color);
    }

    public void setImageVisible(boolean visible) {
        mImage.setVisibility(visible ? View.VISIBLE : View.GONE);
    }

}
