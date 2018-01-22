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


public class LinearContainer extends BaseCustomViewGroup {

    private FrameLayout mHeadLayout;
    private FrameLayout mBodyLayout;
    private FrameLayout mFootLayout;

    public LinearContainer(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onCreate(Context context, AttributeSet attrs) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (inflater != null) {
            inflater.inflate(R.layout.view_linear_container, this);
            mHeadLayout = findViewById(R.id.linear_container_head);
            mBodyLayout = findViewById(R.id.linear_container_body);
            mFootLayout = findViewById(R.id.linear_container_foot);

        }
    }

    @Override
    public void addView(View child, ViewGroup.LayoutParams params) {

        if (isReady && params != null && params instanceof LayoutParams) {
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
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attrs) {
        if (isReady) {
            return new LayoutParams(getContext(), attrs);
        } else {
            return super.generateLayoutParams(attrs);
        }

    }

    @Override
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams lp) {
        if (lp instanceof LayoutParams) {
            return (LayoutParams) lp;
        }
        return super.generateLayoutParams(lp);
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
