package com.sxr.com.mainmodule.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

import com.orhanobut.logger.Logger;


public abstract class BaseCustomViewGroup extends ViewGroup {

    protected boolean isReady = false;

    public BaseCustomViewGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
        onCreate(context, attrs);
        isReady = true;
    }

    protected abstract void onCreate(Context context, AttributeSet attrs);

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int count = getChildCount();
        for (int i = 0; i < count; i++) {
            final View child = getChildAt(i);
            if (child.getVisibility() != GONE) {
                ViewGroup.LayoutParams childLp = child.getLayoutParams();
                int left = getPaddingLeft();
                int right = left + child.getMeasuredWidth();
                int top = getPaddingTop();
                int bottom = top + child.getMeasuredHeight();

                child.layout(left, top, right, bottom);
            }
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        boolean isexactly = MeasureSpec.getMode(widthMeasureSpec) == MeasureSpec.EXACTLY && MeasureSpec.getMode(heightMeasureSpec) == MeasureSpec.EXACTLY;
        Logger.e("onMeasure.isexactly: " + isexactly);

        int maxWidth = 0;
        int maxHeight = 0;

        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View child = getChildAt(i);

            measureChild(child, widthMeasureSpec, heightMeasureSpec);
            maxWidth = Math.max(maxWidth, child.getMeasuredWidth());
            maxHeight = Math.max(maxHeight, child.getMeasuredHeight());
        }

        setMeasuredDimension(getDefaultSize(maxWidth, widthMeasureSpec), getDefaultSize(maxHeight, heightMeasureSpec));

        if (!isexactly) {
            for (int i = 0; i < childCount; i++) {
                View child = getChildAt(i);
                ViewGroup.LayoutParams lp = child.getLayoutParams();
                if (lp.height == ViewGroup.LayoutParams.MATCH_PARENT || lp.width == ViewGroup.LayoutParams.MATCH_PARENT) {
                    int childHeightSpec = getChildMeasureSpec(heightMeasureSpec, 0, lp.height);
                    if (lp.height == ViewGroup.LayoutParams.MATCH_PARENT) {
                        childHeightSpec = MeasureSpec.makeMeasureSpec(getMeasuredHeight(), MeasureSpec.EXACTLY);
                    }

                    int childWidthSpec = getChildMeasureSpec(widthMeasureSpec, 0, lp.width);
                    if (lp.width == ViewGroup.LayoutParams.MATCH_PARENT) {
                        childWidthSpec = MeasureSpec.makeMeasureSpec(getMeasuredWidth(), MeasureSpec.EXACTLY);
                    }

                    child.measure(childWidthSpec, childHeightSpec);
                }
            }
        }

    }
}
