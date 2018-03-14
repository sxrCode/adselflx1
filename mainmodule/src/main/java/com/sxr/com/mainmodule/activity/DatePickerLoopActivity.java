package com.sxr.com.mainmodule.activity;

import android.support.v4.app.Fragment;

import com.sxr.com.mainmodule.fragment.DatePickerLoopFragment;


public class DatePickerLoopActivity extends SingleFragmentActivity {
    @Override
    protected Fragment getFragment() {
        return new DatePickerLoopFragment();
    }
}
