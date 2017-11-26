package com.sxr.com.mainmodule.activity;

import android.support.v4.app.Fragment;

import com.sxr.com.mainmodule.fragment.ContractDetailFragment;

/**
 * Created by DELL on 2017/11/26.
 */

public class ContractDetailActivity extends SingleFragmentActivity {
    @Override
    protected Fragment getFragment() {
        return new ContractDetailFragment();
    }
}
