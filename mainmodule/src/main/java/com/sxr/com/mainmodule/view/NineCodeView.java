package com.sxr.com.mainmodule.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.sxr.com.mainmodule.utils.MetricUtils;

import java.util.LinkedList;
import java.util.List;

public class NineCodeView extends View {

    private int mWidthSize;
    private int mHeightSize;

    private int lineWidth;//连接线宽
    private int bigCircleStrokeWidth; //空心圆线宽
    private int bigCircleRaidus; //空心圆半径
    private int solidCircleRadius;//实心圆半径
    private int detectiveRadius; //感知半径

    private int intervalWidth;
    private int intervalHeight;

    private int selectedColor = Color.GREEN;
    private final int unSelectedColor = Color.GRAY;

    private float currentPointX = -1;
    private float currentPointY = -1;

    private int topInterval = 0;
    private int leftInterval = 0;

    private boolean enable = true;

    private List<Integer> selectedCodes = new LinkedList<>();

    public NineCodeView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        lineWidth = MetricUtils.dip2px(context, 2);
        bigCircleStrokeWidth = MetricUtils.dip2px(context, 2);
        bigCircleRaidus = MetricUtils.dip2px(context, 20);
        solidCircleRadius = MetricUtils.dip2px(context, 5);
        detectiveRadius = MetricUtils.dip2px(context, 20);
        intervalWidth = MetricUtils.dip2px(context, 30);
        intervalHeight = MetricUtils.dip2px(context, 40);


    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        mWidthSize = MeasureSpec.getSize(widthMeasureSpec);
        mHeightSize = MeasureSpec.getSize(heightMeasureSpec);

