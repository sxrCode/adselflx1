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
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;


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
        mArc2Paint.setShader(new SweepGradient(250, 250, Color.parseColor("#99A0B3"), Color.parseColor("#FAF9FC")));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        RectF oval = new RectF(100, 100, 400, 400);
        float propotion = 0;
        if (0 <= mRate && mRate <= 100) {
            propotion = sSUM_ANGLE * (mRate / 100);
        }
        canvas.drawArc(oval, -220, sSUM_ANGLE, false, mArcPaint);
        canvas.drawArc(oval, -220, propotion, false, mArc2Paint);
    }

    public void setRate(float rate) {
        ValueAnimator animator = ValueAnimator.ofFloat(0, rate);
        animator.setDuration(1000);
        animator.setInterpolator(new AccelerateDecelerateInterpolator());
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
