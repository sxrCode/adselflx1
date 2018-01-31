package com.sxr.com.mainmodule.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.OverScroller;

import com.orhanobut.logger.Logger;


public class CustomHorScrollView extends FrameLayout {

    private View mContentView;
    private int mOldOffset = 0;

    private int mMaxRight = 0;

    private float oldX = 0;

    private int mSpaceWidth = 240;

    private OverScroller mScroller;
    private VelocityTracker mVelocityTracker;

    private GestureDetector mDetector;

    public CustomHorScrollView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        mScroller = new OverScroller(getContext());
        mVelocityTracker = VelocityTracker.obtain();

        mDetector = new GestureDetector(getContext(), new GestureDetector.OnGestureListener() {
            @Override
            public boolean onDown(MotionEvent e) {
                Logger.e("mDetector onDown!");
                return false;
            }

            @Override
            public void onShowPress(MotionEvent e) {
                Logger.e("mDetector onShowPress!");
            }

            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                Logger.e("mDetector onSingleTapUp!");
                return false;
            }

            @Override
            public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
                Logger.e("mDetector onScroll!");
                return false;
            }

            @Override
            public void onLongPress(MotionEvent e) {
                Logger.e("mDetector onLongPress!");
            }

            @Override
            public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
                Logger.e("mDetector onFling!");
                return false;
            }
        });

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //TouchEventUtils.clacifyAction(event, "CustomHorScrollView onTouchEvent");
        //mDetector.onTouchEvent(event);
        mVelocityTracker.addMovement(event);
        switch (event.getAction()) {
            case MotionEvent.ACTION_MOVE:
                int newX = (int) event.getX();
                move((int) (mOldOffset - newX + oldX));
                //Logger.e("offset: " + (mOldOffset - newX + oldX));
                oldX = newX;
                break;

            case MotionEvent.ACTION_DOWN:
                oldX = event.getX();
            case MotionEvent.ACTION_UP:
                // 当手指抬起时，根据当前的滚动值来判定应该滚动到哪个子控件的界面
                mVelocityTracker.computeCurrentVelocity(1000);
                Logger.e("velocityX: " + mVelocityTracker.getXVelocity());
                if (Math.abs(mVelocityTracker.getXVelocity()) > 1000) {
                    mScroller.fling((int) getScrollX(), 0, -(int) mVelocityTracker.getXVelocity(), 0, 0, mMaxRight, 0, 0, 120, 0);
                } else {
                    int scrollx = getScrollX();
                    int b = (scrollx + (mSpaceWidth / 2)) / mSpaceWidth;
                    mScroller.startScroll(getScrollX(), 0, mSpaceWidth * b - getScrollX(), 0);
                    Logger.e("c: " + (scrollx + (mSpaceWidth / 2)) + "; b: " + b + "; scrollx: " + scrollx);
                }
                invalidate();
                return true;

        }
        return super.onTouchEvent(event);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        //TouchEventUtils.clacifyAction(ev, "CustomHorScrollView dispatchTouchEvent");
        return super.dispatchTouchEvent(ev);
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

    @Override
    public void computeScroll() {
        // 第三步，重写computeScroll()方法，并在其内部完成平滑滚动的逻辑
        if (mScroller.computeScrollOffset()) {
            //Logger.e("getCurrX: " + mScroller.getCurrX());
            scrollTo(mScroller.getCurrX(), mScroller.getCurrY());
            mOldOffset = mScroller.getCurrX();
            invalidate();
        } else {
            /*
            int scrollx = getScrollX();
            if ((scrollx + (mSpaceWidth / 2)) % mSpaceWidth != 0) {
                int b = (scrollx + (mSpaceWidth / 2)) / mSpaceWidth;
                mScroller.startScroll(getScrollX(), 0, mSpaceWidth * b - getScrollX(), 0);
                invalidate();
            */


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