        int actualWidth = bigCircleRaidus * 6 + intervalWidth * 4;
        int actualHeight = bigCircleRaidus * 6 + intervalHeight * 4;
        topInterval = (mHeightSize - actualHeight) / 2;
        leftInterval = (mWidthSize - actualWidth) / 2;
        Log.e("NineCodeView", "actualWidth: " + actualWidth + ", actualHeight: " + actualHeight);
    }

    @Override
    protected void onDraw(Canvas canvas) {

        //外边框
        canvas.save();

        Paint borderPaint = new Paint();
        borderPaint.setColor(Color.RED);
        borderPaint.setAntiAlias(true);
        borderPaint.setStrokeWidth(3);
        borderPaint.setStyle(Paint.Style.STROKE);

        Path borderPath = new Path();

        borderPath.moveTo(0, 0);
        borderPath.lineTo(mWidthSize, 0);
        borderPath.lineTo(mWidthSize, mHeightSize);
        borderPath.lineTo(0, mHeightSize);
        borderPath.lineTo(0, 0);
        canvas.drawPath(borderPath, borderPaint);

        canvas.restore();


        /////////////////////////////////////////////

        //绘制按钮
        canvas.save();
        canvas.translate(leftInterval, topInterval);

        Paint bigCirclePaint = new Paint();
        bigCirclePaint.setColor(unSelectedColor);
        bigCirclePaint.setStrokeWidth(bigCircleStrokeWidth);
        bigCirclePaint.setAntiAlias(true);
        bigCirclePaint.setStyle(Paint.Style.STROKE);

        Paint centralCirclePaint = new Paint();
        centralCirclePaint.setColor(unSelectedColor);
        centralCirclePaint.setAntiAlias(true);

        for (int index = 0; index < 9; index++) {
            canvas.save();
            int row = index / 3;
            int col = index % 3;

            if (selectedCodes.contains(index)) {
                bigCirclePaint.setColor(selectedColor);
                centralCirclePaint.setColor(selectedColor);
            } else {
                bigCirclePaint.setColor(unSelectedColor);
                centralCirclePaint.setColor(unSelectedColor);
            }

            canvas.translate((intervalWidth + bigCircleRaidus * 2) * col + bigCircleRaidus + intervalWidth, (intervalHeight + bigCircleRaidus * 2) * row + bigCircleRaidus + intervalHeight);
            canvas.drawCircle(0, 0, bigCircleRaidus, bigCirclePaint);
            canvas.drawCircle(0, 0, solidCircleRadius, centralCirclePaint);

            canvas.restore();
        }

        //绘制轨迹
        if (selectedCodes.size() > 1) { //当前有选中点才绘制轨迹
            canvas.save();

            Paint linePaint = new Paint();
            linePaint.setAntiAlias(true);
            linePaint.setColor(selectedColor);
            linePaint.setStyle(Paint.Style.STROKE);
            linePaint.setStrokeWidth(lineWidth);

            Path linePath = new Path();
            Point firstCentralPoint = calculateCentralPoint(selectedCodes.get(0));
            linePath.moveTo(firstCentralPoint.x, firstCentralPoint.y);

            for (int k = 0; k < selectedCodes.size(); k++) {
                Point centralPoint = calculateCentralPoint(selectedCodes.get(k));
                linePath.lineTo(centralPoint.x, centralPoint.y);
            }
            canvas.drawPath(linePath, linePaint);

            canvas.restore();
        }

        canvas.restore();

        ////////////////////////////////////////////////////////////////////////

        //绘制当前轨迹线
        if (selectedCodes.size() > 0 && currentPointX > 0 && currentPointY > 0) {
            canvas.save();

            Paint currentLinePaint = new Paint();
            currentLinePaint.setAntiAlias(true);
            currentLinePaint.setStrokeWidth(lineWidth);
            currentLinePaint.setStyle(Paint.Style.STROKE);
            currentLinePaint.setColor(selectedColor);

            Point lastcodePoint = calculateCentralPoint(selectedCodes.get(selectedCodes.size() - 1));
            canvas.drawLine(lastcodePoint.x + leftInterval, lastcodePoint.y + topInterval, currentPointX, currentPointY, currentLinePaint);

            canvas.restore();
        }
    }

    private Point calculateCentralPoint(int index) {
        Point point = new Point();
        point.x = (index % 3) * (bigCircleRaidus * 2 + intervalWidth) + bigCircleRaidus + intervalWidth;
        point.y = (index / 3) * (bigCircleRaidus * 2 + intervalHeight) + bigCircleRaidus + intervalHeight;
        return point;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float eventX = event.getX();
        float eventY = event.getY();

        if (enable) {
            switch (event.getAction()) {
                case MotionEvent.ACTION_MOVE:
                    if (eventX < 0 || eventY < 0) {
                        finish();
                    } else {
                        select(eventX, eventY);
                    }
                    break;
                case MotionEvent.ACTION_UP:
                    finish();
                    break;
            }
        }

        return true;
    }

    private void select(float x, float y) {
        int cellNum = judgement(x, y);
        if (cellNum >= 0 && cellNum <= 8) { //落入有效范围
            if (selectedCodes.indexOf(cellNum) <= -1) { //未包含

                //判断跨点选中情况
                if (selectedCodes.size() > 0) {
                    int oldSelectedCell = selectedCodes.get(selectedCodes.size() - 1); //取最后一个选中点
                    if ((Math.abs(oldSelectedCell - cellNum) == 2 && Math.floor(oldSelectedCell / 3) == Math.floor(cellNum / 3)) //同一行
                            || Math.abs(oldSelectedCell - cellNum) == 6 //同一列
                            || (oldSelectedCell + cellNum) == 8) { //对角线

                        int mediaCell = (oldSelectedCell + cellNum) / 2;
                        if (selectedCodes.indexOf(mediaCell) == -1) {
                            selectedCodes.add(mediaCell);
                        }
                    }
                }

                selectedCodes.add(cellNum);
            }
        }

        if (selectedCodes.size() > 0) {
            currentPointY = y;
            currentPointX = x;
            invalidate();
        }
    }

    private void finish() {


        if (selectedCodes.size() > 0) {
            Log.e("ninecode", selectedCodes.toString());
            currentPointX = -1;
            currentPointY = -1;

            changeToErrorState();
        }
    }

    /**
     * 清除已有状态
     */
    public void clear() {
        selectedCodes.clear();
        invalidate();
    }

    public void changeToErrorState() {
        enable = false;
        selectedColor = Color.rgb(255, 80, 0);
        invalidate();

        Handler handler = new Handler();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                enable = true;
                selectedColor = Color.GREEN;
                clear();
            }
        };
        handler.postDelayed(runnable, 600);
    }

    /**
     * 根据坐标判断是否选中点
     *
     * @param x
     * @param y
     * @return
     */
    private int judgement(float x, float y) {
        int result = -1;

        if (x > leftInterval && x < (mWidthSize - leftInterval) && y > topInterval && y < (mHeightSize - topInterval)) {
            float absX = (x - leftInterval) % (bigCircleRaidus * 2 + intervalWidth);
            float absY = (y - topInterval) % (bigCircleRaidus * 2 + intervalHeight);
            float orgX = bigCircleRaidus + intervalWidth;
            float orgY = bigCircleRaidus + intervalHeight;

            double distance = Math.sqrt(Math.pow(absX - orgX, 2) + Math.pow(absY - orgY, 2));
            if (distance < detectiveRadius) {
                int j = (int) Math.floor((x - leftInterval) / (bigCircleRaidus * 2 + intervalWidth));
                int i = (int) Math.floor((y - topInterval) / (bigCircleRaidus * 2 + intervalHeight));
                result = i * 3 + j;
            }
        }

        if (result > 8) result = -1;

        return result;
    }

}
