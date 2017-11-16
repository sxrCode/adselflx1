package com.sxr.com.mainmodule.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.sxr.com.mainmodule.R;

/**
 * Created by Administrator on 2017/11/16.
 */

public abstract class SingleFragmentActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
        FragmentManager fragmentManager = getSupportFragmentManager();
        if (fragmentManager.findFragmentById(R.id.fragment_container) == null) {
            fragmentManager.beginTransaction().add(R.id.fragment_container, getFragment()).commit();
        }
    }

    protected abstract Fragment getFragment();


}
