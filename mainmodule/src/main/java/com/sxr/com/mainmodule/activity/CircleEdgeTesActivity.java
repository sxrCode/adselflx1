package com.sxr.com.mainmodule.activity;


import android.support.v4.app.Fragment;

import com.sxr.com.mainmodule.fragment.CircleEdgeTestFragment;

public class CircleEdgeTesActivity extends SingleFragmentActivity {
    @Override
    protected Fragment getFragment() {
        return new CircleEdgeTestFragment();
    }
}
