package com.sxr.com.mainmodule.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.orhanobut.logger.Logger;


public class CustomHorScrollView extends FrameLayout {

    private View mContentView;
    private int mOldOffset = 0;

    private int mMaxRight = 0;

    public CustomHorScrollView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        init();
    }

    private void init() {
    }

    public void move(int newOffset) {
        Logger.e("mOldOffset: " + mOldOffset + "; newOffset: " + newOffset);
        if (mContentView != null) {
            ValueAnimator valueAnimator = ValueAnimator.ofInt(mOldOffset, newOffset).setDuration(200);
            valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    int offset = (Integer) animation.getAnimatedValue();
                    if (offset < 0 || offset > mMaxRight) {

                    } else {
                        scrollTo(offset, 0);
                        mOldOffset = offset;
                    }
                }
            });

            valueAnimator.start();
        }
    }

    public int getOldOffset() {
        return mOldOffset;
    }

    @Override
    protected void measureChildWithMargins(View child, int parentWidthMeasureSpec, int widthUsed,
                                           int parentHeightMeasureSpec, int heightUsed) {
        final MarginLayoutParams lp = (MarginLayoutParams) child.getLayoutParams();

        final int childHeightMeasureSpec = getChildMeasureSpec(parentHeightMeasureSpec,
                0 + lp.topMargin + lp.bottomMargin
                        + heightUsed, lp.height);
        final int usedTotal = 0 + lp.leftMargin + lp.rightMargin +
                widthUsed;
        final int childWidthMeasureSpec = MeasureSpec.makeMeasureSpec(
                Math.max(0, MeasureSpec.getSize(parentWidthMeasureSpec) - usedTotal),
                MeasureSpec.UNSPECIFIED);

        child.measure(childWidthMeasureSpec, childHeightMeasureSpec);
    }

    @Override
    public void addView(View child) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("HorizontalScrollView can host only one direct child");
        }
        mContentView = child;
        super.addView(child);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        mMaxRight = mContentView.getWidth() - getWidth();
    }

    @Override
    public void addView(View child, int index) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("HorizontalScrollView can host only one direct child");
        }
        mContentView = child;
        super.addView(child, index);
    }

    @Override
    public void addView(View child, ViewGroup.LayoutParams params) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("HorizontalScrollView can host only one direct child");
        }
        mContentView = child;
        super.addView(child, params);
    }

    @Override
    public void addView(View child, int index, ViewGroup.LayoutParams params) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("HorizontalScrollView can host only one direct child");
        }

        mContentView = child;
        super.addView(child, index, params);
    }
}
