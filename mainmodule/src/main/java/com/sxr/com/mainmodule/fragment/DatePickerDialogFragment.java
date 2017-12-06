package com.sxr.com.mainmodule.fragment;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;

import com.sxr.com.mainmodule.R;


public class DatePickerDialogFragment extends DialogFragment {

    private int mContentLayout = R.layout.dialog_date;


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        View datePicker = LayoutInflater.from(getActivity()).inflate(mContentLayout, null);
        AlertDialog dialog = new AlertDialog.Builder(getActivity())
                .setView(datePicker)
                .create();
        Window window = dialog.getWindow();
        window.setGravity(Gravity.BOTTOM);
        window.setWindowAnimations(R.style.dialog_animation);
        //window.getDecorView().setPadding(0, 0, 0, 0);
        return dialog;
    }

    public void setContentLayout(int contentLayout) {
        mContentLayout = contentLayout;
    }
}
