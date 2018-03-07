package com.sxr.com.mainmodule.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.transition.Slide;

import com.sxr.com.mainmodule.fragment.AnimationTestFragment;



public class AnimationTestActivity extends SingleFragmentActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected Fragment getFragment() {
        return new AnimationTestFragment();
    }
}
