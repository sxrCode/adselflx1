package com.sxr.com.mainmodule.activity;

import android.support.v4.app.Fragment;

import com.sxr.com.mainmodule.fragment.ScrollFragment;

/**
 * Created by Administrator on 2017/11/24.
 */

public class ScrollActivity extends SingleFragmentActivity {
    @Override
    protected Fragment getFragment() {
        return new ScrollFragment();
    }
}
