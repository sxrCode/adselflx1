package com.sxr.com.mainmodule.activity;

import android.support.v4.app.Fragment;

import com.sxr.com.mainmodule.fragment.CoordinateTestFragment;

public class CoordinateTestActivity extends SingleFragmentActivity {
    @Override
    protected Fragment getFragment() {
        return new CoordinateTestFragment();
    }
}
