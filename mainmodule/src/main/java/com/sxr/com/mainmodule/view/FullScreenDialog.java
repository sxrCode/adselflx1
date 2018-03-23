package com.sxr.com.mainmodule.view;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;

import com.sxr.com.mainmodule.R;


public class FullScreenDialog extends Dialog {
    public FullScreenDialog(@NonNull Context context) {
        super(context);
    }

    @Override
    public void setContentView(@NonNull View view) {
        super.setContentView(view);
        getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
    }

    @Override
    public void setContentView(@NonNull View view, @Nullable ViewGroup.LayoutParams params) {
        super.setContentView(view, params);
        getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
    }

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        getWindow().getDecorView().setPadding(0, 0, 0, 0);
        getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        getWindow().setWindowAnimations(R.style.Full_Dialog_WindowAnim);
    }
}
