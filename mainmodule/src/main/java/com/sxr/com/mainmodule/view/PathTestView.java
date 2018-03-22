package com.sxr.com.mainmodule.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import com.sxr.com.mainmodule.R;


public class PathTestView extends View {
    /*圆角的半径，依次为左上角xy半径，右上角，右下角，左下角*/
    private float[] rids = {30.0f, 30.0f, 30.0f, 30.0f, 10.0f, 10.0f, 10.0f, 10.0f,};

    public PathTestView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        drawTest(canvas);

    }

    private void drawNormal(Canvas canvas) {
        Paint paint1 = new Paint();
        paint1.setColor(getResources().getColor(R.color.red1));

        Path path1 = new Path();
        path1.addCircle(150, 150, 100, Path.Direction.CW);
        Path path2 = new Path();
        path2.addCircle(200, 200, 100, Path.Direction.CW);
        path1.addPath(path2);

        RectF rectF = new RectF(300, 300, 400, 400);
        path1.addRoundRect(rectF, rids, Path.Direction.CW);
        canvas.drawPath(path1, paint1);
    }

    private void drawTest(Canvas canvas) {
        Path path3 = new Path();
        Paint paint2 = new Paint();
        RectF rectF2 = new RectF(500, 450, 600, 550);

        paint2.setColor(getResources().getColor(R.color.red1));
        path3.addRoundRect(rectF2, rids, Path.Direction.CW);
        path3.addRect(rectF2, Path.Direction.CW);
        path3.setFillType(Path.FillType.EVEN_ODD);
        canvas.drawPath(path3, paint2);
    }
}
