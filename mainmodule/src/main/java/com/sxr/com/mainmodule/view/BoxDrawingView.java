package com.sxr.com.mainmodule.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.sxr.com.mainmodule.model.Box;

import java.util.ArrayList;
import java.util.List;


public class BoxDrawingView extends View {
    private static final String TAG = "BoxDrawingView";
    private Box mCurrentBox;
    private List<Box> mBoxen = new ArrayList<>();

    private Paint mBoxPaint;
    private Paint mBackgroundPaint;
    private Paint mArcPaint;
    private Paint mArc2Paint;

    public BoxDrawingView(Context context) {
        this(context, null);
    }

    public BoxDrawingView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mBackgroundPaint = new Paint();
        mBackgroundPaint.setColor(0x22ff0000);

        mBoxPaint = new Paint();
        mBoxPaint.setColor(0xfff8efe0);
        mBoxPaint.setStrokeWidth(2);

        mArcPaint = new Paint();
        mArcPaint.setAntiAlias(true);
        mArcPaint.setStrokeWidth(10);
        mArcPaint.setStyle(Paint.Style.STROKE);
        mArcPaint.setColor(Color.parseColor("blue"));

        mArc2Paint = new Paint();
        mArc2Paint.setAntiAlias(true);
        mArc2Paint.setStrokeWidth(8);
        mArc2Paint.setStyle(Paint.Style.STROKE);
        mArc2Paint.setColor(Color.parseColor("Yellow"));
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        PointF current = new PointF(event.getX(), event.getY());
        String action = "";

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                action = "ACTION_DOWN";
                mCurrentBox = new Box(current);
                mBoxen.add(mCurrentBox);
                break;
            case MotionEvent.ACTION_CANCEL:
                action = "ACTION_CANCEL";
                mCurrentBox = null;
                break;
            case MotionEvent.ACTION_MOVE:
                if (mCurrentBox != null) {
                    mCurrentBox.setCurrent(current);
                    invalidate();
                }
                action = "ACTION_MOVE";
                break;
            case MotionEvent.ACTION_UP:
                mCurrentBox = null;
                action = "ACTION_UP";
                break;
        }

        Log.i(TAG, action + " at x=" + current.x + ", y=" + current.y);

        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawPaint(mBackgroundPaint);

        RectF oval = new RectF(100, 100, 400, 400);
        canvas.drawArc(oval, -200, 300, false, mArcPaint);
        canvas.drawArc(oval, -200, 200, false, mArc2Paint);

        for (Box box : mBoxen) {
            float left = Math.min(box.getOrigin().x, box.getCurrent().x);
            float right = Math.max(box.getOrigin().x, box.getCurrent().x);
            float top = Math.min(box.getOrigin().y, box.getCurrent().y);
            float bottom = Math.max(box.getOrigin().y, box.getCurrent().y);
            //canvas.drawRect(left, top, right, bottom, mBoxPaint);
//            float cx = (box.getCurrent().x + box.getOrigin().x) / 2;
//            float cy = (box.getCurrent().y + box.getOrigin().y) / 2;
//            float radius = Math.min(Math.abs(box.getCurrent().x - box.getOrigin().x), Math.abs(box.getCurrent().y - box.getOrigin().y));
//            canvas.drawCircle(cx, cy, radius, mBoxPaint);

        }
    }
}
