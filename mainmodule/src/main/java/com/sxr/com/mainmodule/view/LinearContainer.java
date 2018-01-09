package com.sxr.com.mainmodule.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.orhanobut.logger.Logger;
import com.sxr.com.mainmodule.R;


public class LinearContainer extends ViewGroup {
    private boolean ready = false;

    private FrameLayout mHeadLayout;
    private FrameLayout mBodyLayout;
    private FrameLayout mFootLayout;

    public LinearContainer(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (inflater != null) {
            inflater.inflate(R.layout.view_linear_container, this);
            mHeadLayout = findViewById(R.id.linear_container_head);
            mBodyLayout = findViewById(R.id.linear_container_body);
            mFootLayout = findViewById(R.id.linear_container_foot);
            ready = true;
        }
    }

    @Override
    public void addView(View child, ViewGroup.LayoutParams params) {

        if (ready && params != null && params instanceof LayoutParams) {
            LayoutParams lp = (LayoutParams) params;
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) mBodyLayout.getLayoutParams();
            switch (lp.getPortion()) {
                case 0:
                    mHeadLayout.addView(child);
                    layoutParams = (LinearLayout.LayoutParams) mHeadLayout.getLayoutParams();
                    break;
                case 1:
                    mBodyLayout.addView(child);
                    layoutParams = (LinearLayout.LayoutParams) mBodyLayout.getLayoutParams();
                    break;
                case 2:
                    mFootLayout.addView(child);
                    layoutParams = (LinearLayout.LayoutParams) mFootLayout.getLayoutParams();
                    break;
                default:
                    mBodyLayout.addView(child);
            }
            layoutParams.weight = lp.weight;
        } else {
            super.addView(child, params);
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

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        final int count = getChildCount();

        for (int i = 0; i < count; i++) {
            final View child = getChildAt(i);
            if (child.getVisibility() != GONE) {

                final int width = child.getMeasuredWidth();
                final int height = child.getMeasuredHeight();

                child.layout(0, 0, width, height);
            }
        }
    }

    @Override
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attrs) {
        if (ready) {
            return new LayoutParams(getContext(), attrs);
        } else {
            return super.generateLayoutParams(attrs);
        }

    }

    @Override
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams lp) {
        if (lp instanceof LayoutParams) {
            return lp;
        }
        return super.generateLayoutParams(lp);
    }

    @Override
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return super.generateDefaultLayoutParams();
    }

    public static class LayoutParams extends FrameLayout.LayoutParams {

        private int portion = 1;
        private float weight = (float) 0.3;

        public LayoutParams(Context c, AttributeSet attrs) {
            super(c, attrs);
            TypedArray typedArray = c.obtainStyledAttributes(attrs, R.styleable.LinearContainer_layout);
            portion = typedArray.getInt(R.styleable.LinearContainer_layout_layout_portion, 1);
            weight = typedArray.getFloat(R.styleable.LinearContainer_layout_layout_weight, (float) 0.3);
            Logger.e("LayoutParams.portion: " + portion);
            typedArray.recycle();
        }

        public LayoutParams(ViewGroup.LayoutParams p) {
            super(p);
        }

        public LayoutParams(int width, int height) {
            super(width, height);
            this.portion = 0;
        }

        public int getPortion() {
            return portion;
        }
    }
}
