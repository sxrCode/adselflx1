package com.sxr.com.mainmodule.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import com.sxr.com.mainmodule.R;

/**
 * Created by DELL on 2017/11/26.
 */

public class DetailView extends ScrollView {
    private FrameLayout mContent;
    private DetailTitleView mTitleView;

    public DetailView(Context context, AttributeSet attrs) {
        super(context, attrs);

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (inflater != null) {
            inflater.inflate(R.layout.view_detail_container, this);
        }

        LinearLayout linearLayout = (LinearLayout) getChildAt(0);
        mContent = linearLayout.findViewById(R.id.detail_content);
        mTitleView = linearLayout.findViewById(R.id.detail_head);
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
