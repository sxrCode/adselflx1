package com.sxr.com.mainmodule.activity;

import android.support.v4.app.Fragment;

import com.sxr.com.mainmodule.fragment.CircleFragment;

/**
 * Created by DELL on 2017/12/3.
 */

public class CircleActivity extends SingleFragmentActivity {
    @Override
    protected Fragment getFragment() {
        return new CircleFragment();
    }
}
