package com.sxr.com.mainmodule.activity;

import android.support.v4.app.Fragment;

import com.sxr.com.mainmodule.fragment.FlowLayoutManagerFragment;


public class FlowLayoutManagerActivity extends SingleFragmentActivity {
    @Override
    protected Fragment getFragment() {
        return new FlowLayoutManagerFragment();
    }
}
