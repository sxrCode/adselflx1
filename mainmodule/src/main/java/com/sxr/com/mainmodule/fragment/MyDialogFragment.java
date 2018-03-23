package com.sxr.com.mainmodule.fragment;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import com.sxr.com.mainmodule.R;
import com.sxr.com.mainmodule.view.FullScreenDialog;


public class MyDialogFragment extends DialogFragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_file_chooser, container, false);
        //return super.onCreateView(inflater, container, savedInstanceState);
        return view;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        FullScreenDialog fullScreenDialog = new FullScreenDialog(getContext());
        fullScreenDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        fullScreenDialog.setContentView(R.layout.fragment_animator_test);
        return fullScreenDialog;
    }
}
