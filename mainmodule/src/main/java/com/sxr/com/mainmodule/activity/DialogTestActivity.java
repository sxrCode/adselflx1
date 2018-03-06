package com.sxr.com.mainmodule.activity;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.util.AttributeSet;
import android.view.View;

import com.sxr.com.mainmodule.fragment.DialogTestFragment;


public class DialogTestActivity extends SingleFragmentActivity {
    @Override
    protected Fragment getFragment() {
        return new DialogTestFragment();
    }

    @Override
    public View onCreateView(String name, Context context, AttributeSet attrs) {

/*
        Window window = getWindow();
        WindowManager.LayoutParams lp = window.getAttributes();

        DisplayMetrics dm = new DisplayMetrics();
        window.getWindowManager().getDefaultDisplay().getMetrics(dm);
        int screenHeight = dm.heightPixels;
        lp.height = screenHeight / 2;
        window.setAttributes(lp);
*/

        return super.onCreateView(name, context, attrs);
    }
}
