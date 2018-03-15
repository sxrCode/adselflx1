package com.sxr.com.mainmodule.activity;

import android.support.v4.app.Fragment;

import com.sxr.com.mainmodule.fragment.NestedTestFragment;


public class NestedTestActivity extends SingleFragmentActivity {
    @Override
    protected Fragment getFragment() {
        return new NestedTestFragment();
    }
}
