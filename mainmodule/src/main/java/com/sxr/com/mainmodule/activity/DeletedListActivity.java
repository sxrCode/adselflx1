package com.sxr.com.mainmodule.activity;

import android.support.v4.app.Fragment;

import com.sxr.com.mainmodule.fragment.DeletedListFragment;



public class DeletedListActivity extends SingleFragmentActivity {
    @Override
    protected Fragment getFragment() {
        return new DeletedListFragment();
    }
}
