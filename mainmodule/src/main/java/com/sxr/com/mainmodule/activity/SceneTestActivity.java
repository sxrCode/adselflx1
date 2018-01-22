package com.sxr.com.mainmodule.activity;

import android.support.v4.app.Fragment;

import com.sxr.com.mainmodule.fragment.SceneTestFragment;

/**
 * Created by Administrator on 2018/1/21.
 */

public class SceneTestActivity extends SingleFragmentActivity {
    @Override
    protected Fragment getFragment() {
        return new SceneTestFragment();
    }
}
