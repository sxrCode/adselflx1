package com.sxr.com.mainmodule.view;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import com.sxr.com.mainmodule.R;


public class FullScreenDialog extends Dialog {
    public FullScreenDialog(@NonNull Context context) {
        super(context);
    }

    @Override
    public void setContentView(@NonNull View view) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.setContentView(view);
        initProperty();
    }

    @Override
    public void setContentView(@NonNull View view, @Nullable ViewGroup.LayoutParams params) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.setContentView(view, params);
        initProperty();
    }

    @Override
    public void setContentView(int layoutResID) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.setContentView(layoutResID);
        initProperty();
    }

    private void initProperty() {
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        getWindow().getDecorView().setPadding(0, 0, 0, 0);
        getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        getWindow().setWindowAnimations(R.style.Full_Dialog_WindowAnim);
    }
}
