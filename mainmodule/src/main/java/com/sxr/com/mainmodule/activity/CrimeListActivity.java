package com.sxr.com.mainmodule.activity;

import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatCheckBox;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

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
