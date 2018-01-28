package com.sxr.com.mainmodule.activity;

import android.support.v4.app.Fragment;
import android.view.MotionEvent;

import com.sxr.com.mainmodule.fragment.AnimatorFragment;


public class AnimatorActivity extends SingleFragmentActivity {
    @Override
    protected Fragment getFragment() {
        return new AnimatorFragment();
    }
}
