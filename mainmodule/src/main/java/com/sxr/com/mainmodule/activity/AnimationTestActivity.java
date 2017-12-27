package com.sxr.com.mainmodule.activity;

import android.support.v4.app.Fragment;

import com.sxr.com.mainmodule.fragment.AnimationTestFragment;



public class AnimationTestActivity extends SingleFragmentActivity {
    @Override
    protected Fragment getFragment() {
        return new AnimationTestFragment();
    }
}
