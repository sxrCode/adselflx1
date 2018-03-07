package com.sxr.com.mainmodule.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.orhanobut.logger.Logger;
import com.sxr.com.mainmodule.R;
import com.sxr.com.mainmodule.fragment.MultiItemFragment1;
import com.sxr.com.mainmodule.fragment.MultiItemFragment2;
import com.sxr.com.mainmodule.fragment.MultiItemFragment3;


public class MultiFragmentActivity extends AppCompatActivity {
    protected int fragmentIndex = 1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
        gotoFragment(fragmentIndex);
    }

    public void gotoFragment(int index) {
        fragmentIndex = index;
        Logger.e("fragmentIndex: " + fragmentIndex);
        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment currentFragment = fragmentManager.findFragmentById(R.id.fragment_container);

        FragmentTransaction transition = fragmentManager.beginTransaction();
        transition.setCustomAnimations(R.anim.view_hor_enter, R.anim.view_hor_exit);

        Fragment fragment = getFragment(fragmentIndex);
        if (currentFragment == null) {
            if (fragment != null) {
                transition.add(R.id.fragment_container, fragment);
            }
        } else {
            transition.replace(R.id.fragment_container, fragment);
        }
        transition.commit();
    }

    public void nextFragment() {
        fragmentIndex++;
        gotoFragment(fragmentIndex);
    }

    public void beforeFragment() {
        fragmentIndex--;
        gotoFragment(fragmentIndex);
    }

    protected Fragment getFragment(int index) {
        switch (index) {
            case 1:
                return new MultiItemFragment1();
            case 2:
                return new MultiItemFragment2();
            case 3:
                return new MultiItemFragment3();
            default:
                return null;
        }
    }
}
