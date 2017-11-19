package com.sxr.com.mainmodule.model;

import android.graphics.PointF;

/**
 * Created by DELL on 2017/11/18.
 */

public class Box {

    private PointF origin;
    private PointF current;

    public Box(PointF origin) {
        this.origin = origin;
        this.current = origin;
    }

    public PointF getOrigin() {
        return origin;
    }

    public void setOrigin(PointF origin) {
        this.origin = origin;
    }

    public PointF getCurrent() {
        return current;
    }

    public void setCurrent(PointF current) {
        this.current = current;
    }
}
