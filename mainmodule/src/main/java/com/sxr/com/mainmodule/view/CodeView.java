package com.sxr.com.mainmodule.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.v7.widget.AppCompatEditText;
import android.util.AttributeSet;


public class CodeView extends AppCompatEditText {

    private int mHeight;
    private int mWidth;

    private int mCharCount;
    private int mContentCount;
    private String mContent;

    private int widthSpace = 10;
    private int heightSpacce = 10;

    private ICodeListener mCodeListener;

    public CodeView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.setBackgroundColor(Color.TRANSPARENT);
        this.setCursorVisible(false);
        mContentCount = 6;
    }

    public void setCodeListener(ICodeListener codeListener) {
        mCodeListener = codeListener;
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mHeight = h - widthSpace * 2;
        mWidth = w - heightSpacce * 2;
    }

    @Override
    protected void onTextChanged(CharSequence text, int start, int lengthBefore, int lengthAfter) {
        if (text.toString().length() <= mContentCount) {
            mCharCount = text.toString().length();
            mContent = text.toString();
            if (mCharCount == mContentCount) {
                if (mCodeListener != null) {
                    mCodeListener.onFinish(text.toString());
                }
            }
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        //drawLineStyle(canvas);
        drawFrameStyle(canvas);
    }

    private void drawLineStyle(Canvas canvas) {
        Paint linePaint = new Paint();
        int lineWidth = (int) ((mWidth / mContentCount) * 0.8);
        int lineSpace = (mWidth / mContentCount) - lineWidth;
        for (int i = 0; i < mContentCount; i++) {
            if (i == mCharCount) {
                linePaint.setColor(Color.parseColor("#3367FF"));
            } else {
                linePaint.setColor(Color.BLACK);
            }

            int linex = widthSpace + ((mWidth / mContentCount) * i) + (lineSpace / 2);
            int liney = heightSpacce + mHeight;
            canvas.drawLine(linex, liney, linex + lineWidth, liney, linePaint);
        }

        Paint textPaint = new Paint();
        textPaint.setAntiAlias(true);
        float textSize = getTextSize();
        textPaint.setTextSize(textSize);
        for (int i = 0; i < mCharCount; i++) {
            float textX = widthSpace + ((i * mWidth / mContentCount)) + ((mWidth / mContentCount) / 2) - (textSize / 4);
            canvas.drawText(mContent.substring(i, i + 1), textX, (float) mHeight, textPaint);
        }
    }

    private void drawCode(Canvas canvas) {
        Paint circlePaint = new Paint();
        circlePaint.setStyle(Paint.Style.FILL);
        circlePaint.setColor(Color.BLACK);
        for (int i = 1; i <= mCharCount; i++) {
            int radius = 10;
            int startX = ((mWidth / mContentCount) * i) - ((mWidth / mContentCount) / 2) + widthSpace;
            int startY = mHeight / 2 + heightSpacce;
            canvas.drawCircle(startX, startY, radius, circlePaint);
        }
    }

    private void drawFrameStyle(Canvas canvas) {
        RectF rectF = new RectF();
        rectF.set(widthSpace, heightSpacce, widthSpace + mWidth, heightSpacce + mHeight);

        Paint borderPaint = new Paint();
        borderPaint.setStrokeWidth(2);
        borderPaint.setStyle(Paint.Style.STROKE);
        borderPaint.setColor(Color.BLACK);
        canvas.drawRoundRect(rectF, 5, 5, borderPaint);

        int lineCount = mContentCount - 1;
        for (int i = 1; i <= lineCount; i++) {
            int linex = widthSpace + (mWidth / (mContentCount) * i);
            int liney = heightSpacce;
            canvas.drawLine(linex, liney, linex, liney + mHeight, borderPaint);
        }

        drawCode(canvas);
    }

    public interface ICodeListener {
        public void onFinish(String input);
    }
}
