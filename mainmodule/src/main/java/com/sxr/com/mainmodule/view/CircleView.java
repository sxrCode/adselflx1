package com.sxr.com.mainmodule.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.SweepGradient;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateInterpolator;


public class CircleView extends View {

    private static final int sSUM_ANGLE = 260;
    private Paint mArcPaint;
    private Paint mArc2Paint;
    private float mRate = 0;

    public CircleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        mArcPaint = new Paint();
        mArcPaint.setAntiAlias(true);
        mArcPaint.setStrokeWidth(20);
        mArcPaint.setStyle(Paint.Style.STROKE);
        mArcPaint.setStrokeJoin(Paint.Join.ROUND);
        mArcPaint.setStrokeCap(Paint.Cap.ROUND);
        mArcPaint.setColor(Color.parseColor("#6D738F"));

        mArc2Paint = new Paint();
        mArc2Paint.setAntiAlias(true);
        mArc2Paint.setStrokeWidth(18);
        mArc2Paint.setStrokeJoin(Paint.Join.ROUND);
        mArc2Paint.setStrokeCap(Paint.Cap.ROUND);
        mArc2Paint.setStyle(Paint.Style.STROKE);

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        Log.e("CircleView measure", "widthMeasureSpec: " + widthMeasureSpec + "; heightMeasureSpec: " + heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        Log.e("CircleView layout: ", "left: " + left + " right: " + right + " top: " + top + " bottom: " + bottom);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        float cx = getWidth() / 2;
        float cy = getHeight() / 2;
        mArc2Paint.setShader(new SweepGradient(cx, cy, Color.parseColor("#99A0B3"), Color.parseColor("#FAF9FC")));
        RectF oval = new RectF(15, 10, getWidth() - 15, getHeight() - 10);
        Log.e("CircleView ondraw: ", "lleft: " + oval.left + " lright: " + oval.right + " ltop: " + oval.top + " lbottom: " + oval.bottom);
        float propotion = 0;
        if (0 <= mRate && mRate <= 100) {
            propotion = sSUM_ANGLE * (mRate / 100);
        }
        canvas.drawArc(oval, -220, sSUM_ANGLE, false, mArcPaint);
        canvas.drawArc(oval, -220, propotion, false, mArc2Paint);
    }

    public void setRate(float rate) {
        ValueAnimator animator = ValueAnimator.ofFloat(0, rate);
        animator.setDuration(1500);
        animator.setInterpolator(new AccelerateInterpolator());
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float value = (float) animation.getAnimatedValue();
                mRate = value;
                invalidate();
            }
        });
        animator.start();
    }
}
