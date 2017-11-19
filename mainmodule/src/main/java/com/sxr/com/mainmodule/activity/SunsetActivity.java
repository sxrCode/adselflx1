package com.sxr.com.mainmodule.activity;

import android.support.v4.app.Fragment;

import com.sxr.com.mainmodule.fragment.SunsetFragment;

/**
 * Created by DELL on 2017/11/18.
 */

public class SunsetActivity extends SingleFragmentActivity {
    @Override
    protected Fragment getFragment() {
        return new SunsetFragment();
    }
}
