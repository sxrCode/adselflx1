package com.sxr.com.mainmodule.activity;

import android.support.v4.app.Fragment;

import com.sxr.com.mainmodule.fragment.ColorOptionsFragment;

/**
 * Created by DELL on 2017/11/25.
 */

public class ColorOptionsActivity extends SingleFragmentActivity {
    @Override
    protected Fragment getFragment() {
        return new ColorOptionsFragment();
    }
}
