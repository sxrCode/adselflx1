package com.sxr.com.mainmodule.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.sxr.com.mainmodule.R;


public class RadiusHeadView extends View {

    /*圆角的半径，依次为左上角xy半径，右上角，右下角，左下角*/
    private float[] rids = {30.0f, 30.0f, 30.0f, 30.0f, 0.0f, 0.0f, 0.0f, 0.0f,};

    private int mColor;
    private float mRadius;

    public RadiusHeadView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.RadiusView, 0, 0);
        mColor = typedArray.getColor(R.styleable.RadiusView_color, getResources().getColor(R.color.black));
        mRadius = typedArray.getFloat(R.styleable.RadiusView_radius, 0);
        typedArray.recycle();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.save();
        Path path1 = new Path();
        Paint paint1 = new Paint();
        int width = getWidth();
        int height = getHeight();
        RectF rectF = new RectF(0, 0, width, height);
        for(int i = 0; i < 4; i++) {
            rids[i] = mRadius;
        }
        paint1.setColor(mColor);
        paint1.setAntiAlias(true);
        path1.addRoundRect(rectF, rids, Path.Direction.CW);
        path1.addRect(rectF, Path.Direction.CW);
        path1.setFillType(Path.FillType.EVEN_ODD);
        canvas.drawPath(path1, paint1);
    }
}
