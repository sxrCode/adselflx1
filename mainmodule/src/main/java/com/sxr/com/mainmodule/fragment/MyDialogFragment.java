package com.sxr.com.mainmodule.fragment;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.sxr.com.mainmodule.R;
import com.sxr.com.mainmodule.view.FullScreenDialog;


public class MyDialogFragment extends DialogFragment {

    private Button mChooserBtn;

    private MyDialogFragmentDelegate mDelegate;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.bottom_dialog_container, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        FullScreenDialog fullScreenDialog = new FullScreenDialog(getContext());
        return fullScreenDialog;
    }

    public void setDelegate(MyDialogFragmentDelegate delegate) {
        mDelegate = delegate;
    }

    public interface MyDialogFragmentDelegate {
        public void choose();
    }
}
