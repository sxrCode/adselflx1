package com.sxr.com.mainmodule.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;


public class SView extends LinearLayout {
    public SView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        //TouchEventUtils.clacifyAction(ev, "SView dispatchTouchEvent");
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //TouchEventUtils.clacifyAction(event, "SView onTouchEvent");
        return super.onTouchEvent(event);
    }
}
