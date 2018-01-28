package com.sxr.com.mainmodule.activity;


import android.support.v4.app.Fragment;

import com.sxr.com.mainmodule.fragment.SlideStudyFragment;

public class SlideStudyActivity extends SingleFragmentActivity {
    @Override
    protected Fragment getFragment() {
        return new SlideStudyFragment();
    }
}
