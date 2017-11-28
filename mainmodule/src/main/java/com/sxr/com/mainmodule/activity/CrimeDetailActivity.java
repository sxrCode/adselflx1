package com.sxr.com.mainmodule.activity;

import android.support.v4.app.Fragment;

import com.sxr.com.mainmodule.fragment.CrimeDetailFragmet;
import com.sxr.com.mainmodule.fragment.CrimentFragment;


public class CrimeDetailActivity extends SingleFragmentActivity {
    @Override
    protected Fragment getFragment() {
        return new CrimeDetailFragmet();
    }
}
