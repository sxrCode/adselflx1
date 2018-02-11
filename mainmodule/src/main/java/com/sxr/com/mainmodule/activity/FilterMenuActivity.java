package com.sxr.com.mainmodule.activity;

import android.support.v4.app.Fragment;

import com.sxr.com.mainmodule.fragment.FilterMenuFragment;


public class FilterMenuActivity extends SingleFragmentActivity {
    @Override
    protected Fragment getFragment() {
        return new FilterMenuFragment();
    }
}
