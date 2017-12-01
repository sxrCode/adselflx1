package com.sxr.com.mainmodule.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.sxr.com.mainmodule.R;


public class NotificationItemView extends LinearLayout {
    private TextView mTitle;

    private FrameLayout mContent;

    public NotificationItemView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (inflater != null) {
            inflater.inflate(R.layout.view_item_notification, this);
        }

        mTitle = (TextView) getChildAt(0);
        mContent = (FrameLayout) getChildAt(1);
    }

    public void setTitle(String title) {
        mTitle.setText(title);
    }

    @Override
    public void addView(View child) {
        if (mContent == null) {
            super.addView(child);
        } else {
            mContent.addView(child);
        }
    }

    @Override
    public void addView(View child, int index) {
        if (mContent == null) {
            super.addView(child, index);
        } else {
            mContent.addView(child, index);
        }
    }

    @Override
    public void addView(View child, ViewGroup.LayoutParams params) {
        if (mContent == null) {
            super.addView(child, params);
        } else {
            mContent.addView(child, params);
        }
    }

    @Override
    public void addView(View child, int width, int height) {
        if (mContent == null) {
            super.addView(child, width, height);
        } else {
            mContent.addView(child, width, height);
        }
    }

    @Override
    public void addView(View child, int index, ViewGroup.LayoutParams params) {
        if (mContent == null) {
            super.addView(child, index, params);
        } else {
            mContent.addView(child, index, params);
        }
    }
}
