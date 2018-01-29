package com.sxr.com.mainmodule.utils;

import android.view.MotionEvent;

import com.orhanobut.logger.Logger;

/**
 * Created by Administrator on 2018/1/29.
 */

public class TouchEventUtils {

    public static void clacifyAction(MotionEvent ev, String note) {
        switch (ev.getAction() & MotionEvent.ACTION_MASK) {
            case MotionEvent.ACTION_DOWN:
                Logger.e(note + " MotionEvent Action: ACTION_DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                Logger.e(note + " MotionEvent Action: ACTION_MOVE");
                break;
            case MotionEvent.ACTION_UP:
                Logger.e(note + " MotionEvent Action: ACTION_UP");
                break;
            default:
                Logger.e(note + " MotionEvent Action: OTHER");
                break;
        }
    }
}
