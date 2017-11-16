package com.sxr.com.mainmodule.activity;

import android.support.v4.app.Fragment;

import com.sxr.com.mainmodule.fragment.CrimeListFragment;

/**
 * Created by Administrator on 2017/11/16.
 */

public class CrimeListActivity extends SingleFragmentActivity {

    @Override
    protected Fragment getFragment() {
        CrimeListFragment fragment = new CrimeListFragment();
        return fragment;
    }
}
