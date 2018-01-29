package com.sxr.com.mainmodule.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.OverScroller;

import com.orhanobut.logger.Logger;
import com.sxr.com.mainmodule.utils.TouchEventUtils;


public class CustomHorScrollView extends FrameLayout {

    private View mContentView;
    private int mOldOffset = 0;

    private int mMaxRight = 0;

    private float oldX = 0;

    private OverScroller mScroller;

    public CustomHorScrollView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        init();
    }

    private void init() {
        mScroller = new OverScroller(getContext());
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        TouchEventUtils.clacifyAction(event, "CustomHorScrollView onTouchEvent");
        switch (event.getAction()) {
            case MotionEvent.ACTION_MOVE:
                int newX = (int) event.getX();
                move((int) (mOldOffset - newX + oldX));
                Logger.e("offset: " + (mOldOffset - newX + oldX));
                oldX = newX;
                break;

            case MotionEvent.ACTION_DOWN:
                oldX = event.getX();
                return true;

        }
        return super.onTouchEvent(event);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        TouchEventUtils.clacifyAction(ev, "CustomHorScrollView dispatchTouchEvent");
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean shouldDelayChildPressedState() {
        return true;
    }

    public void move(int newOffset) {
        Logger.e("mOldOffset: " + mOldOffset + "; newOffset: " + newOffset);
        if (mContentView != null) {
            if (newOffset < 0 || newOffset > mMaxRight) {

            } else {
                scrollTo(newOffset, 0);
                mOldOffset = newOffset;
            }
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
