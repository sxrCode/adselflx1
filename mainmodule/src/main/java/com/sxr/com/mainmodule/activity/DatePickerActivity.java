package com.sxr.com.mainmodule.activity;

import android.support.v4.app.Fragment;

import com.sxr.com.mainmodule.fragment.DatePickerFragment;


public class DatePickerActivity extends SingleFragmentActivity {
    @Override
    protected Fragment getFragment() {
        return new DatePickerFragment();
    }
}
