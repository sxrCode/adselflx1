package com.sxr.com.mainmodule.activity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.support.v4.app.Fragment;
import android.view.ViewManager;
import android.view.ViewParent;
import android.view.WindowManager;
import android.widget.PopupWindow;

import com.sxr.com.mainmodule.fragment.DialogTestFragment;


public class DialogTestActivity extends SingleFragmentActivity {
    @Override
    protected Fragment getFragment() {
        return new DialogTestFragment();
    }
}
